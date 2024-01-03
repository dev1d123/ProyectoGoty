import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Unit_Soldado extends Unit_Medieval{
    public final int COSTO = 50;
    public final int MATPRIMA = 30;
    public final int MANUTEN = 2;

    private boolean estaEnDragon;
    public Unit_Soldado(){
        super("Soldado", 200, 50, 15, 1, 0);
        //luego se le añaden las filas y columnas 
        habilidades.add("Defender");
        habilidades.add("Ataque desenfrenado");

    }
    private int defensaOriginal = this.defensa;
    private boolean estaDefendiendo = false;
    public ImageIcon getIcon(){
        return null;
    }
    public int hacerAccion(Reino r, Field campo){
        int o = this.getOpcionUnidad();
        if(o == 0){
            if(estaDefendiendo){
                //Desactivar habilidad
                estaDefendiendo=false;
                JOptionPane.showMessageDialog(null, "Dejar de defender");
                habilidades.set(0, "Defender");
                defensa = defensaOriginal;

            }else{
                //Activar habilidad
                estaDefendiendo=true;
                JOptionPane.showMessageDialog(null, "Defender");
                habilidades.set(0, "Dejar de defender");
                defensa = (int) (defensaOriginal * 1.25);
            }
            return 70;
        }else{
            //selecciona una casilla cercana
            JOptionPane.showMessageDialog(null, "selecciona una casilla");
            return 100;
        }
    }
    public void setTieneJinete(){
        estaEnDragon = true;
    }


}
