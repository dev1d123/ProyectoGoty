import java.awt.Robot;
import java.util.Random;

import javax.swing.JOptionPane;

public class JuegoScript {
    private Reino r1;
    private Reino r2;
    private final int MED = 50;

    boolean[][] agua = new boolean[50][50];{
        for(int i = 0; i <= 43; i++){
            for(int j = 0; j <= 3; j++){
                agua[i][j] = true;
            }
        }
        for(int i = 0; i <= 3; i++){
            for(int j = 0; j <= 43; j++){
                agua[i][j] = true;
            }
        }
        for(int i = 6; i <= 46; i++){
            for(int j = 46; j <= 49; j++){
                agua[i][j] = true;
            }
        }
        for(int i = 46; i <= 49; i++){
            for(int j = 6; j <= 49; j++){
                agua[i][j] = true;    
            }
        }
    }
    boolean[][] posiciones = new boolean[50][50];{
        for(int i = MED - 6; i < MED; i++){
            for (int j = 0; j < 6; j++) {                
                posiciones[i][j] = true;
            }
        }
        for(int i = 0; i < 6; i++){
            for (int j = MED - 6; j < MED; j++) {
                posiciones[i][j] = true;
            }
        }
        for(int i = 6, j = 43; i <= 43 || j >=6; i++, j--){
            posiciones[i][j] = true;
        }
    };

    //En esta clase se desarrolla toda la logica del videojuego
    public JuegoScript(Reino r1, Reino r2){
        this.r1 = r1; 
        this.r2 = r2;                                                                                                           
    }
    public boolean[][] getPosiciones(){
        return posiciones;
    }

    public Reino getReino1(){
        return r1;
    }
    public Reino getReino2(){
        return r2;
    }
    public int getInvasoresR1(){
        int res = 0;
        for(int i = MED - 6; i < MED; i++){
            for (int j = 0; j < 6; j++) {     
                for(Unit u: r2.getUnidades()){
                    if(u.getFila() == i && u.getColumna() == j){
                        res++;
                    }
                }           
            }
        }
        return res;

    }
    public int getInvasoresR2(){
        int res = 0;
        for(int i = 0; i < 6; i++){
            for (int j = MED - 6; j < MED; j++) {
                for(Unit u: r1.getUnidades()){
                    if(u.getFila() == i && u.getColumna() == j){
                        res++;
                    }
                }       
            }
        }
        return res;

    }
    public boolean victoria(){
        //La victoria se realiza cuando 5 unidades del rival llegan a la otra base, cada base puede defenderse, cambiando a una torre para eliminar
        //a un intruso
        if(r1.getInvasores() == 5){
            JOptionPane.showMessageDialog(null, "El jugador 2 gano el juego");
            return false;
        }
        if(r2.getInvasores() == 5){
            JOptionPane.showMessageDialog(null, "El jugador 1 gano el juego");
            return false;
        }
        return true;
    }
    public static Unit seleccion(Reino r, int x, int y){
        for(Unit u: r.getUnidades()){
            if(u.getColumna() == y && u.getFila() == x){
                System.out.println("WOW, SELECCIONASTE UN SOLDADO. FELICIDADES!");
                return u;
            }
        }
        return null;
    }

    public static void mover(Reino amigo, Reino enemigo, int x, int y, int tox, int toy){
        Unit mov = null;
        for(Unit u: amigo.getUnidades()){
            if(u.getFila() == x-1 && u.getColumna() == y-1){
                mov = u;
                break;
            }
        }        
        System.out.println("Metodo para mover");
        //Caso mover a la misma casilla
        if(x == tox && y == toy){
            JOptionPane.showMessageDialog(null, "Seleccione una casilla correcta!");
        }else{
            Unit sold = null;
            for(Unit u: amigo.getUnidades()){
                if(u.getFila() == tox-1 && u.getColumna() == toy-1){
                    sold = u;
                }
            }
            if(sold != null){
                JOptionPane.showMessageDialog(null, "Seleccione una casilla correcta!");
                return;
            }

            for(Unit u: enemigo.getUnidades()){
                if(u.getFila() == tox-1 && u.getColumna() == toy-1){
                    sold = u;
                }
            }
            if(sold != null){
                JOptionPane.showMessageDialog(null, "Atacando");
            }else{
                JOptionPane.showMessageDialog(null, "Moviendose");
                mov.setFila(tox-1);
                mov.setColumna(toy-1);
            }

        }
    }

    //ASIGNAR POSICIONES ALEATORIAS PARA R1 Y R2
    //PARA R1.
    //cada unidad tiene un tipo
    //1 -> Terrestre
    //2 -> Maritimo
    //3 -> Aereo
    public void genPosUnitR1(){
        //generando los maritimos
        int count = 0;
        Random r = new Random();
        int ran1, ran2;
        for(Unit u: r1.getUnidades()){

            if(u.getTerreno() == 2){
                if(count%2 == 0){
                    do{
                        ran1 = r.nextInt(19) + 23; // generar de 23  a 43
                        ran2 = r.nextInt(3); 
                    }while(posiciones[ran1][ran2]);
                }else{
                    do{
                        ran1 = r.nextInt(4) + 46;
                        ran2 = r.nextInt(6) + 21; // generar de 23  a 43
                    }while(posiciones[ran1][ran2]);
                }
                u.setFila(ran1);
                u.setColumna(ran2);
                posiciones[ran1][ran2] = true;
            }else{
                do{
                    ran1 = r.nextInt(23) + 27; // generar de 23  a 43
                    ran2 = r.nextInt(24); 
                }while (posiciones[ran1][ran2] || agua[ran1][ran2]);
                u.setFila(ran1);
                u.setColumna(ran2);
                posiciones[ran1][ran2] = true;
            }
            count++;
        }


    }
    public void genPosUnitR2(){
        //generando los maritimos
        int count = 0;
        for(Unit u: r2.getUnidades()){
            Random r = new Random();
            int ran1, ran2;
            if(u.getTerreno() == 2){
                if(count%2 == 0){
                    do{
                        ran1 = r.nextInt(3);
                        ran2 = r.nextInt(24) + 23;
                    }while(posiciones[ran1][ran2]);
                }else{
                    do{
                        ran1 = r.nextInt(6) + 21;
                        ran2 = r.nextInt(4) + 46;
                    }while(posiciones[ran1][ran2]);
                }

                u.setFila(ran1);
                u.setColumna(ran2);
                posiciones[ran1][ran2] = true;
            }else{
                do{
                    ran1 = r.nextInt(24); // generar de 23  a 43
                    ran2 = r.nextInt(23) + 27; 
                }while (posiciones[ran1][ran2] || agua[ran1][ran2]);
                    u.setFila(ran1);
                    u.setColumna(ran2);
                    posiciones[ran1][ran2] = true;
            }
            count++;
        }
        //generando los terrestres y aereos
    }

    public static Unit genUnit(char c, int cod){
        return null;

    }
}
