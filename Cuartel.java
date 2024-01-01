import java.util.ArrayList;

import javax.swing.ImageIcon;
public class Cuartel extends Buildings{
    public Cuartel(){
        super("Cuartel", 750, 0, 0, 0);
        acciones.add("Producir militares"); //cod 16
        acciones.add("Destruir Edificio"); // cod 0    
    }

    public ArrayList<String> getHabilidades(){
        return acciones;
    }
    public ImageIcon getIcon(){
        return new ImageIcon("ProyectoGoty\\images\\cuartel.jpeg");
    }
}