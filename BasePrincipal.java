import java.util.ArrayList;

import javax.swing.ImageIcon;
public class BasePrincipal extends Buildings{
    public BasePrincipal(){
        super("BasePrincipal", 3000, 0, 0, 0);
        acciones.add("Mejorar Reino"); //cod 12
        acciones.add("Producir un obrero"); // cod 13
        acciones.add("Crear Edificio"); // cod 14
        acciones.add("Destruir Edificio (Rendirse)"); // cod 4    
    }

    public ArrayList<String> getHabilidades(){
        return acciones;
    }
    public ImageIcon getIcon(){
        return new ImageIcon("../images/baseprincipal.jpeg");
    }
}