
import javax.swing.*;
import java.util.*;
public class Preparacion {
    static Scanner sc = new Scanner(System.in);
    static int turnos = 0;
    static PreparacionScript prep;
    static PreparacionField base1;
    static PreparacionField base2;
    static int jugadas = 1;
    public static void fasePrep(char opt1, char opt2){
        prep = new PreparacionScript(opt1, opt2);
        base1 = new PreparacionField(prep.getReino1());
        base2 = new PreparacionField(prep.getReino2());
        JOptionPane.showMessageDialog(null, "Bienvenidos a la fase de preparacion", null, 2);
        //Creamos todos los reinos
        boolean turno1 = false;
        boolean turno2 = false;
        int dia = 1;
        do{
            if(!turno1 && !turno2){
                //JOptionPane.showMessageDialog(null, "DIA " + dia);
                //JOptionPane.showMessageDialog(null, "DIA");
                dia++;

            }else if(turno1 && turno2){
                //JOptionPane.showMessageDialog(null, "NOCHE");
                turno1 = false;
                turno2 = false;
            }
            turnos = turnos%6; //0,1,2,3,4,5,          
            if(turnos == 0 || turnos == 1 || turnos == 2){
                //JOptionPane.showMessageDialog(null, "Turno del jugador 1");
                base2.setVisible(false);                
                base1.setVisible(true);  
                accion(base1, true);
                turno1 = true;
            }else{
                //JOptionPane.showMessageDialog(null, "Turno del jugador 2");
                base1.setVisible(false);
                base2.setVisible(true);  
                accion(base2, false);
                turno2 = true;
            }   

            //JOptionPane.showMessageDialog(null, "Datos R1 " + prep.getReino1());
            //JOptionPane.showMessageDialog(null, "Datos R2 " + prep.getReino2());

        }while(jugadas <= 6); //!!!!!!!!!!!!!!!!!
        JOptionPane.showMessageDialog(null, "Ha terminado");

        Juego.iniciarJuego(prep.getReino1(), prep.getReino2());

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
                    int opcionMenuPrincipal = p.getOpcionSeleccionada();
                    if(opcionMenuPrincipal == 1){
                        int[] cor = b.getCoordenadas();
                        Buildings e = PreparacionScript.obtenerEdificio(prep.getReino1(), p.getIndiceEdificio());
                        base1.construir(cor[0], cor[1], e);
                    }else if(opcionMenuPrincipal == 2){
                        //JOptionPane.showMessageDialog(null, "Crear un trabajador");
                        if(prep.getReino1().getEpoca() == 'I'){
                            prep.getReino1().getUnidades().add(new Unit_Esclavo());
                        }else if(prep.getReino1().getEpoca() == 'R'){
                            prep.getReino1().getUnidades().add(new Unit_Obrero());
                        }else{
                            prep.getReino1().getUnidades().add(new Unit_Robot());
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
                            //JOptionPane.showMessageDialog(null, "No tienes trabajadores");
                        }else{
                            //JOptionPane.showMessageDialog(null, "Removiento un trabadador");
                            prep.getReino1().getUnidades().remove(remover);
                        }      
                    }
                }

            }else{
                opcion = b.getOpcionSeleccionada();
                System.out.println("La opcion de base2 es " + opcion);   
                if(opcion == 1){
                    PreparacionMenu p = new PreparacionMenu(prep.getReino2());
                    int opcionMenuPrincipal = p.getOpcionSeleccionada();
                    if(opcionMenuPrincipal == 1){
                        int[] cor = b.getCoordenadas();
                        Buildings e = PreparacionScript.obtenerEdificio(prep.getReino2(), p.getIndiceEdificio());
                        base2.construir(cor[0], cor[1], e);
                    }else if(opcionMenuPrincipal == 2){
                        JOptionPane.showMessageDialog(null, "Crear un trabajador");
                        if(prep.getReino2().getEpoca() == 'I'){
                            prep.getReino2().getUnidades().add(new Unit_Esclavo());
                        }else if(prep.getReino2().getEpoca() == 'R'){
                            prep.getReino2().getUnidades().add(new Unit_Obrero());
                        }else{
                            prep.getReino2().getUnidades().add(new Unit_Robot());
                        }

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
                            JOptionPane.showMessageDialog(null, "Removiento un trabadador");
                            prep.getReino2().getUnidades().remove(remover);
                        }                    
                    }

                }
            }
            turnos++;     
            jugadas++;      
        }
        System.out.println("FIN-BUCLE");
    }
    

}


