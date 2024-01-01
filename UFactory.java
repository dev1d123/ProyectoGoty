import java.util.ArrayList;

import javax.swing.ImageIcon;
public class UFactory extends Buildings{
    public UFactory(){
        super("UFactory", 550, 0, 0, 0);
        acciones.add("Generar ufo"); //cod 27
        acciones.add("Destruir Edificio"); // cod 0    
    }

    public ArrayList<String> getHabilidades(){
        return acciones;
    }
    public ImageIcon getIcon(){
        return new ImageIcon("ProyectoGoty\\images\\UFactory.jpeg");
    }
}