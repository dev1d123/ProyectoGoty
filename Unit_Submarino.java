import javax.swing.*;

public class Unit_Submarino extends Unit_Contemporaneo{

    public Unit_Submarino(){
        super("Submarino", 300, 50, 3, 1, 100);
        //luego se le añaden las filas y columnas 
        habilidades.add("Torpedo: Cañon a distancia (50PP)");
        terreno = 2;
        setPrecios(500, 400, 15);

    }
    public ImageIcon getIcon(){
        return new ImageIcon(getClass().getResource("images_unit/submarino.jpg"));
    }
    public int hacerAccion(Reino r, Field campo){
        int o = this.getOpcionUnidad();
        if(o == 1){
            if(pp >= 50){
                JOptionPane.showMessageDialog(null, "Torpedo");
                pp-=50;
                return 121;
            }
        }
        return 70;
    }
    public void setBalasEspeciales(){
        balasEspeciales = 10;
    }
}
