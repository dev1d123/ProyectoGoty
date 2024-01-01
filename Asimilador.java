import java.util.ArrayList;

import javax.swing.ImageIcon;
public class Asimilador extends Buildings{
    public Asimilador(){
        super("Asimilador", 510, 0, 0, 0);
        acciones.add("Destruir Edificio"); // cod 0    
    }

    public ArrayList<String> getHabilidades(){
        return acciones;
    }
    public ImageIcon getIcon(){
        return new ImageIcon("ProyectoGoty\\images\\asimilador.jpeg");
    }
}