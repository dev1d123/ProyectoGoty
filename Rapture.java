import java.util.ArrayList;

import javax.swing.ImageIcon;
public class Rapture extends Buildings{
    public Rapture(){
        super("Rapture", 3500, 0, 0, 0);
        acciones.add("Mejorar Reino"); //cod 23
        acciones.add("Fabricar un trabajador"); // cod 24
        acciones.add("Crear Edificio"); // cod 25
        acciones.add("Destruir Edificio (Rendirse)"); // cod 4    
    }

    public ArrayList<String> getHabilidades(){
        return acciones;
    }
    public ImageIcon getIcon(){
        return new ImageIcon("ProyectoGoty\\images\\rapture.jpeg");
    }
}