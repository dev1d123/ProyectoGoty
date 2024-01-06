import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.Date;
import java.util.concurrent.CountDownLatch;

public class CargarPartida extends JFrame {
    private static Reino r1;
    private static Reino r2;
    private static CountDownLatch latch = new CountDownLatch(1);
    public CargarPartida() {
        setTitle("Archivo guardado de partidas");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 100);

        setLayout(new FlowLayout());
        cargarHistorial();

        setVisible(true);
    }

    private void cargarHistorial() {
        //Intentara abrir los 3 archivos...Para mostrar su informacion
        JButton botonSlot1;
        try{
            ObjectInputStream fileIn = new ObjectInputStream(new FileInputStream("ProyectoGoty/save/slot1.dat"));
            Date nombreSlot = (Date)fileIn.readObject();
            botonSlot1 = new JButton("Guardado: " + nombreSlot.toString());
            Reino reinoA = (Reino) fileIn.readObject();
            Reino reinoB = (Reino) fileIn.readObject();
            

            botonSlot1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(reinoA.getAux() == 1){
                        r1 = reinoA;
                        r2 = reinoB;
                    }else{
                        r1 = reinoB;
                        r2 = reinoA;
                    }      
                    dispose();
                    latch.countDown();        
                }
            });
        }catch(Exception e){
            System.out.println("Error en la lectura del primer archivo, asignando valores por defecto");
            System.out.println(e.getMessage());
            botonSlot1 = new JButton("Slot 1 vacio");
            botonSlot1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JOptionPane.showMessageDialog(null, "No hay datos en ese slot");
                }
            });
        }

        JButton botonSlot2;
        try{
            ObjectInputStream fileIn = new ObjectInputStream(new FileInputStream("ProyectoGoty/save/slot2.dat"));
            Date nombreSlot = (Date)fileIn.readObject();
            botonSlot2 = new JButton("Guardado: " + nombreSlot.toString());
            Reino reinoA = (Reino) fileIn.readObject();
            Reino reinoB = (Reino) fileIn.readObject();
            
            botonSlot2.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    if(reinoA.getAux() == 1){
                        r1 = reinoA;
                        r2 = reinoB;
                    }else{
                        r1 = reinoB;
                        r2 = reinoA;
                    }      
                    dispose();
                    latch.countDown();   
                }
            });
        }catch(Exception e){
            System.out.println("Error en la lectura del segundo archivo, asignando valores por defecto");
            System.out.println(e.getMessage());
            botonSlot2 = new JButton("Slot 2 vacio");
            botonSlot2.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JOptionPane.showMessageDialog(null, "No hay datos en ese slot");
                }
            });
        }

        JButton botonSlot3;
        try{
            ObjectInputStream fileIn = new ObjectInputStream(new FileInputStream("ProyectoGoty/save/slot3.dat"));
            Date nombreSlot = (Date)fileIn.readObject();
            botonSlot3 = new JButton("Guardado: " + nombreSlot.toString());
            Reino reinoA = (Reino) fileIn.readObject();
            Reino reinoB = (Reino) fileIn.readObject();
            
            botonSlot3.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    if(reinoA.getAux() == 1){
                        r1 = reinoA;
                        r2 = reinoB;
                    }else{
                        r1 = reinoB;
                        r2 = reinoA;
                    }
                    dispose();
                    latch.countDown();            
                       
                }
            });
        }catch(Exception e){
            System.out.println("Error en la lectura del tercer archivo, asignando valores por defecto");
            System.out.println(e.getMessage());
            botonSlot3 = new JButton("Slot 3 vacio");
            botonSlot3.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JOptionPane.showMessageDialog(null, "No hay datos en ese slot");
                }
            });
        }
        add(botonSlot1);
        add(botonSlot2);
        add(botonSlot3);
    }
    public static void main(String[] args){
        CargarPartida xd = new CargarPartida();

        try {
            System.out.println("wait");
            latch.await();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Juego.iniciarJuego(r1, r2);
    }
}
