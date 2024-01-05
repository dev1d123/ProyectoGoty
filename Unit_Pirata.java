import javax.swing.*;

public class Unit_Pirata extends Unit_Medieval{


    public Unit_Pirata(){
        super("Pirata", 300, 200, 30, 2, 0);
        //luego se le añaden las filas y columnas 
        habilidades.add("Robar");
        habilidades.add("Asediar");
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
            //codigo para robar
            Reino victima;
            if (campo.getReino1() == r) victima = campo.getReino2();
            else victima = campo.getReino1();
            //r le roba a victima
            JOptionPane.showMessageDialog(null, r + " le roba a " + victima);
            return 70;
        }else{
            //codigo para asediar!!!!
            JOptionPane.showMessageDialog(null, "Asediar");
            return 101;
        }

    }
}
