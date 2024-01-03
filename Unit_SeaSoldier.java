import javax.swing.*;

public class Unit_SeaSoldier extends Unit_Contemporaneo{
    public final int COSTO = 240;
    public final int MATPRIMA = 50;
    public final int MANUTEN = 5;

    public Unit_SeaSoldier(){
        super("SeaSoldier", 200, 50, 3, 1, 0);
        //luego se le añaden las filas y columnas 
        habilidades.add("Ataque PEM");
        terreno = 2;

    }
    public ImageIcon getIcon(){
        return null;
    }
    public int hacerAccion(Reino r, Field campo){
        int o = this.getOpcionUnidad();
        if(o == 1){
            JOptionPane.showMessageDialog(null, "Ataque PEM");
        }
        return 119;
    }
}
