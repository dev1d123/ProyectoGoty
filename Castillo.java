import java.util.ArrayList;

import javax.swing.ImageIcon;
public class Castillo extends Buildings{
    public Castillo(){
        super("Castillo", 4000, 0, 0, 0);
        acciones.add("Mejorar Reino"); //cod 1
        acciones.add("Producir un esclavo"); // cod 2
        acciones.add("Crear Edificio"); // cod 3
        acciones.add("Destruir Edificio (Rendirse)"); // cod 4    
    }

    public ArrayList<String> getHabilidades(){
        return acciones;
    }
    public ImageIcon getIcon(){
        return new ImageIcon("../images/castillo.jpeg");
    }
}
