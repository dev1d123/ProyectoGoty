import javax.swing.*;

public class Unit_Soldier extends Unit_Contemporaneo{
    public final int COSTO = 120;
    public final int MATPRIMA = 50;
    public final int MANUTEN = 5;

    public Unit_Soldier(){
        super("Soldier", 150, 50, 3, 1, 0);
        //luego se le añaden las filas y columnas 
        habilidades.add("HiperVelocidad");
    }
    public ImageIcon getIcon(){
        return null;
    }
    public int hacerAccion(Reino r, Field campo){
        int o = this.getOpcionUnidad();
        if(o == 1){
            JOptionPane.showMessageDialog(null, "HiperVelocidad");
        }
        return 117;
    }
}
