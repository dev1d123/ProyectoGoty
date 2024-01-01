import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;

import javax.swing.*;

public class PreparacionField extends JFrame {
    private int opcionSeleccionada;
    private CountDownLatch latch = new CountDownLatch(1);
    private Reino r;
    private boolean estaSeleccionando = false;
    private JButton[][] arr = new JButton[10][10];

    public PreparacionField(Reino r) {
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

    public void createContents() {
        JPanel panelGen = new JPanel(new GridLayout(10, 10));
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                arr[i][j] = new JButton("");
                panelGen.add(arr[i][j]);
                arr[i][j].addActionListener(new ListenerConstruir(i, j));
            }
        }
        add(panelGen);
        for (int i = 6; i <= 9; i++) {
            for (int j = 3; j <= 6; j++) {
                arr[i][j].setBackground(Color.RED);
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
                e.printStackTrace();
                System.out.println("idiota");
            }
            arr[b.getFila()][b.getColumna()].addActionListener(new ListenerEdificio(b.getHabilidades()));

        }
    }
    private class ListenerEdificio implements ActionListener {
        private ArrayList<String> hab;
        public ListenerEdificio(ArrayList<String> hab){
            this.hab = hab;
        }
        
        public void actionPerformed(ActionEvent e) {
            //Lo vamos ha hacer con JOptionPane (no nos complicamos la vida)
            int seleccion = JOptionPane.showOptionDialog(
                    null,
                    "Selecciona una opción:",
                    "Menú de Opciones",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.PLAIN_MESSAGE,
                    null,
                    hab.toArray(), // Convertimos el ArrayList a un array
                    hab.get(0));   // Valor por defecto
            latch.countDown();
        }
    }
        
    private CountDownLatch latchCoordenadas = new CountDownLatch(1);

    private class ListenerBase implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            opcionSeleccionada = 1;
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
        System.out.println("Seleccionaste el indice " + x + ", " + y);
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

    //public static void main(String[] args) {
    //    PreparacionField c = new PreparacionField(null);
//
    //    while (true) {
    //        latch = new CountDownLatch(1);
    //        try {
    //            latch.await();
    //        } catch (Exception e) {
    //            System.out.println("error");
    //            e.printStackTrace();
    //        }
    //        int opt = getOpcionSeleccionada();
    //        System.out.println("La opcion seleccionada field es " + opt);
    //        if (opt == 1) {
    //            PreparacionMenu.main(null);
    //            opcionSeleccionada = 0;
    //        } else {
    //            JOptionPane.showMessageDialog(null, "NADA");
    //        }
    //        opt = 0;
    //    }
    //}
}
