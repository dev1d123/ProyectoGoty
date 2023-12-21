import java.util.*;

public class Reino{
    private int dinero;
    private int recursos;
    private int manuten;
    private int tamaño;
    /*Tamaño del largo de uno de los lados del terreno asignado a cada reino, 
    por ahora siendo parcelas cuadradas*/
    private ArrayList<Unit> unidades;
    private ArrayList<Buildings> edificios;


    public Reino(int epoca) {
        if(epoca == 0){
            this.dinero = 800;
            this.recursos = 1000;
            this.manuten = 25;
            this.tamaño = 10;
            //Tierra Magica
        }else if (epoca == 1){
            this.dinero = 1200;
            this.recursos = 600;
            this.manuten = 20;
            this.tamaño = 10;

            //Edad Contemporanea
        } else if (epoca == 2){
            this.dinero = 900;
            this.recursos = 500;
            this.manuten = 10000;
            this.tamaño = 10;
            //Futuro
        }
    }

    public int getDinero() {
        return dinero;
    }

    public void setDinero(int dinero) {
        this.dinero = dinero;
    }

    public int getRecursos() {
        return recursos;
    }

    public void setRecursos(int recursos) {
        this.recursos = recursos;
    }

    public int getTamaño() {
        return tamaño;
    }

    public void setTamaño(int tamaño) {
        this.tamaño = tamaño;
    }

    public int getManuten() {
        return manuten;
    }

    public void setManuten(int manuten) {
        this.manuten = manuten;
    }

    public ArrayList<Unit> getUnidades(){
        return unidades;
    }

    public void setUnidades(ArrayList<Unit> unidades) {
        this.unidades = unidades;
    }

    public ArrayList<Buildings> getEdificios() {
        return edificios;
    }

    public void setEdificios(ArrayList<Buildings> edificios) {
        this.edificios = edificios;
    }

    public void construirEdificio(){
        ;
    }

    public void destruirEdificio(){
        ;
    }
}
