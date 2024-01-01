import java.util.ArrayList;

import javax.swing.ImageIcon;
public class Supermercado extends Buildings{
    public Supermercado(){
        super("Supermercado", 500, 0, 0, 0);
        acciones.add("Generar Manutencion"); //cod 17
        acciones.add("Generar Materia Prima"); //cod 18
        acciones.add("Destruir Edificio"); // cod 0    
    }

    public ArrayList<String> getHabilidades(){
        return acciones;
    }
    public ImageIcon getIcon(){
        return new ImageIcon("ProyectoGoty\\images\\mercado.jpeg");
    }
}