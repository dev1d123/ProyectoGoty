import java.util.ArrayList;

import javax.swing.ImageIcon;
public class Granjas extends Buildings{
    public Granjas(){
        super("Granjas", 100, 0, 0, 0);
        acciones.add("Destruir Edificio"); // cod 0    
    }

    public ArrayList<String> getHabilidades(){
        return acciones;
    }
    public ImageIcon getIcon(){
        return new ImageIcon("ProyectoGoty\\images\\granja.jpeg");
    }
}