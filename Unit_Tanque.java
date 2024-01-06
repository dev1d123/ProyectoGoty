import javax.swing.*;

public class Unit_Tanque extends Unit_Contemporaneo{
    public final int COSTO = 200;
    public final int MATPRIMA = 100;
    public final int MANUTEN = 5;

    public Unit_Tanque(){
        super("Tanque", 500, 100, 10, 2, 1);
        habilidades.add("Equipo de reparacion: El tanque recupera toda su vida (1PP)");
        terreno = 1;
        setPrecios(200, 100, 5);

    }
    public ImageIcon getIcon(){
        return new ImageIcon(getClass().getResource("images_unit/tanque.jpg"));
    }
    public void hacerAccion(Reino r){
        int o = this.getOpcionUnidad();
        if(o == 0){
            if(pp>=1){
                JOptionPane.showMessageDialog(null, "Reparandose");
                pp--;
            }else{
                JOptionPane.showMessageDialog(null, "Insuficientes puntos de poder");
            }
            
        }
    }
    public void setBalasEspeciales(){
        balasEspeciales = 10;
    }
}
