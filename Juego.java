
import java.util.Iterator;
import javax.swing.*;

public class Juego {
    //Necesita recibir a los dos reinos
    public static void iniciarJuego(Reino r1, Reino r2){
        JOptionPane.showMessageDialog(null, "Bienvenido al juego", null, 2);
        JuegoScript game = new JuegoScript(r1, r2);


        Field battle = new Field(game.getReino1(), game.getReino2());

        int turnos = 0;
        do{
            if(turnos%2 == 0){
                r1.actualizar();
                battle.repintar(1);
                JOptionPane.showMessageDialog(null, "Turno del reino 1");

                int arr[] = battle.getCoordenadas();
                //if para comprobar si se selecciono una base
                int x = arr[0] - 1;
                int y = arr[1] - 1; 
                if((x >= 44 && x <= 49) && (y >= 0 && y <= 5)){
                    MenuReino m = new MenuReino(r1, r2);
                    m.mostrar();
                    turnos++;
                    continue;
                }
                Unit selec = JuegoScript.seleccion(game.getReino1(), arr[0] - 1, arr[1] - 1);

                while (selec == null) {
                    arr = battle.getCoordenadas();
                    selec = JuegoScript.seleccion(game.getReino1(), arr[0] - 1, arr[1] - 1);
                }
                UnitMenu menu = new UnitMenu(battle, selec.getDatos(), selec.getOpciones(), selec, r1);

                int accionUnit = menu.getOpcionSeleccionada();
                if(accionUnit == 1){
                    int dir[] = battle.getCoordenadasObjetivo(arr[0] -1 , arr[1]-1, selec, 1);
                    JuegoScript.mover(game.getReino1(), game.getReino2(), arr[0], arr[1], dir[0], dir[1]);
                }else if(accionUnit != 70){
                    System.out.println("Seleccione un objetivo");
                    int dir[] = battle.getCoordenadas();
                    Habilidades.habilidad(accionUnit, selec, dir[0]-1, dir[1]-1, r1, r2, battle);
                }else if(accionUnit == 666){
                    
                } 
            }else{
                r2.actualizar();
                battle.repintar(2);
                JOptionPane.showMessageDialog(null, "Turno del reino 2");

                int arr[] = battle.getCoordenadas();
                int x = arr[0] - 1;
                int y = arr[1] - 1; 
                if((x >= 0 && x <= 5) && (y >= 44 && y <= 49)){
                    JOptionPane.showMessageDialog(null, "Has seleccionado al reino 2");
                    //Todas las posibles opciones de reino 2
                    MenuReino m = new MenuReino(r2, r1);
                    m.mostrar();
                    turnos++;
                    continue;
                }
                Unit selec = JuegoScript.seleccion(game.getReino2(), arr[0] - 1, arr[1] - 1);
                while (selec == null) {
                    arr = battle.getCoordenadas();
                    selec = JuegoScript.seleccion(game.getReino2(), arr[0] - 1, arr[1] - 1);
                }
                UnitMenu menu = new UnitMenu(battle, selec.getDatos(), selec.getOpciones(), selec, r2);

                int accionUnit = menu.getOpcionSeleccionada();
                if(accionUnit == 1){
                    int dir[] = battle.getCoordenadasObjetivo(arr[0] -1 , arr[1]-1, selec, 2);
                    JuegoScript.mover(game.getReino2(), game.getReino1(), arr[0], arr[1], dir[0], dir[1]);
                }else if(accionUnit != 70){
                    JOptionPane.showMessageDialog(null, "Selecciona un objetivo");
                    int dir[] = battle.getCoordenadas();
                    Habilidades.habilidad(accionUnit, selec, dir[0] -1 , dir[1] - 1, r2, r1, battle);
                }else if(accionUnit == 666){
                    
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


