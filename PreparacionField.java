import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;

import javax.swing.*;

public class PreparacionField extends JFrame {
    private int opcionSeleccionada;
    private CountDownLatch latch = new CountDownLatch(1);
    private Reino r;
    private boolean estaSeleccionando = false;
    private JButton[][] arr = new JButton[10][10];

    private boolean esDia;

    public PreparacionField(Reino r, boolean esDia) {
        this.esDia = esDia;
        this.r = r;
        setTitle(r.getTipo());
        setSize(600, 600);
        setLayout(new BorderLayout());
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                latch.countDown();
                dispose();
            }
        });        
        createContents();
        setLocationRelativeTo(null);
    }

    public void setDia(boolean v){
        esDia = v;
    }


    public void createContents() {

        JPanel panelGen = new FondoPreparacion(new GridLayout(10, 10), esDia);
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                arr[i][j] = new JButton("");
                arr[i][j].setOpaque(false);
                arr[i][j].setContentAreaFilled(false); // Establecer el área de contenido transparente
                arr[i][j].addActionListener(new ListenerConstruir(i, j));
                panelGen.add(arr[i][j]);
            }
        }
        JPanel infoPanel = new JPanel(new BorderLayout());
        Font font = new Font("Arial", Font.PLAIN, 16);
        // Etiquetas para mostrar la información
        JLabel nameLabel = new JLabel();
        JLabel oroLabel = new JLabel();
        JLabel recursosLabel = new JLabel();
        JLabel manutencionLabel = new JLabel();
        
        // Configurar la información según el turno

        nameLabel.setText("REINO " + r.getAux() + ": " + r.getTipo());
        oroLabel.setText("Oro: " + r.getDinero()+"                           ");
        recursosLabel.setText("Recursos: " + r.getRecursos()+"               "); 
        manutencionLabel.setText("Manutención: " + r.getManutenActual() + " / " + r.getManutenMaxima());

        // Configurar colores de texto
        oroLabel.setForeground(Color.RED);
        recursosLabel.setForeground(Color.GRAY);
        manutencionLabel.setForeground(Color.ORANGE);
        nameLabel.setFont(font);
        oroLabel.setFont(font);
        recursosLabel.setFont(font);
        manutencionLabel.setFont(font);
        // Añadir etiquetas al panel
        infoPanel.add(nameLabel, BorderLayout.NORTH);
        infoPanel.add(oroLabel, BorderLayout.WEST);
        infoPanel.add(recursosLabel, BorderLayout.CENTER);
        infoPanel.add(manutencionLabel, BorderLayout.EAST);
        
        // Añadir el panel al contenedor principal (supongo que estás usando un contenedor principal)
        add(infoPanel, BorderLayout.NORTH);
        add(panelGen);
        for (int i = 6; i <= 9; i++) {
            for (int j = 3; j <= 6; j++) {
                arr[i][j].setBackground(Color.RED);
                arr[i][j].setOpaque(true);
                arr[i][j].addActionListener(new ListenerBase());

            }
        }
        
        for(Buildings b: r.getEdificios()){
            //ProyectoGoty\images\castle.png
            try {
                ImageIcon icono = b.getIcon();
                Image imagen = icono.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH);
                icono = new ImageIcon(imagen);
                
                arr[b.getFila()][b.getColumna()].setIcon(icono);

            
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "hahaha");
                e.printStackTrace();
            }
            arr[b.getFila()][b.getColumna()].addActionListener(new ListenerEdificio(b));

        }
    }

    //getHabilidades retorna solo un string...Lo mejor 
    private class ListenerEdificio implements ActionListener {
        private Buildings b;
        public ListenerEdificio(Buildings b){
            this.b = b;
        }
        
        public void actionPerformed(ActionEvent e) {
            b.hacerAccion(r);
            repintar();
            latch.countDown();
        }
    }
        
    private CountDownLatch latchCoordenadas = new CountDownLatch(1);

    private class ListenerBase implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            opcionSeleccionada = 1;
            repintar();
            latch.countDown();
        }
    }

    public int getOpcionSeleccionada() {
        try {
            latch.await(); 
        } catch (InterruptedException e) {
            e.printStackTrace();
        }    
        int sol = opcionSeleccionada;
        opcionSeleccionada = -1;
        latch = new CountDownLatch(1);
        return sol;
    }
    public void mostrar(){
        setVisible(true);
    }
    private int filaSeleccion = -1;
    private int columnaSeleccion = -1;
    //se crea una matriz de booleanos -> true donde haya un edificio.
    //Los eventListener se crean solo cuando se llama a construir
    public int[] getCoordenadas() {
        estaSeleccionando = true;
        JOptionPane.showMessageDialog(null, "Seleccione coordenadas para poner edificio");
        try {
            System.out.println("wait");
            System.out.println("El latch vale ->" + latchCoordenadas);
            latchCoordenadas.await(); 
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        int[] arr = new int[2];
        arr[0] = filaSeleccion + 1;
        arr[1] = columnaSeleccion + 1;
        //Añadimos el edificio
        System.out.println("Imprimir la opcion de Preparacion Menu en PreparacionField");
        filaSeleccion = -1;
        columnaSeleccion = -1;
        latchCoordenadas = new CountDownLatch(1);
        estaSeleccionando = false;
        System.out.println(arr[0] + " " + arr[1]);
        //
        System.out.println("Construyendo");
        return arr;
    }
    private class ListenerConstruir implements ActionListener{
        private int f;
        private int c;
        public ListenerConstruir(int f, int c) {
            this.f = f;
            this.c = c;
        }
        public void actionPerformed(ActionEvent e) {
            filaSeleccion = f;
            columnaSeleccion = c;
            if(estaSeleccionando){
                latchCoordenadas.countDown(); 
            }
        }
        
    }
    public void construir(int x, int y, Buildings edificioConstruido){
        edificioConstruido.setFila(x-1);
        edificioConstruido.setColumna(y-1);
        r.getEdificios().add(edificioConstruido);
        repintar();
    }
    public void repintar(){
        getContentPane().removeAll(); 
        createContents(); 
        revalidate(); 
        repaint();    
    }
}
