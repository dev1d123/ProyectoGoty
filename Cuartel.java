import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
public class Cuartel extends Buildings{
    public Cuartel(){
        super("Cuartel", 750, 0, 0, 0);
        acciones.add("Producir militares"); //cod 16
        acciones.add("Destruir Edificio"); // cod 0    
    }

    public ArrayList<String> getHabilidades(){
        return acciones;
    }
    public ImageIcon getIcon(){
        return new ImageIcon(getClass().getResource("images/cuartel.jpeg"));
    }
    public void hacerAccion(Reino r){
        int o = this.getOpcionEdificio();
        if(o == 0){
            JOptionPane.showMessageDialog(null, "Creando un militar");
            Unit crear = new Unit_Militar();
            r.getUnidades().add(crear);
        }else{
            JOptionPane.showMessageDialog(null, "Destruyendo un edificio");
        }
    }
}