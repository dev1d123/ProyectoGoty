import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class MenuPrincipalFondo extends JPanel {

    public MenuPrincipalFondo() {}
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        ImageIcon imagen = new ImageIcon(getClass().getResource("images/menuP.jpg"));
        g.drawImage(imagen.getImage(), 0, 0, 708, 708, this);
    }
}
