public class Reino{
    private int dinero;
    private int recursos;
    private int manuten;
    private int tamaño;
    /*Tamaño del largo de uno de los lados del terreno asignado a cada reino, 
    por ahora siendo parcelas cuadradas*/
    private int edificios;
    //Numero de edificios que tiene el reino

    public Reino(int epoca) {
        if(epoca == 1){
            this.dinero = 800;
            this.recursos = 1000;
            this.manuten = 25;
            this.tamaño = 10;
            this.edificios = 4;
        }else if (epoca == 2){
            this.dinero = 1200;
            this.recursos = 600;
            this.manuten = 20;
            this.tamaño = 10;
            this.edificios = 3;
        } else if (epoca == 3){
            this.dinero = 900;
            this.recursos = 500;
            this.manuten = 10000;
            this.tamaño = 10;
            this.edificios = 2;
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

    public int getEdificios() {
        return edificios;
    }

    public void setEdificios(int edificios) {
        this.edificios = edificios;
    }
    
    public void construirEdificio(){
        edificios += 1;
    }

    public void destruirEdificio(){
        edificios -=1 ;
    }

    public int getManuten() {
        return manuten;
    }

    public void setManuten(int manuten) {
        this.manuten = manuten;
    }
}
