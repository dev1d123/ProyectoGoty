import javax.swing.*;

public class Unit_CruceroBatalla extends Unit_Contemporaneo{
    public final int COSTO = 250;
    public final int MATPRIMA = 200;
    public final int MANUTEN = 10;

    public Unit_CruceroBatalla(){
        super("Crucero de Batalla", 500, 50, 3, 1, 0);
        //luego se le añaden las filas y columnas 
        habilidades.add("Cañon Yamato");
    }
    public ImageIcon getIcon(){
        return null;
    }
    public int hacerAccion(Reino r, Field campo){
        int o = this.getOpcionUnidad();
        if(o == 1){
            JOptionPane.showMessageDialog(null, "Cañon Yamato");
        }
        return 120;
    }
}
