import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.concurrent.CountDownLatch;

public class MenuPrincipal extends JFrame {
    private JButton nuevaPartida;
    private JButton comoJugar;
    private JButton verHistoria;
    private JButton cargar;
    private static int opt = 0;
    private static boolean showMenu = true;
    private static CountDownLatch latch = new CountDownLatch(1);

    public static ImageIcon imgComoJugar = new ImageIcon(MenuPrincipal.class.getResource("images/comojugar.png"));
    public static ImageIcon imgHistoria = new ImageIcon(MenuPrincipal.class.getResource("images/historia.png"));

    public MenuPrincipal() {
        SwingUtilities.invokeLater(() -> {
            if (showMenu) {
                setSize(708, 708);
                setTitle("Menu Principal");
                setLayout(new BorderLayout());
                createContents();
                setLocationRelativeTo(null);
                setDefaultCloseOperation(EXIT_ON_CLOSE);
                setVisible(true);
            }
        });
    }

    public void createContents() {
        Font fuente = new Font("Book Antiqua", Font.PLAIN, 20);

        nuevaPartida = createStyledButton("Nueva partida", fuente);
        comoJugar = createStyledButton("Como jugar", fuente);
        verHistoria = createStyledButton("Ver historia", fuente);
        cargar = createStyledButton("Cargar Partida", fuente);

        JPanel panel = new MenuPrincipalFondo();
        panel.setLayout(new GridLayout(5, 1, 2, 2));

        panel.add(createStyledLabel("                              TIME MADNESS", 30));
        panel.add(nuevaPartida);
        panel.add(comoJugar);
        panel.add(cargar);
        panel.add(verHistoria);

        // Asignando listeners
        nuevaPartida.addActionListener(new Listener());
        comoJugar.addActionListener(new Listener());
        verHistoria.addActionListener(new Listener());
        cargar.addActionListener(new Listener());

        add(panel, BorderLayout.CENTER);
    }

    private JButton createStyledButton(String text, Font font) {
        JButton button = new JButton(text);
        button.setFont(font);
        button.setContentAreaFilled(false);
        button.setBorderPainted(false);
        return button;
    }

    private JLabel createStyledLabel(String text, int fontSize) {
        JLabel label = new JLabel(" " + text); // Agrega espacio para centrar
        label.setFont(new Font("Book Antiqua", Font.BOLD, fontSize));
        return label;
    }

    private class Listener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == nuevaPartida) {
                opt = 1;

            } else if (e.getSource() == comoJugar) {
                opt = 2;
                MenuGenerico m = new MenuGenerico("¿Como Jugar?", MenuPrincipal.imgComoJugar, false);

            } else if (e.getSource() == verHistoria) {
                opt = 3;
                MenuGenerico n = new MenuGenerico("Historia", MenuPrincipal.imgHistoria, false);

            } else if (e.getSource() == cargar) {
                opt = 4;
            }
            setVisible(false);
            latch.countDown();
        }
    }

    public static void main(String[] args) {
        MenuPrincipal menuPrincipal = new MenuPrincipal();
        
        try {
            latch.await();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(opt == 1){
            InicioJuego j = new InicioJuego();  
        }
        if(opt == 4) {
            CargarPartida.main(null);
        }
    }
}
