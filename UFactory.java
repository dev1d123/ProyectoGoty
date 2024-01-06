import java.util.ArrayList;

import javax.swing.ImageIcon;
public class UFactory extends Buildings{
    public UFactory(){
        super("UFactory", 800);
        acciones.add("Generar ufo: 700 dinero - 500 recursos - 15 manutencion"); //cod 27
        acciones.add("Generar crucero de batalla: 250 dinero - 200 recursos - 10 manutencion"); //cod 27
    }

    public ArrayList<String> getHabilidades(){
        return acciones;
    }
    public ImageIcon getIcon(){
        return new ImageIcon(getClass().getResource("images/UFactory.jpeg"));
    }
    public void hacerAccion(Reino r){
        int o = this.getOpcionEdificio();
        if(o == 0){
            Unit crear = new Unit_Ufo();
            Unit.crearUnidad(crear, r);
        }else if(o == 1){
            Unit crear = new Unit_CruceroBatalla();
            Unit.crearUnidad(crear, r);
        }
    }
}