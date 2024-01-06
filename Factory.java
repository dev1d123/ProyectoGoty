import java.util.ArrayList;

import javax.swing.ImageIcon;
public class Factory extends Buildings{
    public Factory(){
        super("Factory", 700);
        acciones.add("Generar un Soldier: 120 dinero - 50 recursos - 5 manutencion"); //cod 28
        acciones.add("Generar un AirSoldier: 240 dinero - 50 recursos - 5 manutencion"); //cod 28
        acciones.add("Generar un SeaSoldier: 240 dinero - 50 recursos - 5 manutencion"); //cod 28
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
            Unit crear = new Unit_Soldier();
            Unit.crearUnidad(crear, r);
        }else if(o == 1){
            Unit crear = new Unit_AirSoldier();
            Unit.crearUnidad(crear, r);
        }else if(o == 2){
            Unit crear = new Unit_SeaSoldier();
            Unit.crearUnidad(crear, r);
        }
    }
}