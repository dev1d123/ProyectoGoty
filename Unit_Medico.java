import javax.swing.*;

public class Unit_Medico extends Unit_Contemporaneo{
    public final int COSTO = 60;
    public final int MATPRIMA = 60;
    public final int MANUTEN = 2;

    public boolean medAvanzado = false;
    public Unit_Medico(){
        super("Medico", 50, 0, 0, 1, 120);
        //luego se le añaden las filas y columnas 
        habilidades.add("Curacion: Cura 100 puntos de vida a las unidades (30 PP)");
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
            habilidades.add("Gas venenoso: Daña 200 puntos de vida a las unidades (30 PP)");
        }

        int o = this.getOpcionUnidad();
        if(o == 1){
            if(pp>=30){
                JOptionPane.showMessageDialog(null, "Curacion");
                pp-=30;
                return 115;
            }else{
                JOptionPane.showMessageDialog(null, "Insuficientes puntos de habilidad");
            }
        }else{
            if(pp>=30){
                JOptionPane.showMessageDialog(null, "Gas Venenoso");
                pp-=30;
                return 116;
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
