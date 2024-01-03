import javax.swing.*;

public class Unit_Medico extends Unit_Contemporaneo{
    public final int COSTO = 60;
    public final int MATPRIMA = 60;
    public final int MANUTEN = 2;

    public Unit_Medico(){
        super("Medico", 50, 0, 0, 1, 0);
        //luego se le añaden las filas y columnas 
        habilidades.add("Curacion");
        habilidades.add("Gas venenoso");

    }
    public ImageIcon getIcon(){
        return null;
    }
    public int hacerAccion(Reino r, Field campo){
        int o = this.getOpcionUnidad();
        if(o == 1){
            JOptionPane.showMessageDialog(null, "Curacion");
            return 115;
        }else{
            JOptionPane.showMessageDialog(null, "Gas venenoso");
            return 116;
        }
    }
}
