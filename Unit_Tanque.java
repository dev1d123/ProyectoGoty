import javax.swing.*;

public class Unit_Tanque extends Unit_Contemporaneo{
    public final int COSTO = 200;
    public final int MATPRIMA = 100;
    public final int MANUTEN = 5;

    public Unit_Tanque(){
        super("Tanque", 500, 100, 10, 2, 0);
        //luego se le añaden las filas y columnas 
        habilidades.add("Equipo de reparacion");
    }
    public ImageIcon getIcon(){
        return null;
    }
    public void hacerAccion(Reino r){
        int o = this.getOpcionUnidad();
        if(o == 0){
            JOptionPane.showMessageDialog(null, "Reparandose");
        }
    }
}
