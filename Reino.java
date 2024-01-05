import java.util.*;

import javax.swing.JOptionPane;

public class Reino{
    private int dinero;
    private int recursos;
    private int manutenMaxima = 0;
    private int manutenUsada = 0;
    private int tamaño;
    private int invasores = 0;
    /*Tamaño del largo de uno de los lados del terreno asignado a cada reino, 
    por ahora siendo parcelas cuadradas*/
    private ArrayList<Unit> unidades = new ArrayList<Unit>();
    private ArrayList<Buildings> edificios = new ArrayList<Buildings>();

    private char epoca;
    private int aux;
    public Reino(char e, int num) {
        this.epoca = e;
        aux = num;
        if(epoca == 'I'){
            this.dinero = 800;
            this.recursos = 1000;
            this.manutenMaxima = 20;
            this.tamaño = 10;
            //Tierra Magica
        }else if (epoca == 'R'){
            this.dinero = 1200;
            this.recursos = 600;
            this.manutenMaxima = 20;
            this.tamaño = 10;

            //Edad Contemporanea
        } else if (epoca == 'D'){
            this.dinero = 900;
            this.recursos = 500;
            this.manutenMaxima = 100;
            this.tamaño = 10;
            //Futuro
        }
    }
    public int getAux(){
        return aux;
    }
    public String getTipo(){
        if(epoca == 'I') return "IMPERIO MEDIEVAL";
        else if(epoca == 'R') return "REPUBLICA CONTEMPORANEA";
        else return "DICTADURA FUTURISTA";
    }
    public char getEpoca(){
        return epoca;
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

    public int getManutenMaxima() { 
        int ans = 20;

        for(Buildings b: edificios){
            if(b.getNombre().equals("Granja") || b.getNombre().equals("Asimilador") || b.getNombre().equals("Supermercado")){
                ans+=5;
            }
        }
        return Math.max(100, ans);
    }

    public int getManutenActual(){
        int ans = 0;
        for(Unit u: this.getUnidades()){
            ans += u.getManuten();
        }
        return ans;
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


    public String[] getData(){
        //Si queremos incluir sistemas de actualizaciones ver aqui
        String[] wow = new String[6];
        if(epoca == 'I'){
            wow[0] = "Escuela de soldados";
            wow[1] = "Puerto";
            wow[2] = "Criadero de Dragones";
            wow[3] = "Granja";
            wow[4] = "Herreria";
            wow[5] = "Torre";
        }else if (epoca == 'R'){
            wow[0] = "Cuartel";
            wow[1] = "Marina";
            wow[2] = "Fuerza aerea";
            wow[3] = "SuperMercado";
            wow[4] = "Manhattan";
            wow[5] = "Domo de hierro";
        } else if (epoca == 'D'){
            wow[0] = "Factory";
            wow[1] = "UnderSea";
            wow[2] = "UFactory";
            wow[3] = "Asimilador";
            wow[4] = "Arsenal";
            wow[5] = "Torre centinela";
        }
        return wow;
    }
    public String toString(){
        String infoE = "";
        for(Buildings b: edificios){
            infoE += b.getName()+"\n";
        }
        String infoU = "";
        for(Unit u: unidades){
            infoE += u.getNombre()+"\n";
        }
        return "Datos de edificios\n"+
        infoE + "\nDatos de unidades\n" + infoU +"\n";
    }
    public int getInvasores(){
        return invasores;
    }   
    public void setInvasores(int v){
        invasores = v;
    }
    public void gastarDinero(int v){
        dinero = dinero - v;
    }
    public void gastarRecursos(int v){
        recursos = recursos - v;
    }
    public void actualizar(){
        int oroGanado = 0;
        int recursosGanados = 0;
        for(Buildings b: edificios){
            if(b.getNombre().equals("Obrero") || b.getNombre().equals("Esclavo") || b.getNombre().equals("Robot")){
                oroGanado+=20;
                recursosGanados+=20;
            }
        }
        setDinero(getDinero() + oroGanado);
        setRecursos(getRecursos() + recursosGanados);

    }
    public String getDatosFinales() {
        StringBuilder datos = new StringBuilder();

        datos.append("Dinero: ").append(dinero).append("\n");
        datos.append("Recursos: ").append(recursos).append("\n");
        datos.append("ManutenMaxima: ").append(manutenMaxima).append("\n");
        datos.append("ManutenUsada: ").append(manutenUsada).append("\n");
        datos.append("Tamaño: ").append(tamaño).append("\n");
        datos.append("Invasores: ").append(invasores).append("\n");

        datos.append("Unidades:\n");
        for (Unit unidad : unidades) {
            datos.append(" - ").append(unidad.getNombre()).append("\n");
        }

        datos.append("Edificios:\n");
        for (Buildings edificio : edificios) {
            datos.append(" - ").append(edificio.getNombre()).append("\n");
        }

        return datos.toString();
    }

}