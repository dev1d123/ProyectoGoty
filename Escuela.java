import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
public class Escuela extends Buildings{
    public Escuela(){
        super("Escuela", 600, 0, 0, 0);
        acciones.add("Producir soldados");
        acciones.add("Producir magos");
        acciones.add("Producir alquimistas");
        acciones.add("Destruir Edificio");   
    }

    public ArrayList<String> getHabilidades(){
        return acciones;
    }
    public ImageIcon getIcon(){
        return new ImageIcon(getClass().getResource("images/escuela.jpeg"));
    }

    public void hacerAccion(Reino r){
        int o = this.getOpcionEdificio();
        if(o == 0){
            JOptionPane.showMessageDialog(null, "Creando un soldado");
            Unit crear = new Unit_Soldado();
            r.getUnidades().add(crear);
        }else if(o == 1){
            JOptionPane.showMessageDialog(null, "Creando un mago");
            Unit crear = new Unit_Mago();
            r.getUnidades().add(crear);
        }else if(o == 2){
            JOptionPane.showMessageDialog(null, "Creando un alquimista");
            Unit crear = new Unit_Alquimista();
            r.getUnidades().add(crear);
        }else{
            JOptionPane.showMessageDialog(null, "Destruyendo un edificio");
        }
    }

}