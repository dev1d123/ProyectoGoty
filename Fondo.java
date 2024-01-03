import java.awt.Graphics;
import java.awt.GridLayout;

import javax.swing.*;
public class Fondo extends JPanel {
    private char tipo1;
    private char tipo2;
    public Fondo(GridLayout wow, char tipo1, char tipo2){
        this.tipo1 = tipo1;
        this.tipo2 = tipo2;
        this.setLayout(wow);
    };
    public void paint(Graphics g){
            ImageIcon imagen1;
            if(tipo1 == 'I')
                imagen1 = new ImageIcon(getClass().getResource("images/map-imperioMedieval.jpg"));
            else if(tipo1 == 'R'){
                imagen1 = new ImageIcon(getClass().getResource("images/map-republicaContemporanea.jpg"));
            }else{
                imagen1 = new ImageIcon(getClass().getResource("images/map-dictaduraFuturista.jpg"));
            }
            g.drawImage(imagen1.getImage(), 18, 625, 120, 86, this);
            setOpaque(false);
            super.paint(g);

            ImageIcon imagen2;
            if(tipo2 == 'I')
                imagen2 = new ImageIcon(getClass().getResource("images/map-imperioMedieval.jpg"));
            else if(tipo2 == 'R'){
                imagen2 = new ImageIcon(getClass().getResource("images/map-republicaContemporanea.jpg"));
            }else{
                imagen2 = new ImageIcon(getClass().getResource("images/map-dictaduraFuturista.jpg"));
            }
            g.drawImage(imagen2.getImage(), 850, 10, 120, 86, this);
            setOpaque(false);
            super.paint(g);
        

    }

}
