import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class MenuPrincipal extends JFrame {
    private JButton nuevaPartida;
    private JButton cargarPartida;
    private JButton estadisticas;
    private JButton crearEjercito;
    private JButton opciones;
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
        cargarPartida = new JButton("Cargar partida"); //Las partidas generan un archivo de texto que indica los datos actuales de una partida.
        estadisticas = new JButton("Ver estadisticas"); //Utiliza las bases de datos creadas para cada soldado, y otro archivo para indicar las victorias de cada ejercito
        crearEjercito = new JButton("Crear ejercito"); //Utiliza la lectura y apertura de objetos en archivos de textos
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
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == nuevaPartida){
                setVisible(false);
                //Juego.main(null);
                //partida();
                //JOptionPane.showMessageDialog(null, "Nueva partida");
                System.exit(1);
            }else if(e.getSource() == cargarPartida){
                setVisible(false);
                JOptionPane.showMessageDialog(null, "Proximamente...");
                System.exit(1);
            }else if(e.getSource() == estadisticas){
                setVisible(false);
                JOptionPane.showMessageDialog(null, "Proximamente...");
                System.exit(1);
            }else if(e.getSource() == crearEjercito){
                setVisible(false);
                JOptionPane.showMessageDialog(null, "Proximamente...");
                System.exit(1);
            }else if(e.getSource() == opciones){
                setVisible(false);
                JOptionPane.showMessageDialog(null, "Proximamente...");
                System.exit(1);
            }
        }
    }
    public static void main(String[] args){
        MenuPrincipal menuPrincipal = new MenuPrincipal();
    }
}
