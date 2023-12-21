Public Class PraparacionScript{
    public static void main(String [] args){
        Reino r1 = new Reino(1);
        Reino r2 = new Reino(1);
        int evt;
        for(int i = 0; i < 14 ; i++){
            evt = (int)(Math.random()*20);
            if(evt<3){
                event(r1)
            }
        }
    }
//Prob. de entrar al metodo, 3/20
    public static void event(Reino re){
        int rand = (int)(Math.random()*6);
        Boolean desicion;
//Tiempos de abundancia (B)
        if(rand == 0){
            int food = re.getManuten()*2;
            if(food > 120){
                int cash = (food-120)*10;
                food = 120;
            }
            re.setManuten(food);
            System.out.println("- Este año la cosecha ha sido buena. Tu manutencion se ha duplicado. ¡Y ademas hemos vendido el excendente! -");
//Supermena de minerales
        }else if(rand == 1){
          System.out.println(" Nuestros recolectores han encontrado una supermena de minerales");
//Sequia (M)
        }else if(rand == 2){
            System.out.println(" - Una sequia ha azotado el reino. Nuestras tropas estan padeciendo. No Hay Nada Que Podamos Hacer... -");
//LEPRECHAUN! (N)
        }else if(rand == 3){
            rand = (int)(Math.random()*4);
            System.out.println("- Un misterioso duende ha tocado la puerta de tu reino y te esta ofreciendo riquezas invaluables ¿Sera una trampa? - ");
            if(decision){
              int cash;
              if(rand =! 0){
                  cash = re.getDinero()*2;
                  re.setDinero(cash);
                  System.out.println("- El duende te ha guiado al tesoro al final del arcoiris. ¡Enhorabuena! Tus reservas monetarias se han duplicado -");
              } else {
                  cash = (int)(re.getDinero()*2/3);
                  re.setDinero(cash);
                  System.out.println("- ¡El duende te ha tendido una trampa! Se ha robado la tercera parte de tu oro -");
              }
            } else {
              System.out.println("- El duende se ha marchado. No hay cambios en el reino -");
            }
//Cazarrecompensas (N) 
        }else if(rand == 4){
            System.out.println("- El cazarrecompesas ha tocado la puerta de tu reino. Por una buena cantidad de oro, estaria dispuesto a unirse a nuestro ejercito -");
            des = sc.nextBoolean();
            if(decision){
               int cash = re.getDinero() - 350;
               re.setDinero(cash);
               //Se añade una unidad CazRec al ejercito del Reino 
            } else {
                System.out.println("- El cazarrecompensas se ha marchado. Ha mencionado que buscara un mejor reino al que ofrecer sus servicios -");
                //El evento cazarrecompensas vengativo es activado para el reino rival
            }

        }else if(rand == 5){
//La caja misteriosa (N) 
            System.out.println("- Una caja misteriosa ha aparecido en el ayuntamiento. La etiqueta menciona que solo los mas valientes se atreven a conocer su contenido -");
            if(desicion){
                System.out.println("- Has abierto la caja de Pandora. Tu reino sufre las consecuencias -");
            } else {
                System.out.println("- Has decidido no abrir la caja. No hay cambios en el reino -");
            }
        }
}
