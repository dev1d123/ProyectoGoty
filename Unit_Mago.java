import javax.swing.*;

public class Unit_Mago extends Unit_Medieval{

    public Unit_Mago(){
        super("Mago", 100, 20, 0, 2, 300);
        //luego se le añaden las filas y columnas 
        habilidades.add("Curacion magica: Cura 200 puntos en un gran area (50 PP)");
        habilidades.add("Control Mental: Se apodera de una unidad enemida (150 PP)");
        terreno = 1;
        setPrecios(100, 0, 2);

    }
    public ImageIcon getIcon(){
        return new ImageIcon(getClass().getResource("images_unit/mago.jpg"));
    }
    public int hacerAccion(Reino r, Field campo){
        int o = this.getOpcionUnidad();
        if(o == 0){
            if(pp>=50){
                JOptionPane.showMessageDialog(null, "Curacion magica");
                pp-=50;
                return 105;
            }

        }else{
            if(pp>=150){
                JOptionPane.showMessageDialog(null, "Control mental");
                pp-=50;
                return 106;
            }
        }
        JOptionPane.showMessageDialog(null, "Insuficientes puntos de habilidad");
        return 70;
    }
    
}
