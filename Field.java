import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.concurrent.CountDownLatch;

import javax.swing.*;

public class Field extends JFrame{
    private static int turno;
    private static final int ALTO = 800; //ancho de la ventana
    private static final int ANCHO = 1000; //largo de la ventana
    private static final int MED = 50; //cantidad de filas y columnas del juego
    
    private GridLayout lay = new  GridLayout(MED, MED);

    private int[][] terreno = new int[MED][MED];
    //1->AGUA
    //2->MONTAÑA1 3->MONTAÑA2

    //3->TERRENO1, 4->TERRENO2, 5->TERRENO3

    //Revisar
    private Reino r1;
    private Reino r2;
    //Revisar


    public Field(Reino r1, Reino r2){
        this.r1 = r1;
        this.r2 = r2;

        for(int i = 0; i <= 43; i++){
            for(int j = 0; j <= 3; j++){
                terreno[i][j] = 1;
            }
        }
        for(int i = 0; i <= 3; i++){
            for(int j = 0; j <= 43; j++){
                terreno[i][j] = 1;
            }
        }
        for(int i = 6; i <= 46; i++){
            for(int j = 46; j <= 49; j++){
                terreno[i][j] = 1;
            }
        }
        for(int i = 46; i <= 49; i++){
            for(int j = 6; j <= 49; j++){
                terreno[i][j] = 1;    
            }
        }
        for(int i = 6, j = 43; i <= 43 || j >=6; i++, j--){
                Random random = new Random();
                int var = random.nextInt(2);    
                if(var == 0 && terreno[i][j] != 1){
                    terreno[i][j] = 2;
                }else{
                    terreno[i][j] = 3;
                }
        }

        for(int i = 0; i < MED; i++){
            for(int j = 0; j < MED; j++){
                if(terreno[i][j] == 0 || terreno[i][j] == 10){
                    Random random = new Random();
                    int var = random.nextInt(3);    
                    if(var == 0){
                        terreno[i][j] = 4;
                    }else if (var == 1){
                        terreno[i][j] = 5;
                    }else{
                        terreno[i][j] = 6;
                    }
                }
            }
        }
        


        setTitle("Goty2024"); //Titulo de la ventana
        setSize(ANCHO, ALTO); //Dimensiones del juego

        setLayout(new BorderLayout());
        createContents(turno);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }



    public void createContents(int turno) {

        JPanel infoPanel = new JPanel(new BorderLayout());
        Font font = new Font("Arial", Font.PLAIN, 16);
        // Etiquetas para mostrar la información
        JLabel nameLabel = new JLabel();
        JLabel oroLabel = new JLabel();
        JLabel recursosLabel = new JLabel();
        JLabel manutencionLabel = new JLabel();
        
        // Configurar la información según el turno

        if (turno == 1) {
            nameLabel.setText("REINO 1: " + r1.getTipo());
            oroLabel.setText("Oro: " + r1.getDinero()+"                                                                   ");
            recursosLabel.setText("Recursos: " + r1.getRecursos()+"               "); 
            manutencionLabel.setText("Manutención: " + r1.getManuten());
        } else if (turno == 2) {
            nameLabel.setText("REINO 2: " + r2.getTipo());
            oroLabel.setText("Oro: " + r2.getDinero()+"                                                                   ");
            recursosLabel.setText("Recursos: " + r2.getRecursos()+"               ");
            manutencionLabel.setText("Manutención: " + r2.getManuten());
        }
        
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
        //add(titulo, BorderLayout.NORTH);
        //Primero imprimimos las dos fortalezas
        JPanel panelGen = new Fondo(lay, r1.getEpoca(), r2.getEpoca());

        JButton[][] arr = new JButton[MED][MED]; 
        for (int i = 0; i < MED; i++) {
            for (int j = 0; j < MED; j++) {
                arr[i][j] = new JButton("");
                panelGen.add(arr[i][j]);  
            }
        }
        //CREAMOS LAS ZONAS DE AGUA
        //Darle los iconos a los botones de agua
        for(int i = 0; i <= 43; i++){
            for(int j = 0; j <= 3; j++){
                arr[i][j].setIcon(new ImageIcon(getClass().getResource("images/map-water.jpeg")));
            }
        }
        for(int i = 0; i <= 3; i++){
            for(int j = 0; j <= 43; j++){
                arr[i][j].setIcon(new ImageIcon(getClass().getResource("images/map-water.jpeg")));
            }
        }
        for(int i = 6; i <= 46; i++){
            for(int j = 46; j <= 49; j++){
                arr[i][j].setIcon(new ImageIcon(getClass().getResource("images/map-water.jpeg")));
            }
        }
        for(int i = 46; i <= 49; i++){
            for(int j = 6; j <= 49; j++){
                arr[i][j].setIcon(new ImageIcon(getClass().getResource("images/map-water.jpeg")));
            }
        }
        //CREAMOS LAS ZONAS DE MONTAÑA
        //Darle los iconos a los botones de montaña
        for(int i = 6, j = 43; i <= 43 || j >=6; i++, j--){
                if(terreno[i][j] == 2){
                    arr[i][j].setIcon(new ImageIcon(getClass().getResource("images/map-montaña1.jpg")));
                }else if (terreno[i][j] == 3){
                    arr[i][j].setIcon(new ImageIcon(getClass().getResource("images/map-montaña2.jpg")));
                }
        }
        //Establecer las bases

        for(int i = 0; i < MED; i++){
            for(int j = 0; j < MED; j++){
                    if(terreno[i][j] == 4){
                        arr[i][j].setIcon(new ImageIcon(getClass().getResource("images/map-land1.jpg")));
                    }else if (terreno[i][j] == 5){
                        arr[i][j].setIcon(new ImageIcon(getClass().getResource("images/map-land2.png")));
                    }else if (terreno[i][j] == 6){
                        arr[i][j].setIcon(new ImageIcon(getClass().getResource("images/map-land3.jpg")));
                    }
            }
        }
        for(int i = MED - 6; i < MED; i++){
            for (int j = 0; j < 6; j++) {
                arr[i][j].setIcon(null);
                arr[i][j].setOpaque(false);
                arr[i][j].setContentAreaFilled(false);
                arr[i][j].setBorderPainted(false);                
                arr[i][j].addActionListener(new ListenerBase(1));
            }
        }
        
        for(int i = 0; i < 6; i++){
            for (int j = MED - 6; j < MED; j++) {
                arr[i][j].setIcon(null);
                arr[i][j].setOpaque(false);
                arr[i][j].setContentAreaFilled(false);
                arr[i][j].setBorderPainted(false);                
                arr[i][j].addActionListener(new ListenerBase(2));
            }
        }

        //Imprimimos a los ejercitos y edificios restantes
        
        
        for (int i = 0; i < MED; i++) {
            for (int j = 0; j < MED; j++) {
                for (Unit u: r1.getUnidades()) {
                    if (u.getFila() == i && u.getColumna() == j) {
                        System.out.println("El reino 1 tiene una unidad en las coordenadas " + i + " " + j);
                        arr[i][j].setIcon(null);
                        arr[i][j].setBackground(Color.RED);
                        arr[i][j].setOpaque(true);                       
                        break;
                    }
                }
                for (Unit u: r2.getUnidades()) {
                    if (u.getFila() == i && u.getColumna() == j) {
                        System.out.println("El reino 2 tiene una unidad en las coordenadas " + i + " " + j);
                        arr[i][j].setIcon(null);
                        arr[i][j].setBackground(Color.BLUE);
                        arr[i][j].setOpaque(true);                       
                        break;
                    }
                }
                arr[i][j].addActionListener(new ButtonListener(i, j));
            }
        }

        add(panelGen, BorderLayout.CENTER);

        System.out.println("Create contens terminado");
    }
    private class ListenerBase implements ActionListener{
        private int opt;
        public ListenerBase(int i){
            opt = i;
        }
        public void actionPerformed(ActionEvent e) {
            if(opt == 1 && turno%2 == 0){
                JOptionPane.showMessageDialog(null, "MOSTRAR DATOS DE PREPARACION DEL EJERCITO 1");
            }else if(opt == 2 && turno%2 == 1){
                JOptionPane.showMessageDialog(null, "MOSTRAR DATOS DE PREPARACION DEL EJERCITO 2");
            }
        }
    }
    private int filaSeleccion = -1;
    private int columnaSeleccion = -1;

    private CountDownLatch latch = new CountDownLatch(1);

    private class ButtonListener implements ActionListener {
        private int f;
        private int c;
        public ButtonListener(int f, int c) {
            this.f = f;
            this.c = c;
        }
        public void actionPerformed(ActionEvent e) {
            //Abrir el menu del determinado soldado
            filaSeleccion = f;
            columnaSeleccion = c;
            latch.countDown(); 
        }
    }
    public int[] getCoordenadas() {
        System.out.println("Seleccione coordenadas");
        try {
            System.out.println("wait");
            latch.await(); 
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int[] arr = new int[2];
        arr[0] = filaSeleccion + 1;
        arr[1] = columnaSeleccion + 1;
        filaSeleccion = -1;
        columnaSeleccion = -1;
        latch = new CountDownLatch(1);
        System.out.println(arr[0] + " " + arr[1]);
        return arr;
    }
    public void repintar(int turno){
        getContentPane().removeAll(); 
        createContents(turno); 
        revalidate(); 
        repaint();    
    }
    public Reino getReino1(){
        return r1;
    }
    public Reino getReino2(){
        return r2;
    }
 


}

