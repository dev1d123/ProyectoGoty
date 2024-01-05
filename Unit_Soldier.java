import javax.swing.*;

public class Unit_Soldier extends Unit_Contemporaneo{


    public Unit_Soldier(){
        super("Soldier", 150, 50, 3, 1, 0);
        //luego se le añaden las filas y columnas 
        habilidades.add("HiperVelocidad");
        terreno = 1;
        setPrecios(120, 50, 5);
    }
    public ImageIcon getIcon(){
        return new ImageIcon(getClass().getResource("images_unit/soldier.png"));
    }
    public int hacerAccion(Reino r, Field campo){
        int o = this.getOpcionUnidad();
        if(o == 1){
            JOptionPane.showMessageDialog(null, "HiperVelocidad");
        }
        return 117;
    }
    public void setBalasEspeciales(){
        balasEspeciales = 10;
    }
}
