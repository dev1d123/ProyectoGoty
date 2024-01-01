import java.util.ArrayList;

import javax.swing.ImageIcon;

public abstract class Buildings{
    protected int life;
    protected int attack;
    protected int defense;
    protected int absorption;

    protected int fila = -1;
    protected int columna = -1;
    protected String nombre;
    protected ArrayList<String> acciones = new ArrayList<String>();

    public Buildings(String n, int life, int attack, int defense, int absorption) {
        nombre = n;
        this.life = life;
        this.attack = attack;
        this.defense = defense;
        this.absorption = absorption;
    }

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getAbsorption() {
        return absorption;
    }

    public void setAbsorption(int absorption) {
        this.absorption = absorption;
    }
    public abstract ArrayList<String> getHabilidades();
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
    public abstract ImageIcon getIcon();
}