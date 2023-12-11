import java.awt.*;
import javax.swing.*;

public class Field extends JFrame{
    private static final int ALTO = 800; //ancho de la ventana
    private static final int ANCHO = 1000; //largo de la ventana
    private static final int MED = 45; //cantidad de filas y columnas del juego
    
    GridBagLayout lay = new  GridBagLayout();

    public Field(){
        setTitle("Goty2024"); //Titulo de la ventana
        setSize(ANCHO, ALTO); //Dimensiones del juego
        createContents();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
    //El metodo createContents, necesita un argumento que represente a las unidades de los dos jugadores.
    //Estas unidades deben tener por lo menos.....fila, columna, tamaño.
    //En otra clase se realiza el videojuego donde se avisa al usuario de movimientos incorrectos, etc.
    public void createContents() {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1;
        gbc.weighty = 1;
        JPanel panelGen = new JPanel(lay);

        for (int i = 0; i < MED; i++) {
            for (int j = 0; j < MED; j++) {
                JButton boton = new JButton("");
                gbc.gridx = i; 
                gbc.gridy = j;  
                gbc.gridwidth = 1;
                gbc.gridheight = 1;
                //LINEAS DE PRUEBA------------------------------------------------------------------------------------
                if(i == 4 && j == 49){
                    gbc.gridwidth = 2;
                    gbc.gridheight = 2;
                }

                if(i == 7 && j == 34){
                    gbc.gridwidth = 3;
                    gbc.gridheight = 3;
                }
                if(i == MED - 7 && j == MED - 7){
                    gbc.gridwidth = 6;
                    gbc.gridheight = 6;
                }
                if(i == MED/2 && j == MED/2){
                    ImageIcon icono = new ImageIcon("images/castle.png"); //utilizar try catch
                    Image imagen = icono.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
                    icono = new ImageIcon(imagen);
                    boton.setIcon(icono);
                    gbc.gridwidth = 10;
                    gbc.gridheight = 10;
                }
                //-----------------------------------------------------------------------------------------------------
                panelGen.add(boton, gbc);  
            }
        }
        add(panelGen);
    }
    public static void main(String[] args){
        Field prueba = new Field();
    }
}