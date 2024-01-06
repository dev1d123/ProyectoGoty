import javax.swing.*;

public class Unit_Medico extends Unit_Contemporaneo{
    public final int COSTO = 60;
    public final int MATPRIMA = 60;
    public final int MANUTEN = 2;

    public boolean medAvanzado = false;
    public Unit_Medico(){
        super("Medico", 50, 0, 0, 1, 0);
        //luego se le añaden las filas y columnas 
        habilidades.add("Curacion");
        terreno = 1;
        setPrecios(60, 60, 2);

    }
    public void equiparMedicinaAvanzada(){
        medAvanzado = true;
    }
    public ImageIcon getIcon(){
        return new ImageIcon(getClass().getResource("images_unit/medico.jpg"));
    }
    public int hacerAccion(Reino r, Field campo){
        if(medAvanzado){
            habilidades.add("Gas venenoso");
        }

        int o = this.getOpcionUnidad();
        if(o == 1){
            JOptionPane.showMessageDialog(null, "Curacion");
            return 115;
        }else{
            JOptionPane.showMessageDialog(null, "Gas venenoso");
            return 116;
        }
    }
    public void setBalasEspeciales(){
        balasEspeciales = 10;
    }
}
