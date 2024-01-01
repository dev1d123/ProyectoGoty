import javax.swing.JOptionPane;
import javax.swing.text.AsyncBoxView;

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
        r1 = new Reino(opt1);
        r2 = new Reino(opt2);                                                                                                           
    }

    public Reino getReino1(){
        return r1;
    }
    public Reino getReino2(){
        return r2;
    }

    //Codigo para poner un edificio (validar)
    public boolean esvalidoR1(int x, int y){
        //Verificar que no ponga el edificio en la base
        if(posR1[x][y]){
            return false;
        }else{
            posR1[x][y] = true;
            return true;
        }
    }
    public boolean esvalidoR2(int x, int y){
        //Verificar que no ponga el edificio en la base
        if(posR2[x][y]){
            return false;
        }else{
            posR1[x][y] = true;
            return true;
        }
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

    public static void genEvento(Reino re){
        int evt = (int)(Math.random()*20);
        if (evt < 3) {
            event(re);
        }
    }
    public static void event(Reino re) {
        int rand = (int) (Math.random() * 6);

        // Calcular probabilidades acumulativas
        int probAbundancia = 5;
        int probMinerales = probAbundancia + 5;
        int probSequia = probMinerales + 5;
        int probLeprechaun = probSequia + 5;
        int probCazarrecompensas = probLeprechaun + 5;
        int probCajaMisteriosa = probCazarrecompensas + 5;

        if (rand < probAbundancia) {
            System.out.println("- Este año la cosecha ha sido buena. Tu manutencion se ha duplicado. ¡Y ademas hemos vendido el excendente! -");
        } else if (rand < probMinerales) {
            System.out.println(" Nuestros recolectores han encontrado una supermena de minerales");
        } else if (rand < probSequia) {
            System.out.println(" - Una sequia ha azotado el reino. Nuestras tropas estan padeciendo. No Hay Nada Que Podamos Hacer... -");
        } else if (rand < probLeprechaun) {
            int decision = (int) (Math.random() * 2);
            System.out.println("- Un misterioso duende ha tocado la puerta de tu reino y te esta ofreciendo riquezas invaluables ¿Sera una trampa? - ");
            if (decision == 1) {
                int cash;
                if (rand != 0) {
                    cash = re.getDinero() * 2;
                    re.setDinero(cash);
                    System.out.println("- El duende te ha guiado al tesoro al final del arcoiris. ¡Enhorabuena! Tus reservas monetarias se han duplicado -");
                } else {
                    cash = (int) (re.getDinero() * 2 / 3);
                    re.setDinero(cash);
                    System.out.println("- ¡El duende te ha tendido una trampa! Se ha robado la tercera parte de tu oro -");
                }
            } else {
                System.out.println("- El duende se ha marchado. No hay cambios en el reino -");
            }
        } else if (rand < probCazarrecompensas) {
            System.out.println("- El cazarrecompesas ha tocado la puerta de tu reino. Por una buena cantidad de oro, estaria dispuesto a unirse a nuestro ejercito -");
            boolean decision = Math.random() < 0.5;
            if (decision) {
                int cash = re.getDinero() - 350;
                re.setDinero(cash);
                // Se añade una unidad CazRec al ejercito del Reino
            } else {
                System.out.println("- El cazarrecompensas se ha marchado. Ha mencionado que buscara un mejor reino al que ofrecer sus servicios -");
                // El evento cazarrecompensas vengativo es activado para el reino rival
            }
        } else if (rand < probCajaMisteriosa) {
            boolean decision = Math.random() < 0.5;
            System.out.println("- Una caja misteriosa ha aparecido en el ayuntamiento. La etiqueta menciona que solo los más valientes se atreven a conocer su contenido -");
            if (decision) {
                System.out.println("- Has abierto la caja de Pandora. Tu reino sufre las consecuencias -");
            } else {
                System.out.println("- Has decidido no abrir la caja. No hay cambios en el reino -");
            }
        }
    }
}
//public class PreparacionScript{
//    public static void main(String [] args){
//        Reino r1 = new Reino('R');
//        Reino r2 = new Reino('R');
//        int evt;
//        for(int i = 0; i < 14 ; i++){
//            evt = (int)(Math.random()*20);
//            if(evt<3){
//                event(r1);
//            }
//
//        }
//    }
//
////Prob. de entrar al metodo, 3/20
//    public static void event(Reino re){
//
//        int rand = (int)(Math.random()*6);
//        boolean desicion = false;
//
////Tiempos de abundancia (B)
//        if(rand == 0){
//            int food = re.getManuten()*2;
//            if(food > 120){
//                int cash = (food-120)*10;
//                food = 120;
//            }
//            re.setManuten(food);
//            System.out.println("- Este año la cosecha ha sido buena. Tu manutencion se ha duplicado. ¡Y ademas hemos vendido el excendente! -");
////Supermena de minerales
//        }else if(rand == 1){
//          System.out.println(" Nuestros recolectores han encontrado una supermena de minerales");
////Sequia (M)
//        }else if(rand == 2){
//            System.out.println(" - Una sequia ha azotado el reino. Nuestras tropas estan padeciendo. No Hay Nada Que Podamos Hacer... -");
////LEPRECHAUN! (N)
//        }else if(rand == 3){
//            rand = (int)(Math.random()*4);
//            System.out.println("- Un misterioso duende ha tocado la puerta de tu reino y te esta ofreciendo riquezas invaluables ¿Sera una trampa? - ");
//            if(decision){
//              int cash;
//              if(rand =! 0){
//                  cash = re.getDinero()*2;
//                  re.setDinero(cash);
//                  System.out.println("- El duende te ha guiado al tesoro al final del arcoiris. ¡Enhorabuena! Tus reservas monetarias se han duplicado -");
//              } else {
//                  cash = (int)(re.getDinero()*2/3);
//                  re.setDinero(cash);
//                  System.out.println("- ¡El duende te ha tendido una trampa! Se ha robado la tercera parte de tu oro -");
//              }
//            } else {
//              System.out.println("- El duende se ha marchado. No hay cambios en el reino -");
//            }
////Cazarrecompensas (N) 
//        }else if(rand == 4){
//            System.out.println("- El cazarrecompesas ha tocado la puerta de tu reino. Por una buena cantidad de oro, estaria dispuesto a unirse a nuestro ejercito -");
//            des = sc.nextBoolean();
//            if(decision){
//               int cash = re.getDinero() - 350;
//               re.setDinero(cash);
//               //Se añade una unidad CazRec al ejercito del Reino 
//            } else {
//                System.out.println("- El cazarrecompensas se ha marchado. Ha mencionado que buscara un mejor reino al que ofrecer sus servicios -");
//                //El evento cazarrecompensas vengativo es activado para el reino rival
//            }
//
//        }else if(rand == 5){
////La caja misteriosa (N) 
//            System.out.println("- Una caja misteriosa ha aparecido en el ayuntamiento. La etiqueta menciona que solo los mas valientes se atreven a conocer su contenido -");
//            if(desicion){
//                System.out.println("- Has abierto la caja de Pandora. Tu reino sufre las consecuencias -");
//            } else {
//                System.out.println("- Has decidido no abrir la caja. No hay cambios en el reino -");
//            }
//        }
//    }
//  }
//