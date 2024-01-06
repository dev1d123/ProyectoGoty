import javax.swing.*;

public class Unit_Caballero extends Unit_Medieval{
    public Unit_Caballero(){
        super("Caballero", 300, 100, 20, 3, 0);
        //luego se le añaden las filas y columnas 
        habilidades.add("Cargar");
        terreno = 1;
        setPrecios(120, 45, 3);

    }
    public ImageIcon getIcon(){
        return new ImageIcon(getClass().getResource("images_unit/caballero.jpg"));
    }
    public int hacerAccion(Reino r, Field campo){
        int o = this.getOpcionUnidad();
        if(o == 0){
            JOptionPane.showMessageDialog(null, "Cargar");
        }
        return 104;
    }
}
