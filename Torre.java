import java.util.ArrayList;

import javax.swing.ImageIcon;
public class Torre extends Buildings{
    public Torre(){
        super("Torre", 700, 100, 50, 0);
        acciones.add("Destruir Edificio"); // cod 0    
    }

    public ArrayList<String> getHabilidades(){
        return acciones;
    }
    public ImageIcon getIcon(){
        return new ImageIcon("ProyectoGoty\\images\\torre.jpeg");
    }
}