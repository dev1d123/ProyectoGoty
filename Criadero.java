import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
public class Criadero extends Buildings{
    public Criadero(){
        super("Criadero", 500, 0, 0, 0);
        acciones.add("Producir dragones"); //cod 6
        acciones.add("Destruir Edificio"); // cod 0    
    }

    public ArrayList<String> getHabilidades(){
        return acciones;
    }
    public ImageIcon getIcon(){
        return new ImageIcon(getClass().getResource("images/criadero.jpeg"));
    }
    public void hacerAccion(Reino r){
        int o = this.getOpcionEdificio();
        if(o == 0){
            JOptionPane.showMessageDialog(null, "Creando un dragon");
            Unit crear = new Unit_Dragon();
            r.getUnidades().add(crear);
        }else{
            JOptionPane.showMessageDialog(null, "Destruyendo un edificio");
        }
    }
}