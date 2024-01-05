import javax.swing.*;

public class Unit_SeaSoldier extends Unit_Contemporaneo{


    public Unit_SeaSoldier(){
        super("SeaSoldier", 200, 50, 3, 1, 0);
        //luego se le añaden las filas y columnas 
        habilidades.add("Ataque PEM");
        terreno = 2;
        setPrecios(240, 50, 5);

    }
    public ImageIcon getIcon(){
        return new ImageIcon(getClass().getResource("images_unit/seasoldier.jpg"));
    }
    public int hacerAccion(Reino r, Field campo){
        int o = this.getOpcionUnidad();
        if(o == 1){
            JOptionPane.showMessageDialog(null, "Ataque PEM");
        }
        return 119;
    }
    public void setBalasEspeciales(){
        balasEspeciales = 10;
    }
}
