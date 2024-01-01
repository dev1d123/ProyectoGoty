import java.util.ArrayList;

import javax.swing.ImageIcon;
public class Marina extends Buildings{
    public Marina(){
        super("Marina", 750, 0, 0, 0);
        acciones.add("Producir portaaviones"); //cod 15
        acciones.add("Destruir Edificio"); // cod 0    
    }

    public ArrayList<String> getHabilidades(){
        return acciones;
    }
    public ImageIcon getIcon(){
        return new ImageIcon("ProyectoGoty\\images\\marina.jpg");
    }
}