
import javax.swing.*;
import java.util.*;
public class Preparacion {
    static Scanner sc = new Scanner(System.in);
    static int turnos = 0;
    static PreparacionScript prep;
    static PreparacionField base1;
    static PreparacionField base2;

    static int jugadas = 0;

    public static void fasePrep(char opt1, char opt2){
        prep = new PreparacionScript(opt1, opt2);
        boolean esDia = true;
        base1 = new PreparacionField(prep.getReino1(), esDia);
        base2 = new PreparacionField(prep.getReino2(), esDia);
        JOptionPane.showMessageDialog(null, "Bienvenidos a la fase de preparacion", null, 2);
        //Creamos todos los reinos
        int dia = 1;
        int v = 0;
        do{
            if(jugadas%6 == 0){
                if(v%2==0){
                    base1.setDia(true);
                    base2.setDia(true);                 
                }else{
                    base1.setDia(false);
                    base2.setDia(false);  
                }
                v++;
            }
            base1.repintar();
            base2.repintar();
            
            turnos = turnos%6; //0,1,2,3,4,5,          
            if(turnos == 0 || turnos == 1 || turnos == 2){
                //JOptionPane.showMessageDialog(null, "Turno del jugador 1");
                base2.setVisible(false);                
                base1.setVisible(true);  
                accion(base1, true);
            }else{
                //JOptionPane.showMessageDialog(null, "Turno del jugador 2");
                base1.setVisible(false);
                base2.setVisible(true);  
                accion(base2, false);
            }   

        }while(jugadas <= 12); //!!!!!!!!!!!!!!!!!
        JOptionPane.showMessageDialog(null, "Fase de preparacion terminada");

        Juego.iniciarJuego(prep.getReino1(), prep.getReino2());

    }
    //metodo para la accion
    public static void accion(PreparacionField b, boolean t){
        for(int i = 0; i < 3; i++){
            int opcion = -1;

            JOptionPane.showMessageDialog(null, "Turno " + (i+1) + " de " + 3);
            if(t){
                opcion = b.getOpcionSeleccionada();
                if(opcion == 1){
                    prep.getReino1().actualizar();
                    PreparacionMenu p = new PreparacionMenu(prep.getReino1());
                    int opcionMenuPrincipal = p.getOpcionSeleccionada();
                    if(opcionMenuPrincipal == 1){
                        int[] cor = b.getCoordenadas();
                        Buildings e = PreparacionScript.obtenerEdificio(prep.getReino1(), p.getIndiceEdificio());
                        //Se obtiene el costo de e, si es mayor no se construye
                        if(prep.getReino1().getDinero() >= e.getCosto()){
                            base1.construir(cor[0], cor[1], e);
                            prep.getReino1().gastarDinero(e.getCosto());
                            base1.repintar();

                        }else{
                            JOptionPane.showMessageDialog(null, "DINERO INSUFICIENTE");

                        }
                    }else if(opcionMenuPrincipal == 2){
                        //JOptionPane.showMessageDialog(null, "Crear un trabajador");
                        if(prep.getReino1().getEpoca() == 'I'){
                            Unit.crearUnidad(new Unit_Esclavo(), prep.getReino1());
                        }else if(prep.getReino1().getEpoca() == 'R'){
                            Unit.crearUnidad(new Unit_Obrero(), prep.getReino1());
                        }else{
                            Unit.crearUnidad(new Unit_Robot(), prep.getReino1());
                        }
                    }else{
                        boolean valid = true;
                        Unit remover = null;
                        for(Unit u: prep.getReino1().getUnidades()){
                            if(u instanceof Unit_Esclavo || u instanceof Unit_Obrero || u instanceof Unit_Robot){
                                remover = u;                                
                                valid = false;
                                break;
                            }
                        }
                        if(valid){
                            JOptionPane.showMessageDialog(null, "No tienes trabajadores");
                        }else{
                            JOptionPane.showMessageDialog(null, "Removiendo un trabadador");
                            prep.getReino1().getUnidades().remove(remover);
                        }      
                    }
                }
                base1.repintar();

            }else{
                opcion = b.getOpcionSeleccionada();
                System.out.println("La opcion de base2 es " + opcion);   
                if(opcion == 1){
                    prep.getReino2().actualizar();
                    PreparacionMenu p = new PreparacionMenu(prep.getReino2());
                    int opcionMenuPrincipal = p.getOpcionSeleccionada();
                    if(opcionMenuPrincipal == 1){
                        int[] cor = b.getCoordenadas();
                        Buildings e = PreparacionScript.obtenerEdificio(prep.getReino2(), p.getIndiceEdificio());
                        if(prep.getReino2().getDinero() >= e.getCosto()){
                            base2.construir(cor[0], cor[1], e);
                            prep.getReino2().gastarDinero(e.getCosto());
                            base2.repintar();
                        }else{
                            JOptionPane.showMessageDialog(null, "DINERO INSUFICIENTE");
                        }
                    }else if(opcionMenuPrincipal == 2){
                        JOptionPane.showMessageDialog(null, "Crear un trabajador");
                        if(prep.getReino2().getEpoca() == 'I'){
                            Unit.crearUnidad(new Unit_Esclavo(), prep.getReino2());
                        }else if(prep.getReino2().getEpoca() == 'R'){
                            Unit.crearUnidad(new Unit_Obrero(), prep.getReino2());
                        }else{
                            Unit.crearUnidad(new Unit_Robot(), prep.getReino2());
                        }
                        base2.repintar();

                    }else{
                        boolean valid = true;
                        Unit remover = null;
                        for(Unit u: prep.getReino2().getUnidades()){
                            if(u instanceof Unit_Esclavo || u instanceof Unit_Obrero || u instanceof Unit_Robot){
                                remover = u;                                
                                valid = false;
                                break;
                            }
                        }
                        if(valid){
                            JOptionPane.showMessageDialog(null, "No tienes trabajadores");
                        }else{
                            JOptionPane.showMessageDialog(null, "Removiendo un trabadador");
                            prep.getReino2().getUnidades().remove(remover);
                        }                    
                    }
                    base2.repintar();
                }
            }
            turnos++;     
            jugadas++;      
        }
    }
    

}


