import java.util.ArrayList;

public class Reino{
    private int dinero;
    private int recursos;
    private int manuten;
    private int tamaño;
    /*Tamaño del largo de uno de los lados del terreno asignado a cada reino, 
    por ahora siendo parcelas cuadradas*/
    private int edificios;
    //Numero de edificios que tiene el reino
    private ArrayList<Unit> unidades = new ArrayList<Unit>();
    
    public Reino() {
        this.dinero = 800;
        this.recursos = 800;
        this.manuten = 20;
        this.tamaño = 10;
        this.edificios = 3;
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

    public int getEdificios() {
        return edificios;
    }

    public void setEdificios(int edificios) {
        this.edificios = edificios;
    }

    public int getManuten() {
        return manuten;
    }

    public void setManuten(int manuten) {
        this.manuten = manuten;
    }
    public ArrayList<Unit> getUnits(){
        return unidades;
    }
}
