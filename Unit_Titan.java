import javax.swing.*;

public class Unit_Titan extends Unit_Contemporaneo{

    public Unit_Titan(){
        super("Titan", 3200, 50, 3, 1, 0);
        //luego se le añaden las filas y columnas 
        habilidades.add("Aniquilar");
        terreno = 4;
        setPrecios(2500, 2000, 40);

    }
    public ImageIcon getIcon(){
        return new ImageIcon(getClass().getResource("images_unit/titan.jpg"));
    }
    public int hacerAccion(Reino r, Field campo){
        int o = this.getOpcionUnidad();
        if(o == 1){
            JOptionPane.showMessageDialog(null, "Aniquilar");
        }
        return 125;
    }
    public void setBalasEspeciales(){
        balasEspeciales = 10;
    }
}
