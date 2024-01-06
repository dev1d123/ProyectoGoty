import javax.swing.*;

public class Unit_Avion extends Unit_Contemporaneo{


    public Unit_Avion(){
        super("Avion", 300, 100, 10, 2, 0);
        //luego se le añaden las filas y columnas 
        terreno = 3;
        habilidades.add("Ataque especial");

        setPrecios(200, 100, 5);

    }
    public ImageIcon getIcon(){
        return new ImageIcon(getClass().getResource("images_unit/avion.jpg"));
    }
    public int hacerAccion(Reino r, Field campo){
        int o = this.getOpcionUnidad();
        if(o == 0){
            JOptionPane.showMessageDialog(null, "Ataque especial");
            setAtaque(getAtaque() + 10);
            setBalasEspeciales();
        }
        return 70;
    }
    public void setBalasEspeciales(){
        balasEspeciales = 10;
    }
}
