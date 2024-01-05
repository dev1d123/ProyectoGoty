import java.util.ArrayList;

import javax.swing.ImageIcon;
public class Cuartel extends Buildings{
    public Cuartel(){
        super("Cuartel", 500);
        acciones.add("Producir militares: 60 dinero - 30 recursos - 2 manutencion"); //cod 16
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
            Unit crear = new Unit_Militar();
            Unit.crearUnidad(crear, r);
        }
    }
}