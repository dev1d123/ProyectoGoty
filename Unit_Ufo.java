import java.io.Serializable;

import javax.swing.*;

public class Unit_Ufo extends Unit_Contemporaneo{


    public Unit_Ufo(){
        super("Ufo", 100, 50, 3, 1, 50);
        //luego se le añaden las filas y columnas 
        habilidades.add("Cañon de rayos gamma: Ataca a las unidades en la misma fila o columna que ufo (20 PP)");
        habilidades.add("Campo electromagnetico:  Genera un campo de 3 casillas alrededor del ufo dañando a las unidades enemigas (30PP)");
        terreno = 3;
        setPrecios(700, 500, 15);
    }
    public ImageIcon getIcon(){
        return new ImageIcon(getClass().getResource("images_unit/ufo.jpg"));
    }
    public int hacerAccion(Reino r, Field campo){
        int o = this.getOpcionUnidad();
        if(o == 1){
            JOptionPane.showMessageDialog(null, "Cañon de rayos gamma");
            if(pp>=20) return 124;
            else JOptionPane.showMessageDialog(null, "Insuficiente puntos de poder");
        }else if(o == 2){
            JOptionPane.showMessageDialog(null, "Campo Electromagnetico");
            //Daño en area a las unidades 
            for(int i = fila - 3; i < fila + 3; i++){
                for(int j = columna - 3; j < columna + 3; i++){
                    Reino buscar;
                    if(campo.getReino1() == r) buscar = campo.getReino2();
                    else buscar = campo.getReino1();

                    if(0<=i && i <= 49 && 0<=j && j<=49){
                        for(Unit u: buscar.getUnidades()){
                            u.recibirDaño(100);
                        }    
                    }
                }
            }            
        }
        return 70;
    }
    public void setBalasEspeciales(){
        balasEspeciales = 10;
    }
}
