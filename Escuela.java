import java.util.ArrayList;

import javax.swing.ImageIcon;
public class Escuela extends Buildings{
    public Escuela(){
        super("Escuela", 600, 0, 0, 0);
        acciones.add("Producir soldados"); //cod 7
        acciones.add("Destruir Edificio"); // cod 0    
    }

    public ArrayList<String> getHabilidades(){
        return acciones;
    }
    public ImageIcon getIcon(){
        return new ImageIcon("ProyectoGoty\\images\\escuela.jpeg");
    }

}