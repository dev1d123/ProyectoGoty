import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
public class Arsenal extends Buildings{
    public Arsenal(){
        super("Arsenal", 300);
        acciones.add("Mejoras generales"); //cod 30

    }

    public ArrayList<String> getHabilidades(){
        return acciones;
    }
    public ImageIcon getIcon(){
        return new ImageIcon(getClass().getResource("images/arsenal.jpeg"));

    }
    public void hacerAccion(Reino r){
        int o = this.getOpcionEdificio();
        if(o == 0){
            for(Unit u: r.getUnidades()){
                JOptionPane.showMessageDialog(null, "Aplicando Mejoras Generales");
                u.setAtaque(u.getAtaque() + 30);
                u.setDefensa(u.getDefensa() + 5);
            }
        }
    }
}

