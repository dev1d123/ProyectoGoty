import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public abstract class Unit{
    protected int vida;
    protected String nombre;
    protected int ataque;
    protected int defensa;
    protected int velocidad;
    protected int pp;
    protected int fila;
    protected int columna;
    protected int terreno;
    protected ArrayList<String> habilidades = new ArrayList<String>();
    protected boolean estaVivo = true;
    protected int ppMaximo;
    protected int vidaMaxima;

    protected int costo = 0;
    protected int recursos = 0;
    protected int manuten = 0;

    public Unit(String nombre, int vida, int ataque, int defensa, int velocidad, int pp) {
        this.nombre = nombre;
        this.vida = vida;
        this.ataque = ataque;
        this.defensa = defensa;
        this.velocidad = velocidad;
        this.pp = pp;
        vidaMaxima = vida;
        ppMaximo = pp;
    }
    public void setPrecios(int c, int r, int m){
        costo = c;
        recursos = r;
        manuten = m;
    }
    public int getManuten(){
        return manuten;
    }
    public int getCosto(){
        return costo;
    }
    public int getRecursos(){
        return recursos;
    }

    public String getNombre(){
        return nombre;
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

    public ArrayList<String> getHabilidad() {
        return habilidades;
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
    public int getOpcionUnidad(){
        Object[] optionsArray = habilidades.toArray();
        int choice = JOptionPane.showOptionDialog(
            null,
            "Selecciona una opción:",
            "Ejemplo de JOptionPane",
            JOptionPane.DEFAULT_OPTION,
            JOptionPane.QUESTION_MESSAGE,
            null,
            optionsArray,
            optionsArray[0]
        );
        return choice;
    }
    public int getTerreno(){
        return terreno;
    }
    public int hacerAccion(Reino re, Field mapa){
        return -10;
    }
    public int getVidaMaxima(){
        return vidaMaxima;
    }
    public abstract ImageIcon getIcon();

    public int getDefensa(){
        return defensa;
    }
    public void setDefensa(int d){
        defensa = d;
    }
    public int getPpMax(){
        return ppMaximo;
    }
    public static void crearUnidad(Unit crear, Reino r){
        if(r.getDinero() >= crear.getCosto() && r.getRecursos() >= crear.getRecursos() && (r.getManutenActual() + crear.getManuten() <= r.getManutenMaxima())){
            r.getUnidades().add(crear);
            r.gastarDinero(crear.getCosto());
            r.gastarRecursos(crear.getRecursos());
            //La manutencion actual se actualiza sola
            //Asignando las posiciones de la unidad

            JuegoScript.genUnit(crear, r);
            return;
        }
        JOptionPane.showMessageDialog(null, "Insuficinte oro, recurso o manutencion");
    }
    public void recibirDaño(int d){
        vida = vida - d;
        if(vida <= 0){
            estaVivo = false;
        }
    }
    public boolean estaMuerto(){
        return !estaVivo;
    }
}
