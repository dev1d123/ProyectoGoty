import javax.swing.*;

public class Unit_Caballero extends Unit_Medieval{
    public final int COSTO = 120;
    public final int MATPRIMA = 45;
    public final int MANUTEN = 3;

    public Unit_Caballero(){
        super("Caballero", 300, 100, 20, 3, 0);
        //luego se le añaden las filas y columnas 
        habilidades.add("Cargar");
    }
    public ImageIcon getIcon(){
        return null;
    }
    public int hacerAccion(Reino r, Field campo){
        int o = this.getOpcionUnidad();
        if(o == 0){
            JOptionPane.showMessageDialog(null, "Cargar");
        }
        return 104;
    }
}
