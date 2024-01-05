import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.concurrent.CountDownLatch;

public class MenuPrincipal extends JFrame {
    private JButton nuevaPartida;
    private JButton comoJugar;
    private JButton verHistoria;
    private JButton estadisticas;
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
        estadisticas = createStyledButton("Ver estadisticas", fuente);

        JPanel panel = new MenuPrincipalFondo();
        panel.setLayout(new GridLayout(5, 1, 2, 2));

        panel.add(createStyledLabel("TITULO DEL JUEGO", 30));
        panel.add(nuevaPartida);
        panel.add(comoJugar);
        panel.add(estadisticas);
        panel.add(verHistoria);

        // Asignando listeners
        nuevaPartida.addActionListener(new Listener());
        comoJugar.addActionListener(new Listener());
        verHistoria.addActionListener(new Listener());
        estadisticas.addActionListener(new Listener());

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
            } else if (e.getSource() == verHistoria) {
                opt = 3;
            } else if (e.getSource() == estadisticas) {
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

        switch (opt) {
            case 1:
                InicioJuego j = new InicioJuego();
                break;
                case 2:
                MenuGenerico m = new MenuGenerico("¿Como Jugar?", MenuPrincipal.imgComoJugar, false);
                break;
            case 3:
                MenuGenerico n = new MenuGenerico("Historia", MenuPrincipal.imgHistoria, false);
                break;
            case 4:
                GenerarHistorial g = new GenerarHistorial();
                break;
        }
    }
}
