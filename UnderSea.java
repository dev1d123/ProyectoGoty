import java.util.ArrayList;

import javax.swing.ImageIcon;
public class UnderSea extends Buildings{
    public UnderSea(){
        super("UnderSea", 750, 0, 0, 0);
        acciones.add("Generar submarinos"); //cod 26
        acciones.add("Destruir Edificio"); // cod 0    
    }

    public ArrayList<String> getHabilidades(){
        return acciones;
    }
    public ImageIcon getIcon(){
        return new ImageIcon("ProyectoGoty\\images\\undersea.jpeg");
    }
}