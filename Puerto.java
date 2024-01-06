import java.util.ArrayList;

import javax.swing.ImageIcon;
public class Puerto extends Buildings{
    public Puerto(){
        super("Puerto", 400);
        acciones.add("Producir barco pirata: 150 dinero - 100 oro - 5 manutencion"); //cod 5
    }

    public ArrayList<String> getHabilidades(){
        return acciones;
    }
    public ImageIcon getIcon(){
        return new ImageIcon(getClass().getResource("images/puerto.jpeg"));
    }
    public void hacerAccion(Reino r){
        int o = this.getOpcionEdificio();
        if(o == 0){
            Unit crear = new Unit_Pirata();
            Unit.crearUnidad(crear, r);
        }
    }
}