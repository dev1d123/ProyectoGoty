import javax.swing.*;

public class Unit_Militar extends Unit_Contemporaneo{
    public final int COSTO = 60;
    public final int MATPRIMA = 30;
    public final int MANUTEN = 2;

    public Unit_Militar(){
        super("Militar", 200, 75, 7, 1, 0);
        //luego se le añaden las filas y columnas 
        habilidades.add("Estrategia ofensiva");
        habilidades.add("Estrategia defensiva");
        terreno = 1;
        setPrecios(60, 30, 2);

    }
    public ImageIcon getIcon(){
        return new ImageIcon(getClass().getResource("images_unit/militar.jpg"));
    }
    public void hacerAccion(Reino r){
        int o = this.getOpcionUnidad();
        if(o == 0){
            JOptionPane.showMessageDialog(null, "Estrategia ofensiva");
        }else if(o == 1){
            JOptionPane.showMessageDialog(null, "Estrategia defensiva");
        }
    }
    public void setBalasEspeciales(){
        balasEspeciales = 10;
    }
}
