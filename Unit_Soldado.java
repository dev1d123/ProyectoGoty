import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Unit_Soldado extends Unit_Medieval{


    public Unit_Soldado(){
        super("Soldado", 200, 50, 15, 2, 0);
        //luego se le añaden las filas y columnas 
        habilidades.add("Defender");
        habilidades.add("Ataque desenfrenado");
        terreno = 1;
        setPrecios(50, 30, 2);
    }
    private int defensaOriginal = this.defensa;
    private boolean estaDefendiendo = false;
    public ImageIcon getIcon(){
        return new ImageIcon(getClass().getResource("images_unit/soldado.jpg"));
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



}
