import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
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
        return new ImageIcon(getClass().getResource("images/mercado.jpeg"));
    }
    public void hacerAccion(Reino r){
        int o = this.getOpcionEdificio();
        if(o == 0){
            JOptionPane.showMessageDialog(null, "Generar manutencion");

        }else if(o == 1){
            JOptionPane.showMessageDialog(null, "Generar materia prima");

        }else{
            JOptionPane.showMessageDialog(null, "Destruyendo");

        }
    }
}