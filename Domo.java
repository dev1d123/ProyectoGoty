import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
public class Domo extends Buildings{
    public Domo(){
        super("Domo", 100);
    }

    public ArrayList<String> getHabilidades(){
        return acciones;
    }
    public ImageIcon getIcon(){
        return new ImageIcon(getClass().getResource("images/domo.jpg"));
        
    }
    public void hacerAccion(Reino r){
        int ans = 0;
        for(Buildings b: r.getEdificios()){
            if(b instanceof Domo){
                ans++;
            }
        }
        JOptionPane.showMessageDialog(null, "Los domos te protegen de " + ans + " invasores");
    }
}