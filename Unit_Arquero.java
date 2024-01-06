import javax.swing.*;

public class Unit_Arquero extends Unit_Medieval{
    public final int COSTO = 75;
    public final int MATPRIMA = 30;
    public final int MANUTEN = 2;

    public Unit_Arquero(){
        super("Arquero", 100, 30, 0, 3, 0);
        //luego se le añaden las filas y columnas 
        habilidades.add("Apuntar");
        terreno = 1;
        setPrecios(75, 30, 2);

    }
    public ImageIcon getIcon(){
        return new ImageIcon(getClass().getResource("images_unit/arquero.jpg"));
    }
    public int hacerAccion(Reino r, Field campo){
        int o = this.getOpcionUnidad();
        if(o == 0){
            JOptionPane.showMessageDialog(null, "Apuntar");
            this.setAtaque(getAtaque() + 10);
        }
        return 70;
    }
}
