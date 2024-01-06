import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
public class Torre extends Buildings{
    public Torre(){
        super("Torre", 100);
    }

    public ArrayList<String> getHabilidades(){
        return acciones;
    }
    public ImageIcon getIcon(){
        return new ImageIcon(getClass().getResource("images/torre.jpeg"));
    }
    public void hacerAccion(Reino r){
        int ans = 0;
        for(Buildings b: r.getEdificios()){
            if(b instanceof Granjas){
                ans++;
            }
        }
        JOptionPane.showMessageDialog(null, "Las torres te protejen de " + ans + " invasores");

    }
}