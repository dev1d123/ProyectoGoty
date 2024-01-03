import javax.swing.*;

public class Unit_Portaaviones extends Unit_Contemporaneo{
    public final int COSTO = 600;
    public final int MATPRIMA = 150;
    public final int MANUTEN = 8;

    public Unit_Portaaviones(){
        super("Portaaviones", 750, 150, 20, 2, 0);
        //luego se le añaden las filas y columnas 
        habilidades.add("Almacen de cazas");
        habilidades.add("Reparacion de caza");
        terreno = 2;

    }
    public ImageIcon getIcon(){
        return null;
    }
    public int hacerAccion(Reino r, Field campo){
        int o = this.getOpcionUnidad();
        if(o == 0){
            JOptionPane.showMessageDialog(null, "Almacen de caza");
            return 112;
        }else{
            JOptionPane.showMessageDialog(null, "Reparacion de caza");
            return 70;
        }
    }
}
