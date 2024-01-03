import javax.swing.*;

public class Unit_Ufo extends Unit_Contemporaneo{
    public final int COSTO = 700;
    public final int MATPRIMA = 500;
    public final int MANUTEN = 15;

    public Unit_Ufo(){
        super("Ufo", 100, 50, 3, 1, 0);
        //luego se le añaden las filas y columnas 
        habilidades.add("Abducir");
        habilidades.add("Teletransportar");
        habilidades.add("Cañon de rayos gamma");
        habilidades.add("Campo electromagnetico");
    }
    public ImageIcon getIcon(){
        return null;
    }
    public int hacerAccion(Reino r, Field campo){
        int o = this.getOpcionUnidad();
        if(o == 1){
            JOptionPane.showMessageDialog(null, "Abducir");
            return 122;
        }else if(o == 2){
            JOptionPane.showMessageDialog(null, "Teletransportar");
            return 123;
        }else if(o == 3){
            JOptionPane.showMessageDialog(null, "Cañon de rayos gamma");
            return 124;
        }else{
            JOptionPane.showMessageDialog(null, "Campo Electromagnetico");
            return 70;
        }
    }
}
