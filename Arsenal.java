import java.util.ArrayList;

import javax.swing.ImageIcon;
public class Arsenal extends Buildings{
    public final int COSTO = 100;
    public Arsenal(){
        super("Arsenal", 520, 0, 0, 0);
        acciones.add("Evolucion 1"); //cod 30
        acciones.add("Evolucion 1"); //cod 31
        acciones.add("Titan"); //cod 32
        acciones.add("Destruir Edificio"); // cod 0   
    }

    public ArrayList<String> getHabilidades(){
        return acciones;
    }
    public ImageIcon getIcon(){
        return new ImageIcon("ProyectoGoty\\images\\arsenal.jpeg");
    }
}