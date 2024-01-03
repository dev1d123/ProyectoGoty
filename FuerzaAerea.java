import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
public class FuerzaAerea extends Buildings{
    public FuerzaAerea(){
        super("Fuerza Aerea", 500, 0, 0, 0);
        acciones.add("Generar caza"); //cod 55
        acciones.add("Generar aviones"); //cod 55
        acciones.add("Destruir Edificio"); // cod 0    
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
            JOptionPane.showMessageDialog(null, "Creando un caza");
            Unit crear = new Unit_Caza();
            r.getUnidades().add(crear);
        }else if(o == 1){
            JOptionPane.showMessageDialog(null, "Creando un avion");
            Unit crear = new Unit_Avion();
            r.getUnidades().add(crear);
        }else{
            JOptionPane.showMessageDialog(null, "Destruyendo un edificio");
        }
    }
}