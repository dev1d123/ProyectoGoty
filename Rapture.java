import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
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
        return new ImageIcon(getClass().getResource("images/rapture.jpeg"));
    }
    public void hacerAccion(Reino r){
        int o = this.getOpcionEdificio();
        if(o == 0){
            JOptionPane.showMessageDialog(null, "Destruyendo");
        }
    }
}