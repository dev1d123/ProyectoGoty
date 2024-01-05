import javax.swing.*;

public class Unit_Mago extends Unit_Medieval{

    public Unit_Mago(){
        super("Mago", 100, 20, 0, 2, 0);
        //luego se le añaden las filas y columnas 
        habilidades.add("Curacion magica");
        habilidades.add("Control Mental");
        terreno = 1;
        setPrecios(100, 0, 2);

    }
    public ImageIcon getIcon(){
        return new ImageIcon(getClass().getResource("images_unit/mago.jpg"));
    }
    public int hacerAccion(Reino r, Field campo){
        int o = this.getOpcionUnidad();
        if(o == 0){
            JOptionPane.showMessageDialog(null, "Curacion magica");
            return 105;
        }else{
            JOptionPane.showMessageDialog(null, "Control mental");
            return 106;
        }
    }
    
}
