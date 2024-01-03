import javax.swing.*;

public class Unit_Drones extends Unit_Contemporaneo{
    public final int COSTO = 100;
    public final int MATPRIMA = 75;
    public final int MANUTEN = 2;

    public Unit_Drones(){
        super("Dron", 50, 0, 4, 3, 0);
        //luego se le añaden las filas y columnas 
        habilidades.add("Bomba dron");
    }
    public ImageIcon getIcon(){
        return null;
    }
    public int hacerAccion(Reino r, Field campo){
        int o = this.getOpcionUnidad();
        if(o == 0){
            JOptionPane.showMessageDialog(null, "Explotando");
        }
        return 114;
    }
}