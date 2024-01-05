import javax.swing.*;

public class Unit_CruceroBatalla extends Unit_Contemporaneo{

    public Unit_CruceroBatalla(){
        super("Crucero de Batalla", 500, 50, 3, 1, 0);
        //luego se le añaden las filas y columnas 
        habilidades.add("Cañon Yamato");
        setPrecios(250, 200, 10);

    }
    public ImageIcon getIcon(){
        return new ImageIcon(getClass().getResource("images_unit/crucerobatalla.jpg"));
    }
    public int hacerAccion(Reino r, Field campo){
        int o = this.getOpcionUnidad();
        if(o == 1){
            JOptionPane.showMessageDialog(null, "Cañon Yamato");
        }
        return 120;
    }
    public void setBalasEspeciales(){
        balasEspeciales = 10;
    }
}
