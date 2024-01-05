import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
public class TorresCentinela extends Buildings{
    public TorresCentinela(){
        super("TorresCentinela", 100);
    }
    public ArrayList<String> getHabilidades(){
        return acciones;
    }
    public ImageIcon getIcon(){
        return new ImageIcon(getClass().getResource("images/centinela.jpeg"));
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