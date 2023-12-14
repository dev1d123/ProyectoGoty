public class JuegoScript {
    private Reino r1;
    private Reino r2;

    //En esta clase se desarrolla toda la logica del videojuego
    public JuegoScript(){
        //Ejemplo
        r1 = new Reino();
        r2 = new Reino();
        Unit unidad1 = new Unit(666, 100, 3, 60, "unidad de prueba r1");
        Unit unidad2 = new Unit(100, 61, 3, 60, "unidad de prueba r2");
        unidad1.setColumna(1);
        unidad1.setFila(1);
        unidad2.setColumna(20);
        unidad2.setFila(20);
        r1.getUnits().add(unidad1);
        r2.getUnits().add(unidad2);

    }
    public Reino getReino1(){
        return r1;
    }
    public Reino getReino2(){
        return r2;
    }
    public boolean victoria(){
        if(r1.getUnits().size() == 0 || r2.getUnits().size() == 0){
            return false;
        }
        return true;
    }
    public static Unit seleccion(Reino r, int x, int y){
        for(Unit u: r.getUnits()){
            if(u.getColumna() == x && u.getFila() == y){
                System.out.println("WOW, SELECCIONASTE UN SOLDADO");
                return u;
            }
        }
        return null;
    }
}
