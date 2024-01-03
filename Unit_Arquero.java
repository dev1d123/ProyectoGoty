import javax.swing.*;

public class Unit_Arquero extends Unit_Medieval{
    public final int COSTO = 75;
    public final int MATPRIMA = 30;
    public final int MANUTEN = 2;

    public Unit_Arquero(){
        super("Arquero", 100, 30, 0, 2, 0);
        //luego se le añaden las filas y columnas 
        habilidades.add("Apuntar");
    }
    public ImageIcon getIcon(){
        return null;
    }
    public void hacerAccion(Reino r){
        int o = this.getOpcionUnidad();
        if(o == 0){
            JOptionPane.showMessageDialog(null, "Apuntar");
        }
    }
}
