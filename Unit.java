public class Unit{
    private int vida;
    private int ataque;
    private int velocidad;
    private int pp;
    private int fila;
    private int columna;
    private String habilidad;
    
    public Unit(int vida, int ataque, int velocidad, int pp, String habilidad) {
        this.vida = vida;
        this.ataque = ataque;
        this.velocidad = velocidad;
        this.pp = pp;
        this.habilidad = habilidad;
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
}
