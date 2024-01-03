import javax.swing.*;

public class Unit_AirSoldier extends Unit_Contemporaneo{
    public final int COSTO = 240;
    public final int MATPRIMA = 50;
    public final int MANUTEN = 5;

    public Unit_AirSoldier(){
        super("AirSoldier", 200, 50, 3, 1, 0);
        //luego se le añaden las filas y columnas 
        habilidades.add("Rafaga");
    }
    public ImageIcon getIcon(){
        return null;
    }
    public int hacerAccion(Reino r, Field campos){
        int o = this.getOpcionUnidad();
        if(o == 1){
            JOptionPane.showMessageDialog(null, "Rafaga");
        }
        return 118;
    }
}
