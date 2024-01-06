import java.util.ArrayList;

import javax.swing.ImageIcon;
public class FuerzaAerea extends Buildings{
    public FuerzaAerea(){
        super("Fuerza Aerea", 600);
        acciones.add("Generar caza: 300 dinero - 100 recursos - 4 manutencion"); //cod 55
        acciones.add("Generar aviones: 200 dinero - 100 recursos - 5 manutencion"); //cod 55
    }

    public ArrayList<String> getHabilidades(){
        return acciones;
    }
    public ImageIcon getIcon(){
        return new ImageIcon(getClass().getResource("images/fuerzaaerea.jpg"));
    }
    public void hacerAccion(Reino r){
        int o = this.getOpcionEdificio();
        if(o == 0){
            Unit crear = new Unit_Caza();
            Unit.crearUnidad(crear, r);
        }else if(o == 1){
            Unit crear = new Unit_Avion();
            Unit.crearUnidad(crear, r);
        }
    }
}