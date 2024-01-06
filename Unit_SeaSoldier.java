import javax.swing.*;

public class Unit_SeaSoldier extends Unit_Contemporaneo{


    public Unit_SeaSoldier(){
        super("SeaSoldier", 200, 50, 3, 1, 150);
        //luego se le añaden las filas y columnas 
        habilidades.add("Ataque PEM: Quita todos los puntos de habilidad a una unidad (50 PP)");
        terreno = 2;
        setPrecios(240, 50, 5);

    }
    public ImageIcon getIcon(){
        return new ImageIcon(getClass().getResource("images_unit/seasoldier.jpg"));
    }
    public int hacerAccion(Reino r, Field campo){
        int o = this.getOpcionUnidad();
        if(o == 1){
            if(pp>=50){
                JOptionPane.showMessageDialog(null, "Ataque PEM");
                pp-=50;
                return 119;
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
