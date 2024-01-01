import java.util.ArrayList;

import javax.swing.ImageIcon;
public class Domo extends Buildings{
    public Domo(){
        super("Domo", 200, 0, 0, 0);
        acciones.add("Destruir Edificio"); // cod 0    
    }

    public ArrayList<String> getHabilidades(){
        return acciones;
    }
    public ImageIcon getIcon(){
        return new ImageIcon("ProyectoGoty\\images\\domo.jpg");
        
    }
}