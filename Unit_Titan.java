import javax.swing.*;

public class Unit_Titan extends Unit_Contemporaneo{

    public Unit_Titan(){
        super("Titan", 3200, 50, 3, 1, 100);
        //luego se le añaden las filas y columnas 
        habilidades.add("Aniquilar: Ataque a gran distancia de 15 casillas (10PP)");
        terreno = 4;
        setPrecios(2500, 2000, 40);

    }
    public ImageIcon getIcon(){
        return new ImageIcon(getClass().getResource("images_unit/titan.jpg"));
    }
    public int hacerAccion(Reino r, Field campo){
        int o = this.getOpcionUnidad();
        if(o == 1){
            if(pp>=10){
                JOptionPane.showMessageDialog(null, "Aniquilar");
                pp-=10;
                return 125;
            }else{
                JOptionPane.showMessageDialog(null, "Insuficientes puntos de habilidad");
            }
        }
        return 70;
    }
    public void setBalasEspeciales(){
        balasEspeciales = 10;
    }
}
