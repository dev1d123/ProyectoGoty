import java.awt.Graphics;
import java.awt.GridLayout;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class FondoPreparacion extends JPanel {
    private boolean esDia;

    public FondoPreparacion(GridLayout wow, boolean esDia) {
        this.esDia = esDia;
        this.setLayout(wow);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        ImageIcon imagen;
        if (esDia) {
            imagen = new ImageIcon(getClass().getResource("images/dia.jpg"));
        } else {
            imagen = new ImageIcon(getClass().getResource("images/noche.jpg"));
        }
        g.drawImage(imagen.getImage(), 0, 0, 700, 600, this);
    }
}
