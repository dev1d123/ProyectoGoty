import java.util.ArrayList;

import javax.swing.ImageIcon;
public class Criadero extends Buildings{
    public Criadero(){
        super("Criadero", 500, 0, 0, 0);
        acciones.add("Producir dragones"); //cod 6
        acciones.add("Destruir Edificio"); // cod 0    
    }

    public ArrayList<String> getHabilidades(){
        return acciones;
    }
    public ImageIcon getIcon(){
        return new ImageIcon("ProyectoGoty\\images\\criadero.jpeg");
    }
}