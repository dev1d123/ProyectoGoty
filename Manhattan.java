import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
public class Manhattan extends Buildings{
    public Manhattan(){
        super("Manhattan", 700);
        acciones.add("Adiestramiento biotecnologico"); 
        acciones.add("Medicina avanzada"); 
        acciones.add("Equipamiento Balistico"); 
        acciones.add("Misil Nuclear"); 

    }

    public ArrayList<String> getHabilidades(){
        return acciones;
    }
    public ImageIcon getIcon(){
        return new ImageIcon(getClass().getResource("images/manhattan.jpg"));
    }
    public void hacerAccion(Reino r){
        int o = this.getOpcionEdificio();
        if(o == 0){
            JOptionPane.showMessageDialog(null, "Adiestramiento biotecnologico");
            for(Unit u: r.getUnidades()){
                u.setVida(Math.max(u.getVidaMaxima(), u.getVida() + 50));
            }
        }else if(o == 1){
            JOptionPane.showMessageDialog(null, "Medicina avanzada");
            boolean isCheck = false;
            for(Unit u: r.getUnidades()){
                if(u instanceof Unit_Medico){
                    ((Unit_Medico) u).equiparMedicinaAvanzada();
                }
            }
            if(!isCheck){
                JOptionPane.showMessageDialog(null, "No tienes medicos para equiparlos con medicina");
            }
        }else if(o == 2){
            JOptionPane.showMessageDialog(null, "Equipamiento Balistico");
            for(Unit u: r.getUnidades()){
                    ((Unit_Contemporaneo)u).setBalasEspeciales();
            }
        }else if(o == 3){
            JOptionPane.showMessageDialog(null, "Misil Nuclear");
            boolean isCheck = false;
            for(Unit u: r.getUnidades()){
                if(u instanceof Unit_Caza){
                    ((Unit_Caza) u).equiparMisilNuclear();
                    JOptionPane.showMessageDialog(null, "Se equipo con un misil a un caza aleatorio!!!");
                    isCheck = true;
                    break;
                }
            }
            if(!isCheck){
                JOptionPane.showMessageDialog(null, "No tienes cazas para equiparlos con misiles");
            }
        }
    }
}