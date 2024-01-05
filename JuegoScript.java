import java.awt.Robot;
import java.util.Random;

import javax.swing.JOptionPane;

public class JuegoScript {
    private Reino r1;
    private Reino r2;
    private final int MED = 50;

    private static boolean[][] agua = new boolean[50][50];{
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
                int ataqueMov = mov.getAtaque();
                int defensaSold = sold.getDefensa();
                int danoInfligido = calcularDanoInfligido(ataqueMov, defensaSold);
                sold.recibirDaño(danoInfligido);

                if (sold.estaMuerto()) {
                    enemigo.getUnidades().remove(sold);
                    JOptionPane.showMessageDialog(null, "¡Enemigo eliminado!");
                }                
            }else{
                JOptionPane.showMessageDialog(null, "Moviendose");
                mov.setFila(tox-1);
                mov.setColumna(toy-1);
            }

        }
        
    }
    private static int calcularDanoInfligido(int ataque, int defensa) {
        int danoInfligido = (int) (ataque - defensa);
        return Math.max(danoInfligido, 0); 
    }
    //ASIGNAR POSICIONES ALEATORIAS PARA R1 Y R2
    //PARA R1.
    //cada unidad tiene un tipo
    //1 -> Terrestre
    //2 -> Maritimo
    //3 -> Aereo
    

    //Se llama cuando se crea una unidad en pleno juego
    //Tengo un arreglo con todas las unidades de ambos reinos!!!
    public static void genUnit(Unit crear, Reino r){
        //Genera toda la matriz de booleanos de valores posibles
        //cuando posiciones es true, no puede ir una unidad ahi
        Random random = new Random();
        boolean[][] posiciones = new boolean[50][50];
        //Ubica las posiciones de los reinos y la de las montañas diagonales

        for(int i = 50 - 6; i < 50; i++){
            for (int j = 0; j < 6; j++) {                
                posiciones[i][j] = true;
            }
        }
        for(int i = 0; i < 6; i++){
            for (int j = 50 - 6; j < 50; j++) {
                posiciones[i][j] = true;
            }
        }
        for(int i = 6, j = 43; i <= 43 || j >=6; i++, j--){
            posiciones[i][j] = true;
        }
        
        //si la unidad es de tipo terrestre -> 1 (Todos los valores de mar son true)
        if(crear.getTerreno() == 1){
            for(int i = 0; i <= 43; i++){
                for(int j = 0; j <= 3; j++){
                    posiciones[i][j] = true;
                }
            }
            for(int i = 0; i <= 3; i++){
                for(int j = 0; j <= 43; j++){
                    posiciones[i][j] = true;
                }
            }
            for(int i = 6; i <= 46; i++){
                for(int j = 46; j <= 49; j++){
                    posiciones[i][j] = true;
                }
            }
            for(int i = 46; i <= 49; i++){
                for(int j = 6; j <= 49; j++){
                    posiciones[i][j] = true;    
                }
            }
        }
        //Si la unidad es de tipo acuatica -> 2 (Todos los valores de tierra son true
        if(crear.getTerreno() == 2){
            for(int i = 5; i <= 44; i++){
                for(int j = 5; j<=44; j++){
                    posiciones[i][j] = true;
                }
            }
        }

        
        //Genera una unidad crear del reino r
        int filaGenerada;
        int columnaGenerada;
        if(r.getAux() == 1){
            do{ 
                filaGenerada = random.nextInt(26) + 23; //desde 49 - 24
                columnaGenerada = random.nextInt(24); //desde 0 - 24
            }while(posiciones[filaGenerada][columnaGenerada]);
        }else{
            do{ 
                filaGenerada = random.nextInt(24); //desde 49 - 24
                columnaGenerada = random.nextInt(26) + 23; //desde 0 - 24
            }while(posiciones[filaGenerada][columnaGenerada]);
        }
        crear.setFila(filaGenerada);
        crear.setColumna(columnaGenerada);

    }
}
