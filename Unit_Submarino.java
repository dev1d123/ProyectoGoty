import javax.swing.*;

public class Unit_Submarino extends Unit_Contemporaneo{
    public final int COSTO = 500;
    public final int MATPRIMA = 400;
    public final int MANUTEN = 15;

    public Unit_Submarino(){
        super("Submarino", 300, 50, 3, 1, 0);
        //luego se le añaden las filas y columnas 
        habilidades.add("Torpedo");
        terreno = 2;

    }
    public ImageIcon getIcon(){
        return null;
    }
    public int hacerAccion(Reino r, Field campo){
        int o = this.getOpcionUnidad();
        if(o == 1){
            JOptionPane.showMessageDialog(null, "Torpedo");
        }
        return 121;
    }
}
