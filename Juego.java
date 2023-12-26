import javax.swing.*;

public class Juego {
    public static void main(String[] args){
        JOptionPane.showMessageDialog(null, "Bienvenido al juego", null, 2);
        JuegoScript game = new JuegoScript();
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
                UnitMenu menu = new UnitMenu(battle, selec.getDatos(), selec.getOpciones());
                if(menu.getOpcionSeleccionada() == 1){
                    int dir[] = battle.getCoordenadas();
                    JuegoScript.mover(game.getReino1(), game.getReino2(), arr[0], arr[1], dir[0], dir[1]);
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
                UnitMenu menu = new UnitMenu(battle, selec.getDatos(), selec.getOpciones());
                if(menu.getOpcionSeleccionada() == 1){
                    int dir[] = battle.getCoordenadas();
                    JuegoScript.mover(game.getReino2(), game.getReino1(), arr[0], arr[1], dir[0], dir[1]);

                }                
            }
            turnos++;
        }while(game.victoria());   
    }
}


