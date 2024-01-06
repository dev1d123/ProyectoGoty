import javax.swing.*;

public class Unit_Pirata extends Unit_Medieval{


    public Unit_Pirata(){
        super("Pirata", 300, 200, 30, 2, 0);
        //luego se le añaden las filas y columnas 
        habilidades.add("Robar: Roba 300 de oro al enemigo (0 PP)");
        habilidades.add("Asediar: Ataque a mediana distancia (0 PP)");
        terreno = 2;
        setPrecios(150, 100, 5);

    }
    public ImageIcon getIcon(){
        return new ImageIcon(getClass().getResource("images_unit/pirata.jpg"));
    }
    public int hacerAccion(Reino r, Field campo){
        int o = this.getOpcionUnidad();
        if(o == 0){
            JOptionPane.showMessageDialog(null, "Robar");
            Reino victima;
            if (campo.getReino1() == r) victima = campo.getReino2();
            else victima = campo.getReino1();
            JOptionPane.showMessageDialog(null, r + " le roba a " + victima);
            r.setDinero(r.getDinero() + 300);
            victima.setDinero(Math.max(0, victima.getDinero() - 300));
            return 70;
        }else{
            JOptionPane.showMessageDialog(null, "Asediar");
            return 101;
        }

    }
}
