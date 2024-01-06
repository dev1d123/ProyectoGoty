public class PreparacionScript{
    private Reino r1;
    private Reino r2;
    private final int MED = 10;
    boolean[][] posR1 = new boolean[MED][MED];{
        for (int i = 6; i <= 9; i++) {
            for (int j = 3; j <= 6; j++) {
                posR1[i][j] = true;
            }
        }
    };
    boolean[][] posR2 = new boolean[MED][MED];{
        for (int i = 6; i <= 9; i++) {
            for (int j = 3; j <= 6; j++) {
                posR2[i][j] = true;
            }
        }
    };

    public PreparacionScript(char opt1, char opt2){
        //Literalmente estos van a ser los reinos que se usaran en todo el codigo.
        r1 = new Reino(opt1, 1);
        r2 = new Reino(opt2, 2);                                                                                                           
    }

    public Reino getReino1(){
        return r1;
    }
    public Reino getReino2(){
        return r2;
    }


    //metodo estatico para ver el indice del edificio y crear el edificio!!!
    public static Buildings obtenerEdificio (Reino re, int index){
        Buildings contenedor = null;
        if(re.getEpoca() == 'I'){
            switch (index) {
                case 0:
                    contenedor = new Escuela();
                    break;
                case 1:
                    contenedor = new Puerto();
                    break;
                case 2:
                    contenedor = new Criadero();
                    break;
                case 3:
                    contenedor = new Granjas();
                    break;
                case 4:
                    contenedor = new Herreria();
                    break;
                case 5:
                    contenedor = new Torre();
                    break;
            }
        }else if (re.getEpoca() == 'R'){
            switch (index) {
                case 0:
                    contenedor = new Cuartel();
                    break;
                case 1:
                    contenedor = new Marina();
                    break;
                case 2:
                    contenedor = new FuerzaAerea();
                    break;
                case 3:
                    contenedor = new Supermercado();
                    break;
                case 4:
                    contenedor = new Manhattan();
                    break;
                case 5:
                    contenedor = new Domo();
                    break;
            }
        }else if(re.getEpoca() == 'D'){
            switch (index) {
                case 0:
                    contenedor = new Factory();
                    break;
                case 1:
                    contenedor = new UnderSea();
                    break;
                case 2:
                    contenedor = new UFactory();
                    break;
                case 3:
                    contenedor = new Asimilador();
                    break;
                case 4:
                    contenedor = new Arsenal();
                    break;
                case 5:
                    contenedor = new TorresCentinela();
                    break;
            }
        }   
        return contenedor;
    }

}