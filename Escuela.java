import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
public class Escuela extends Buildings{
    public Escuela(){
        super("Escuela", 450);
        acciones.add("Producir soldados: 50 dinero - 30 recursos - 2 manutencion");
        acciones.add("Producir caballeros: 120 dinero - 45 recursos - 3 manutencion");
        acciones.add("Producir magos: 100 dinero - 0 recursos - 2 manutencion");
        acciones.add("Producir alquimistas: 200 dinero - 75 recursos - 3 manutencion");
    }

    public ArrayList<String> getHabilidades(){
        return acciones;
    }
    public ImageIcon getIcon(){
        return new ImageIcon(getClass().getResource("images/escuela.jpeg"));
    }
    //Metodo estatico de Unidad para validar si es posible crear una unidad segun los requisitos
    public void hacerAccion(Reino r){
        int o = this.getOpcionEdificio();
        if(o == 0){
            Unit crear = new Unit_Soldado();
            Unit.crearUnidad(crear, r);
        }else if(o == 1){
            Unit crear = new Unit_Caballero();
            Unit.crearUnidad(crear, r);
        }else if(o == 2){
            Unit crear = new Unit_Mago();
            Unit.crearUnidad(crear, r);
        }else if(o == 3){
            Unit crear = new Unit_Alquimista();
            Unit.crearUnidad(crear, r);
        }
        
    }


}