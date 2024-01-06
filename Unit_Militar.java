import javax.swing.*;
public class Unit_Militar extends Unit_Contemporaneo{
    public final int COSTO = 60;
    public final int MATPRIMA = 30;
    public final int MANUTEN = 2;

    public Unit_Militar(){
        super("Militar", 200, 75, 7, 1, 20);
        //luego se le añaden las filas y columnas 
        habilidades.add("Estrategia ofensiva (2PP)");
        habilidades.add("Estrategia defensiva (2PP)");
        terreno = 1;
        setPrecios(60, 30, 2);
    }
    public ImageIcon getIcon(){
        return new ImageIcon(getClass().getResource("images_unit/militar.jpg"));
    }
    public void hacerAccion(Reino r){
        int o = this.getOpcionUnidad();
        if(o == 0){
            if(pp>=2){
                JOptionPane.showMessageDialog(null, "Estrategia ofensiva: El militar aumenta su daño permanentemente en 10");
                setAtaque(Math.min(getAtaque(), getAtaque() + 10));
                pp-=2;
            } else JOptionPane.showMessageDialog(null, "Insuficientes puntos de habilidad");
        }else if(o == 1){
            if(pp>=2){
                JOptionPane.showMessageDialog(null, "Estrategia defensiva: El militar aumenta su defensa permantemente en 10");
                setDefensa(Math.min(getDefensa(), getDefensa() + 10));
                pp-=2;
            } else JOptionPane.showMessageDialog(null, "Insuficientes puntos de habilidad");
        }
    }
    public void setBalasEspeciales(){
        balasEspeciales = 10;
    }
}
