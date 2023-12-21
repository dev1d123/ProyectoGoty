import javax.swing.JOptionPane;

public class JuegoScript {
    private Reino r1;
    private Reino r2;
    private final int MED = 60;
    boolean[][] posiciones = new boolean[60][60];{
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
    };

    //En esta clase se desarrolla toda la logica del videojuego
    public JuegoScript(){
        //Ejemplo
        r1 = new Reino((int)Math.random()*3);
        r2 = new Reino((int) (Math.random()*3));
        genReino(r1);    
        genReino(r2);                                                                                                               
    }
    //Ejemplo
    private void genReino(Reino r){
        for(int i = 0; i < 20; i++){
            int fila;
            int columna;
            do{
                fila = (int)(Math.random()*60);
                columna = (int)(Math.random()*60);
            }while(posiciones[fila][columna]);
            Unit u = new Unit("UNIDAD " + i,(int)(Math.random()*60), (int)(Math.random()*60), (int)(Math.random()*60), (int)(Math.random()*60), "waos", fila, columna);
            r.getUnidades().add(u);
        }
    }
    public Reino getReino1(){
        return r1;
    }
    public Reino getReino2(){
        return r2;
    }
    public boolean victoria(){
        if(r1.getUnidades().size() == 0 || r2.getUnidades().size() == 0){
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
    public static void jugada(Unit soldadoR){
        
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
                mov.setFila(tox);
                mov.setColumna(toy);
            }

        }
    }
}
