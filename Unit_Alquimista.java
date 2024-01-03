import javax.swing.*;

public class Unit_Alquimista extends Unit_Medieval{
    public final int COSTO = 200;
    public final int MATPRIMA = 75;
    public final int MANUTEN = 3;

    public Unit_Alquimista(){
        super("Alquimista", 100, 10, 5, 1, 0);
        //luego se le añaden las filas y columnas 
        habilidades.add("Debilitar");
        habilidades.add("Fortalecer");
        habilidades.add("Pocion Secreta");

    }
    public ImageIcon getIcon(){
        return null;
    }
    public int hacerAccion(Reino r, Field campo){
        int o = this.getOpcionUnidad();
        if(o == 0){
            JOptionPane.showMessageDialog(null, "Debilitar");
            return 107;
        }else if(o == 1){
            JOptionPane.showMessageDialog(null, "Fortalecer");
            return 108;
        }else{
            JOptionPane.showMessageDialog(null, "Pocion Secreta");
            return 109;
        }
    }
}
