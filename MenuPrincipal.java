import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.concurrent.CountDownLatch;

public class MenuPrincipal extends JFrame {
    private JButton nuevaPartida;
    private JButton cargarPartida;
    private JButton estadisticas;
    private JButton crearEjercito;
    private JButton opciones;
    private static int opt = 0;
    private static CountDownLatch latch = new CountDownLatch(1);
    private Juego j = new Juego();
    public MenuPrincipal(){
        setSize(500, 500);
        setTitle("Menu Principal");
        setLayout(new BorderLayout());
        createContents();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);   
    }
    public void createContents(){
        Font fuente = new Font("Times New Roman", Font.PLAIN, 20);
        nuevaPartida = new JButton("Nueva partida");
        cargarPartida = new JButton("Cargar partida"); 
        estadisticas = new JButton("Ver estadisticas"); 
        crearEjercito = new JButton("Crear ejercito"); 
        opciones = new JButton("Opciones");
        nuevaPartida.setFont(fuente);
        cargarPartida.setFont(fuente);
        estadisticas.setFont(fuente);
        crearEjercito.setFont(fuente);
        opciones.setFont(fuente);

        JPanel panel = new JPanel(new GridLayout(5, 1, 2, 2));
        panel.add(nuevaPartida);
        panel.add(cargarPartida);
        panel.add(estadisticas);
        panel.add(crearEjercito);
        panel.add(opciones);
        //Asignando listeners
        nuevaPartida.addActionListener(new Listener());
        cargarPartida.addActionListener(new Listener());
        estadisticas.addActionListener(new Listener());
        crearEjercito.addActionListener(new Listener());
        opciones.addActionListener(new Listener());

        JLabel juegoLabel = new JLabel("<html><div style='text-align: center; font-size: 30px;'>Juego</div></html>");
        JLabel developedByLabel = new JLabel("<html><div style='text-align: center; font-size: 30px;'>Developed by: David & Gonzalo</div></html>");
        

        add(juegoLabel, BorderLayout.NORTH);
        add(panel, BorderLayout.CENTER);
        add(developedByLabel, BorderLayout.SOUTH);
        
    }

    private class Listener implements ActionListener{
        //Definir un constructor, con la opcion deseada y hacer un latch
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == nuevaPartida){
                setVisible(false);
                opt = 1;
            }else if(e.getSource() == cargarPartida){
                setVisible(false);
                opt = 2;
            }else if(e.getSource() == estadisticas){
                setVisible(false);
                opt = 3;
            }else if(e.getSource() == crearEjercito){
                setVisible(false);
                opt = 4;
            }else if(e.getSource() == opciones){
                setVisible(false);
                opt = 5;
            }
            setVisible(false);
            latch.countDown();
        }
    }

    public static void main(String[] args){
        MenuPrincipal menuPrincipal = new MenuPrincipal();
        try{
            latch.await();
        }catch (Exception e) {
            System.out.println("error");
            e.printStackTrace();
        }
        switch (opt) {
            case 1:
                System.out.println("Opcion1");
                InicioJuego j = new InicioJuego();
                break;
            case 2:
                System.out.println("Opcion 2");
                break;
            case 3:
                 System.out.println("Opcion 3");
                 break;
            case 4:
                System.out.println("Opcion 4");
                break;
            case 5:
                System.out.println("Opcion 5");
                break;
            default:
                break;
        }
    }


}
