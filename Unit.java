public class Unit{
    private int vida;
    private String nombre;
    private int ataque;
    private int velocidad;
    private int pp;
    private int fila;
    private int columna;
    private String habilidad;
    
    public Unit(String nombre, int vida, int ataque, int velocidad, int pp, String habilidad, int fila, int columna) {
        this.nombre = nombre;
        this.vida = vida;
        this.ataque = ataque;
        this.velocidad = velocidad;
        this.pp = pp;
        this.habilidad = habilidad;
        this.fila = fila;
        this.columna = columna;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public int getAtaque() {
        return ataque;
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

    public int getPp() {
        return pp;
    }

    public void setPp(int pp) {
        this.pp = pp;
    }

    public String getHabilidad() {
        return habilidad;
    }

    public void setHabilidad(String habilidad) {
        this.habilidad = habilidad;
    }
    public int getFila() {
        return fila;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }
    public int getColumna() {
        return columna;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }
    public String[] getOpciones(){
        String[] opt = new String[3];
        opt[0] = nombre;
        opt[1] = "Mover/Atacar";
        opt[2] = "Habilidad";

        return opt;
    }
    public String[] getDatos(){
        String[] dat = new String[4];
        dat[0] = "Vida: " + vida;
        dat[1] = "Ataque: " + ataque;
        dat[2] = "Velocidad: " + velocidad;
        dat[3] = "Puntos de magia: " + pp;
        return dat;
    }
}
