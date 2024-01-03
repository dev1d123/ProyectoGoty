import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
public class UnderSea extends Buildings{
    public UnderSea(){
        super("UnderSea", 750, 0, 0, 0);
        acciones.add("Generar submarinos"); //cod 26
        acciones.add("Generar titan"); //cod 26
        acciones.add("Destruir Edificio"); // cod 0    
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
            JOptionPane.showMessageDialog(null, "Creando un submarino");
            Unit crear = new Unit_Submarino();
            r.getUnidades().add(crear);
        }else if(o == 1){
            JOptionPane.showMessageDialog(null, "Creando un titan!!!");
            Unit crear = new Unit_Titan();
            r.getUnidades().add(crear);
        }else{
            JOptionPane.showMessageDialog(null, "Destruyendo un edificio");
        }
    }
}