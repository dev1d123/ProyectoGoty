import javax.swing.*;

public class Unit_Ufo extends Unit_Contemporaneo{


    public Unit_Ufo(){
        super("Ufo", 100, 50, 3, 1, 0);
        //luego se le añaden las filas y columnas 
        habilidades.add("Cañon de rayos gamma");
        habilidades.add("Campo electromagnetico");
        terreno = 3;
        setPrecios(700, 500, 15);
    }
    public ImageIcon getIcon(){
        return new ImageIcon(getClass().getResource("images_unit/ufo.jpg"));
    }
    public int hacerAccion(Reino r, Field campo){
        int o = this.getOpcionUnidad();
        if(o == 1){
            JOptionPane.showMessageDialog(null, "Cañon de rayos gamma");
            return 124;
        }else if(o == 2){
            JOptionPane.showMessageDialog(null, "Campo Electromagnetico");
            
        }
        return 70;
    }
    public void setBalasEspeciales(){
        balasEspeciales = 10;
    }
}
