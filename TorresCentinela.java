import java.util.ArrayList;

import javax.swing.ImageIcon;
public class TorresCentinela extends Buildings{
    public TorresCentinela(){
        super("TorresCentinela", 700, 0, 0, 0);

        acciones.add("Destruir Edificio"); // cod 0    
    }

    public ArrayList<String> getHabilidades(){
        return acciones;
    }
    public ImageIcon getIcon(){
        return new ImageIcon("ProyectoGoty\\images\\centinela.jpeg");
    }
}