import javax.swing.*;

public class Unit_Caza extends Unit_Contemporaneo{
    public final int COSTO = 300;
    public final int MATPRIMA = 100;
    public final int MANUTEN = 4;

    public Unit_Caza(){
        super("Unit_Caza", 500, 200, 10, 3, 0);
        //luego se le añaden las filas y columnas 
        habilidades.add("Bombardear");
        habilidades.add("Misil Nuclear");
    }
    public ImageIcon getIcon(){
        return null;
    }
    public int hacerAccion(Reino r, Field campo){
        //pasivas
        int o = this.getOpcionUnidad();
        if(o == 0){
            JOptionPane.showMessageDialog(null, "Bombardear");
            return 110;
        }else{
            JOptionPane.showMessageDialog(null, "Misil Nuclear");
            return 111;
        }
    }
}
