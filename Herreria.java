import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
public class Herreria extends Buildings{
    public Herreria(){
        super("Herreria", 700);
        acciones.add("Armas magicas"); //cod 8
        acciones.add("Escudos Magicos"); //cod 9
        acciones.add("Rellenar magia"); //cod 11
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
            JOptionPane.showMessageDialog(null, "Aplicando mejora de Armas Magicas");
            for(Unit u: r.getUnidades()){
                u.setAtaque(u.getAtaque() + 30);
            }
        }else if(o == 1){
            JOptionPane.showMessageDialog(null, "Aplicando mejora de Escudos Magicas");
            for(Unit u: r.getUnidades()){
                u.setDefensa(u.getDefensa() + 5);
            }
        }else if(o == 2){
            JOptionPane.showMessageDialog(null, "Rellenar puntos de habilidad");
            for(Unit u: r.getUnidades()){
                u.setPp(u.getPpMax());
            }
        }
    }
}