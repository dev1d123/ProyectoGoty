import javax.swing.*;

public class Unit_AirSoldier extends Unit_Contemporaneo{


    public Unit_AirSoldier(){
        super("AirSoldier", 200, 50, 3, 1, 0);
        //luego se le añaden las filas y columnas 
        habilidades.add("Rafaga");
        terreno = 3;
        setPrecios(240, 50, 5);

    }
    public ImageIcon getIcon(){
        return new ImageIcon(getClass().getResource("images_unit/airsoldier.jpg"));
    }
    public void setBalasEspeciales(){
        balasEspeciales = 10;
    }
    public int hacerAccion(Reino r, Field campos){
        int o = this.getOpcionUnidad();
        if(o == 1){
            JOptionPane.showMessageDialog(null, "Rafaga");
        }
        return 118;
    }

}
