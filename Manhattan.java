import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
public class Manhattan extends Buildings{
    public Manhattan(){
        super("Manhattan", 700, 0, 0, 0);
        acciones.add("Adiestramiento biotecnologico"); //cod 19
        acciones.add("Medicina avanzada"); //cod 20
        acciones.add("Equipamiento Balistico"); //cod 21
        acciones.add("Misil Nuclear"); //cod 22

        acciones.add("Destruir Edificio"); // cod 0    
    }

    public ArrayList<String> getHabilidades(){
        return acciones;
    }
    public ImageIcon getIcon(){
        return new ImageIcon(getClass().getResource("images/manhattan.jpg"));
    }
    public void hacerAccion(Reino r){
        int o = this.getOpcionEdificio();
        if(o == 0){
            JOptionPane.showMessageDialog(null, "despues");
        }
    }
}