import javax.swing.*;

public class Unit_Dragon extends Unit_Medieval{
    public final int COSTO = 150;
    public final int MATPRIMA = 70;
    public final int MANUTEN = 5;

    public Unit_Dragon(){
        super("Dragon", 300, 150, 7, 2, 0);
        //luego se le añaden las filas y columnas 
        habilidades.add("Bola ardiente: Lanza una bola a mas de una casilla de distancia");
        terreno = 3;
        setPrecios(150, 70, 5);

    }

    public ImageIcon getIcon(){
        return new ImageIcon(getClass().getResource("images_unit/dragon.jpg"));
    }
    public int hacerAccion(Reino r, Field campo){
        int o = this.getOpcionUnidad();
        if(o == 0){
            JOptionPane.showMessageDialog(null, "Bola ardiente");
        }
        return 102;
    }

}
