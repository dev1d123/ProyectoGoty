import javax.swing.*;

public class Unit_Avion extends Unit_Contemporaneo{
    public final int COSTO = 200;
    public final int MATPRIMA = 100;
    public final int MANUTEN = 5;

    public Unit_Avion(){
        super("Avion", 300, 0, 10, 2, 0);
        //luego se le añaden las filas y columnas 
        habilidades.add("Almacen de soldados y medicos");
    }
    public ImageIcon getIcon(){
        return null;
    }
    public int hacerAccion(Reino r, Field campo){
        int o = this.getOpcionUnidad();
        if(o == 0){
            JOptionPane.showMessageDialog(null, "Almacen de soldados y medicos");
        }
        return 113;
    }
}
