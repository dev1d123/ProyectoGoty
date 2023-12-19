import java.util.*;

public class FirstPhase {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Seleccione la epoca del 1er reino.");
        int r1 = sc.nextInt();
        System.out.println("Seleccione la epoca del 2do reino.");
        int r2 = sc.nextInt();
        Reino primerReino = new Reino(r1);
        Reino segundoReino = new Reino(r2);
        boolean exit = false;
        int turno = 0;
        while(turno < 14 || exit){
            System.out.println("¿Que accion desea realizar?");
            
        }
    }
}
