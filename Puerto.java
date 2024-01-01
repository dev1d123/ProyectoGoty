import java.util.ArrayList;

import javax.swing.ImageIcon;
public class Puerto extends Buildings{
    public Puerto(){
        super("Puerto", 1000, 0, 0, 0);
        acciones.add("Producir barco pirata"); //cod 5
        acciones.add("Destruir Edificio"); // cod 0    
    }

    public ArrayList<String> getHabilidades(){
        return acciones;
    }
    public ImageIcon getIcon(){
        return new ImageIcon("ProyectoGoty\\images\\puerto.jpeg");
    }
}