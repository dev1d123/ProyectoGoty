import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
public class UFactory extends Buildings{
    public UFactory(){
        super("UFactory", 550, 0, 0, 0);
        acciones.add("Generar ufo"); //cod 27
        acciones.add("Generar crucero de batalla"); //cod 27
        acciones.add("Destruir Edificio"); // cod 0    
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
            JOptionPane.showMessageDialog(null, "Creando un ufo");
            Unit crear = new Unit_Ufo();
            r.getUnidades().add(crear);
        }else if(o == 1){
            JOptionPane.showMessageDialog(null, "Creando un crucero de batalla");
            Unit crear = new Unit_CruceroBatalla();
            r.getUnidades().add(crear);
        }else{
            JOptionPane.showMessageDialog(null, "Destruyendo un edificio");

        }
    }
}