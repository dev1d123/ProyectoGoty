import java.util.ArrayList;
import javax.swing.ImageIcon;
public class Criadero extends Buildings{
    public Criadero(){
        super("Criadero", 500);
        acciones.add("Producir dragones: 150 dinero - 70 recursos - 5 manutencion");
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
            Unit crear = new Unit_Dragon();
            Unit.crearUnidad(crear, r);
        }
    }
}