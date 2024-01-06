import javax.swing.*;

public class Unit_CruceroBatalla extends Unit_Contemporaneo{

    public Unit_CruceroBatalla(){
        super("Crucero de Batalla", 500, 50, 3, 3, 50);
        //luego se le añaden las filas y columnas 
        habilidades.add("Cañon Yamato: Cañon a gran distancia (25PP)");
        setPrecios(250, 200, 10);

    }
    public ImageIcon getIcon(){
        return new ImageIcon(getClass().getResource("images_unit/crucerobatalla.jpg"));
    }
    public int hacerAccion(Reino r, Field campo){
        int o = this.getOpcionUnidad();
        if(o == 1){
            if(pp>=25){
                JOptionPane.showMessageDialog(null, "Cañon Yamato");
                pp-=25;   
                return 120;
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
