import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public abstract class Buildings implements Serializable{
    protected int life;
    protected int costo;

    protected int fila = -1;
    protected int columna = -1;
    protected String nombre;
    protected ArrayList<String> acciones = new ArrayList<String>();
    protected ArrayList<Integer> codigoAcciones = new ArrayList<Integer>();
    public Buildings(String n, int costo) {
        nombre = n;
        this.costo = costo;
    }

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }
    public int getCosto(){
        return costo;
    }
    public String getNombre(){
        return nombre;
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

    public int getOpcionEdificio(){
        Object[] optionsArray = acciones.toArray();
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
    public String getName(){
        return nombre;
    }

    public abstract void hacerAccion(Reino re);
}