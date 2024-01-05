import java.awt.Graphics;

import javax.swing.*;
public class FondoGen extends JPanel {
    private ImageIcon img;
    public FondoGen(ImageIcon img){
        this.img = img;
    };
    public void paint(Graphics g){
        super.paintComponent(g);

        g.drawImage(img.getImage(), 0, 0, getWidth(), getHeight(), this);
    }

}
