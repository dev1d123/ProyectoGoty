
import java.util.Iterator;

import javax.swing.*;

public class Juego {
    //Necesita recibir a los dos reinos
    public static void iniciarJuego(Reino r1, Reino r2){
        JOptionPane.showMessageDialog(null, "Bienvenido al juego", null, 2);
        JuegoScript game = new JuegoScript(r1, r2);
        game.genPosUnitR1();
        game.genPosUnitR2();
        Field battle = new Field(game.getReino1(), game.getReino2());

        int turnos = 0;
        do{
            
            if(turnos%2 == 0){
                battle.repintar(1);
                JOptionPane.showMessageDialog(null, "Turno del reino 1");


                int arr[] = battle.getCoordenadas();
                Unit selec = JuegoScript.seleccion(game.getReino1(), arr[0] - 1, arr[1] - 1);
                while (selec == null) {
                    arr = battle.getCoordenadas();
                    selec = JuegoScript.seleccion(game.getReino1(), arr[0] - 1, arr[1] - 1);
                }
                UnitMenu menu = new UnitMenu(battle, selec.getDatos(), selec.getOpciones(), selec, r1);
                int accionUnit = menu.getOpcionSeleccionada();
                JOptionPane.showMessageDialog(null, "Seleccionaste a opcion " + accionUnit);
                if(accionUnit == 1){
                    int dir[] = battle.getCoordenadas();
                    JuegoScript.mover(game.getReino1(), game.getReino2(), arr[0], arr[1], dir[0], dir[1]);
                }else if(accionUnit != 70){
                    int dir[] = battle.getCoordenadas();
                    JOptionPane.showMessageDialog(null, "Seleccionaste como objetivo a  " + (dir[0]-1) + ", " + (dir[1]-1));
                    Habilidades.habilidad(accionUnit, selec, dir[0]-1, dir[1]-1, r1, r2, battle);
                }
            }else{
                battle.repintar(2);
                JOptionPane.showMessageDialog(null, "Turno del reino 2");
                int arr[] = battle.getCoordenadas();
                Unit selec = JuegoScript.seleccion(game.getReino2(), arr[0] - 1, arr[1] - 1);
                while (selec == null) {
                    arr = battle.getCoordenadas();
                    selec = JuegoScript.seleccion(game.getReino2(), arr[0] - 1, arr[1] - 1);
                }
                UnitMenu menu = new UnitMenu(battle, selec.getDatos(), selec.getOpciones(), selec, r2);
                int accionUnit = menu.getOpcionSeleccionada();
                if(accionUnit == 1){
                    int dir[] = battle.getCoordenadas();
                    JuegoScript.mover(game.getReino2(), game.getReino1(), arr[0], arr[1], dir[0], dir[1]);
                }else if(accionUnit != 70){
                    int dir[] = battle.getCoordenadas();
                    JOptionPane.showMessageDialog(null, "Seleccionaste como objetivo a  " + (dir[0]-1) + ", " + (dir[1]-1));
                    Habilidades.habilidad(accionUnit, selec, dir[0] -1 , dir[1] - 1, r2, r1, battle);
                }                
            }
            turnos++;
            //itera sobre los dos reino y verifica si una unidad esta colindante a el reino opuesto si es vcerdad se añade un invasor
            //Contamos para R1

            for (int j = 0; j <= 7; j++) {
                Iterator<Unit> iterator = r2.getUnidades().iterator();
                while (iterator.hasNext()) {
                    Unit u = iterator.next();
                    if (u.getFila() == 43 && u.getColumna() == j) {
                        r1.setInvasores(r1.getInvasores() + 1);
                        iterator.remove(); // Eliminar usando el iterador
                        break;
                    }
                }
            }
            
            for (int i = 42; i <= 49; i++) {
                Iterator<Unit> iterator = r2.getUnidades().iterator();
                while (iterator.hasNext()) {
                    Unit u = iterator.next();
                    if (u.getFila() == i && u.getColumna() == 6) {
                        r1.setInvasores(r1.getInvasores() + 1);
                        iterator.remove(); // Eliminar usando el iterador
                        break;
                    }
                }
            }
            
            // Contamos para R2
            for (int i = 0; i <= 6; i++) {
                Iterator<Unit> iterator = r1.getUnidades().iterator();
                while (iterator.hasNext()) {
                    Unit u = iterator.next();
                    if (u.getFila() == i && u.getColumna() == 43) {
                        r2.setInvasores(r2.getInvasores() + 1);
                        iterator.remove(); // Eliminar usando el iterador
                        break;
                    }
                }
            }
            
            for (int j = 42; j <= 49; j++) {
                Iterator<Unit> iterator = r1.getUnidades().iterator();
                while (iterator.hasNext()) {
                    Unit u = iterator.next();
                    if (u.getFila() == 6 && u.getColumna() == j) {
                        r2.setInvasores(r2.getInvasores() + 1);
                        iterator.remove(); // Eliminar usando el iterador
                        break;
                    }
                }
            }

            JOptionPane.showMessageDialog(null, "El reino 1 tiene " + r1.getInvasores() + " invasores");
            JOptionPane.showMessageDialog(null, "El reino 2 tiene " + r2.getInvasores() + " invasores");
        }while(game.victoria()); 
        System.exit(1);
    }
}


