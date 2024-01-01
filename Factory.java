import java.util.ArrayList;

import javax.swing.ImageIcon;
public class Factory extends Buildings{
    public Factory(){
        super("Factory", 500, 0, 0, 0);
        acciones.add("Generar soldado"); //cod 28
        acciones.add("Generar titan"); //cod 29
        acciones.add("Destruir Edificio"); // cod 0    
    }

    public ArrayList<String> getHabilidades(){
        return acciones;
    }
    public ImageIcon getIcon(){
        return new ImageIcon("ProyectoGoty\\images\\factory.png");
    }
}