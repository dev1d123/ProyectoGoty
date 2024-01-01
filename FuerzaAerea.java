import java.util.ArrayList;

import javax.swing.ImageIcon;
public class FuerzaAerea extends Buildings{
    public FuerzaAerea(){
        super("Fuerza Aerea", 500, 0, 0, 0);
        acciones.add("Generar caza"); //cod 55
        acciones.add("Destruir Edificio"); // cod 0    
    }

    public ArrayList<String> getHabilidades(){
        return acciones;
    }
    public ImageIcon getIcon(){
        return new ImageIcon("ProyectoGoty\\images\\fuerzaaerea.jpg");
    }
}