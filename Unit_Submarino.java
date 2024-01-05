import javax.swing.*;

public class Unit_Submarino extends Unit_Contemporaneo{

    public Unit_Submarino(){
        super("Submarino", 300, 50, 3, 1, 0);
        //luego se le añaden las filas y columnas 
        habilidades.add("Torpedo");
        terreno = 2;
        setPrecios(500, 400, 15);

    }
    public ImageIcon getIcon(){
        return new ImageIcon(getClass().getResource("images_unit/submarino.jpg"));
    }
    public int hacerAccion(Reino r, Field campo){
        int o = this.getOpcionUnidad();
        if(o == 1){
            JOptionPane.showMessageDialog(null, "Torpedo");
        }
        return 121;
    }
    public void setBalasEspeciales(){
        balasEspeciales = 10;
    }
}
