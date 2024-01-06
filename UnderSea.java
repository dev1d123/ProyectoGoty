import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
public class UnderSea extends Buildings{
    public UnderSea(){
        super("UnderSea", 900);
        acciones.add("Generar submarinos: 500 dinero - 400 recursos - 15 manutencion"); //cod 26
        acciones.add("Generar titan: 2500 dinero - 2000 recursos - 40 manutencion"); //cod 26
    }

    public ArrayList<String> getHabilidades(){
        return acciones;
    }
    public ImageIcon getIcon(){
        return new ImageIcon(getClass().getResource("images/UnderSea.jpeg"));
    }
    public void hacerAccion(Reino r){
        int o = this.getOpcionEdificio();
        if(o == 0){
            Unit crear = new Unit_Submarino();
            Unit.crearUnidad(crear, r);
        }else if(o == 1){
            Unit crear = new Unit_Titan();
            Unit.crearUnidad(crear, r);
        }
    }
}