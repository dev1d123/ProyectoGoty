import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.CountDownLatch;

import javax.swing.*;

public class Field extends JFrame{
    private static final int ALTO = 800; //ancho de la ventana
    private static final int ANCHO = 1000; //largo de la ventana
    private static final int MED = 60; //cantidad de filas y columnas del juego
    

    GridLayout lay = new  GridLayout(MED, MED);

    //Revisar
    private Reino r1;
    private Reino r2;
    //Revisar


    public Field(Reino r1, Reino r2){
        setTitle("Goty2024"); //Titulo de la ventana
        setSize(ANCHO, ALTO); //Dimensiones del juego
        this.r1 = r1;
        this.r2 = r2;
        createContents();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }



    public void createContents() {
        //Primero imprimimos las dos fortalezas
        JPanel panelGen = new JPanel(lay);
        JButton[][] arr = new JButton[MED][MED]; 
        for (int i = 0; i < MED; i++) {
            for (int j = 0; j < MED; j++) {
                arr[i][j] = new JButton("");
                panelGen.add(arr[i][j]);  
            }
        }
        //Establecer las bases
        for(int i = MED - 6; i < MED; i++){
            for (int j = 0; j < 6; j++) {
                arr[i][j].addActionListener(new ListenerBase(1));
                
                arr[i][j].setBackground(Color.RED);
            }
        }
        for(int i = 0; i < 6; i++){
            for (int j = MED - 6; j < MED; j++) {
                arr[i][j].addActionListener(new ListenerBase(2));
                arr[i][j].setBackground(Color.BLUE);
            }
        }

        //Imprimimos a los ejercitos y edificios restantes
        
        
        for (int i = 0; i < MED; i++) {
            for (int j = 0; j < MED; j++) {
                for (Unit u: r1.getUnits()) {
                    if (u.getFila() == i && u.getColumna() == j) {
                        System.out.println("El reino 1 tiene una unidad en las coordenadas " + i + " " + j);
                        arr[i][j].setBackground(Color.RED);
                        break;
                    }
                }
                for (Unit u: r2.getUnits()) {
                    if (u.getFila() == i && u.getColumna() == j) {
                        System.out.println("El reino 2 tiene una unidad en las coordenadas " + i + " " + j);
                        arr[i][j].setBackground(Color.BLUE);
                        break;
                    }
                }
                arr[i][j].addActionListener(new ButtonListener(i, j));
            }
        }

        add(panelGen);
    }
    private class ListenerBase implements ActionListener{
        private int opt;
        public ListenerBase(int i){
            opt = i;
        }
        public void actionPerformed(ActionEvent e) {
            if(opt == 1){
                JOptionPane.showMessageDialog(null, "MOSTRAR DATOS DE PREPARACION DEL EJERCITO 1");
            }else{
                JOptionPane.showMessageDialog(null, "MOSTRAR DATOS DE PREPARACION DEL EJERCITO 2");
            }
        }
    }
    //Usado para retornar la fila y columna luego de seleccionar un soldado
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
        System.out.println("El count vale -> " + latch);
        try {
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
    public void repintar(){
        getContentPane().removeAll(); 
        createContents(); 
        revalidate(); 
        repaint();    
    }
}