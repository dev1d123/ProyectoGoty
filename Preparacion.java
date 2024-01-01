
import javax.swing.*;
import java.util.*;
public class Preparacion {
    static Scanner sc = new Scanner(System.in);
    static int turnos = 0;
    static PreparacionScript prep = new PreparacionScript('R', 'D');
    static PreparacionField base1 = new PreparacionField(prep.getReino1());
    static PreparacionField base2 = new PreparacionField(prep.getReino2());
    public static void main(String[] args){
        JOptionPane.showMessageDialog(null, "Bienvenidos a la fase de preparacion", null, 2);
        //Creamos todos los reinos

        do{
            turnos = turnos%6; //0,1,2,3,4,5,          
            if(turnos == 0 || turnos == 1 || turnos == 2){
                JOptionPane.showMessageDialog(null, "Turno del jugador 1");
                base2.setVisible(false);                
                base1.setVisible(true);  
                accion(base1, true);
            }else{
                JOptionPane.showMessageDialog(null, "Turno del jugador 2");
                base1.setVisible(false);
                base2.setVisible(true);  
                accion(base2, false);
            }   
        }while(true); 
    }
    //metodo para la accion
    public static void accion(PreparacionField b, boolean t){
        for(int i = 0; i < 3; i++){
            int opcion = -1;
            //Los eventos solo se producen una vez en el dia o una vez en la noche.
            if(i == 0){
                if(t) PreparacionScript.genEvento(prep.getReino1());
                else PreparacionScript.genEvento(prep.getReino2());
            }
            JOptionPane.showMessageDialog(null, "Turno " + (i+1) + " de " + 3);
            if(t){
                opcion = b.getOpcionSeleccionada();
                if(opcion == 1){
                    PreparacionMenu p = new PreparacionMenu(prep.getReino1());
                    //
                    System.out.println("Seleccionaste la opcion " + p.getOpcionSeleccionada());
                    int[] cor = b.getCoordenadas();
                    Buildings e = PreparacionScript.obtenerEdificio(prep.getReino1(), p.getIndiceEdificio());
                    base1.construir(cor[0], cor[1], e);
                }else{
                    System.out.println("Wow es la opcion 2 , fabricar un soldado");

                }   

            }else{
                opcion = b.getOpcionSeleccionada();
                System.out.println("La opcion de base2 es " + opcion);   
                if(opcion == 1){
                    PreparacionMenu p = new PreparacionMenu(prep.getReino2());
                    System.out.println("Seleccionaste la opcion " + p.getOpcionSeleccionada());
                    int[] cor = b.getCoordenadas();
                    Buildings e = PreparacionScript.obtenerEdificio(prep.getReino2(), p.getIndiceEdificio());
                    base2.construir(cor[0], cor[1], e);

                }else{
                    System.out.println("Wow es la opcion 2 , fabricar un soldado");

                }  
            }
            turnos++;           
        }
        System.out.println("FIN-BUCLE");
    }
    

}


