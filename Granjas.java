import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
public class Granjas extends Buildings{
    public Granjas(){
        super("Granjas", 150);
    }

    public ArrayList<String> getHabilidades(){
        return acciones;
    }
    public final int MANUTEN_APORTADA = 6;

    public ImageIcon getIcon(){
        return new ImageIcon(getClass().getResource("images/granja.jpeg"));
    }
    public void hacerAccion(Reino r){
        int ans = 0;
        for(Buildings b: r.getEdificios()){
            if(b instanceof Granjas){
                ans+=((Granjas) b).MANUTEN_APORTADA;
            }
        }
        JOptionPane.showMessageDialog(null, "Aporte total de manutencion " + ans);

    }
}