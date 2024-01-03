import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
public class Factory extends Buildings{
    public Factory(){
        super("Factory", 500, 0, 0, 0);
        acciones.add("Generar un Soldier"); //cod 28
        acciones.add("Generar un AirSoldier"); //cod 28
        acciones.add("Generar un SeaSoldier"); //cod 28
        acciones.add("Destruir Edificio"); // cod 0    
    }

    public ArrayList<String> getHabilidades(){
        return acciones;
    }
    public ImageIcon getIcon(){
        return new ImageIcon(getClass().getResource("images/factory.png"));
    }

    public void hacerAccion(Reino r){
        int o = this.getOpcionEdificio();
        if(o == 0){
            JOptionPane.showMessageDialog(null, "Creando un Soldier");
            Unit crear = new Unit_Soldier();
            r.getUnidades().add(crear);
        }else if(o == 1){
            JOptionPane.showMessageDialog(null, "Creando un AirSoldier");
            Unit crear = new Unit_AirSoldier();
            r.getUnidades().add(crear);
        }else if(o == 2){
            JOptionPane.showMessageDialog(null, "Creando un SeaSoldier");
            Unit crear = new Unit_SeaSoldier();
            r.getUnidades().add(crear);
        }else{
            JOptionPane.showMessageDialog(null, "Destruyendo un edificio");
        }
    }
}