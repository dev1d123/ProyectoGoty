import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
public class Herreria extends Buildings{
    public Herreria(){
        super("Herreria", 700, 0, 0, 0);
        acciones.add("Armas magicas"); //cod 8
        acciones.add("Escudos Magicos"); //cod 9
        acciones.add("Evolucion bestial"); //cod 10
        acciones.add("Mejora magica"); //cod 11
        acciones.add("Destruir Edificio"); // cod 0    
    }

    public ArrayList<String> getHabilidades(){
        return acciones;
    }
    public ImageIcon getIcon(){
        return new ImageIcon(getClass().getResource("images/herreria.jpeg"));
    }
    public void hacerAccion(Reino r){
        int o = this.getOpcionEdificio();
        if(o == 0){
            JOptionPane.showMessageDialog(null, "despues");
        }
    }
}