import javax.swing.*;

public class Unit_Caza extends Unit_Contemporaneo{
    public final int COSTO = 300;
    public final int MATPRIMA = 100;
    public final int MANUTEN = 4;

    public Unit_Caza(){
        super("Unit_Caza", 500, 200, 10, 3, 0);
        //luego se le añaden las filas y columnas 
        habilidades.add("Bombardear");
        terreno = 3;
        setPrecios(300, 100, 4);

    }
    private boolean tieneMisil = false;
    public void equiparMisilNuclear(){
        tieneMisil = true;
    }
    public ImageIcon getIcon(){
        return new ImageIcon(getClass().getResource("images_unit/caza.jpg"));
    }
    public int hacerAccion(Reino r, Field campo){
        //pasivas
        if(tieneMisil){
            habilidades.add("Misil Nuclear");
        }
        int o = this.getOpcionUnidad();
        if(o == 0){
            JOptionPane.showMessageDialog(null, "Bombardear");
            return 110;
        }else{
            JOptionPane.showMessageDialog(null, "Misil Nuclear");
            tieneMisil = false;
            return 111;
        }
    }

    public void setBalasEspeciales(){
        balasEspeciales = 10;
    }
}
