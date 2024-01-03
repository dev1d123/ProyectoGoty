import javax.swing.*;

public class Unit_Titan extends Unit_Contemporaneo{
    public final int COSTO = 2500;
    public final int MATPRIMA = 2000;
    public final int MANUTEN = 40;

    public Unit_Titan(){
        super("Titan", 3200, 50, 3, 1, 0);
        //luego se le añaden las filas y columnas 
        habilidades.add("Aniquilar");
    }
    public ImageIcon getIcon(){
        return null;
    }
    public int hacerAccion(Reino r, Field campo){
        int o = this.getOpcionUnidad();
        if(o == 1){
            JOptionPane.showMessageDialog(null, "Aniquilar");
        }
        return 125;
    }
}
