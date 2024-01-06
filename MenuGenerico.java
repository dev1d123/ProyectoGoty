import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MenuGenerico extends JFrame {
    private ImageIcon img;
    private boolean showMenu;

    public MenuGenerico(String title, ImageIcon img, boolean showMenu) {
        this.showMenu = showMenu;
        this.img = img;
        setTitle(title); // Título de la ventana
        setSize(1500, 800); // Dimensiones del juego

        setLayout(new FlowLayout());
        createContents();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void createContents() {
        JPanel fondoPanel = new FondoGen(img);

        fondoPanel.setLayout(new FlowLayout());

        JButton salir = new JButton("Atras");
        salir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new MenuPrincipal();
            }
        });
        
        fondoPanel.add(salir, BorderLayout.SOUTH);

        setContentPane(fondoPanel);
    }
}
