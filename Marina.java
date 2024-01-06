import java.util.ArrayList;

import javax.swing.ImageIcon;
public class Marina extends Buildings{
    public Marina(){
        super("Marina", 500);
        acciones.add("Producir portaaviones: 600 dinero - 150 recursos - 8m anutencion"); //cod 15
    }

    public ArrayList<String> getHabilidades(){
        return acciones;
    }
    public ImageIcon getIcon(){
        return new ImageIcon(getClass().getResource("images/marina.jpg"));
    }
    public void hacerAccion(Reino r){
        int o = this.getOpcionEdificio();
        if(o == 0){
            Unit crear = new Unit_Portaaviones();
            Unit.crearUnidad(crear, r);
        }
    }
}