import java.util.Random;

import javax.print.attribute.standard.JobPrioritySupported;
import javax.swing.JOptionPane;

public class Habilidades {
    //recibe codigo y ejecuta una accion
    //100-> Soldado(Ataquedesenfrenado)
    //101-> Dragon(Bola magma)
    private static Unit caster;
    private static int xObj;
    private static int yObj;
    private static Reino amigo;
    private static Reino enemigo;
    public static void habilidad(int cod, Unit caster, int xObj, int yObj, Reino amigo, Reino enemigo, Field campo){
        
        if(cod == 100){
            ataqueDesenfrenado(caster, xObj, yObj, amigo, enemigo);
        }else if(cod == 101){
            asediar(caster, xObj, yObj, amigo, enemigo);
        }else if(cod == 102){
            bolaArdiente(caster, xObj, yObj, amigo, enemigo); //dragon
        }else if(cod == 103){
            jinete(caster, xObj, yObj, amigo, enemigo); //dragon
        }else if(cod == 104){
            cargar(caster, xObj, yObj, amigo, enemigo); //caballero
        }else if(cod == 105){
            curacionMagica(caster, xObj, yObj, amigo, enemigo); //mago
        }else if (cod == 106){
            controlMental(caster, xObj, yObj, amigo, enemigo); //mago
        }else if (cod == 107){
            debilitar(caster, xObj, yObj, amigo, enemigo); //alquimista
        }else if(cod == 108){
            fortalecer(caster, xObj, yObj, amigo, enemigo); //alquimista
        }else if(cod == 109){
            pocionSecreta(caster, xObj, yObj, amigo, enemigo); //alquimista
        }else if(cod == 110){
            bombardear(caster, xObj, yObj, amigo, enemigo); //caza
        }else if(cod == 111){
            misilNuclear(caster, xObj, yObj, amigo, enemigo); //caza
        }else if(cod == 112){
            almacenAviones(caster,  xObj, yObj, amigo, enemigo); //portaaviones
        }else if(cod == 113){
            almacenUnidades(caster,  xObj, yObj, amigo, enemigo); //aviones
        }else if(cod == 114){
            bombaDron(caster,  xObj, yObj, amigo, enemigo); //dron
        }else if(cod == 115){
            curarArea(caster,  xObj, yObj, amigo, enemigo); //medico
        }else if(cod == 116){
            gasVeneno(caster,  xObj, yObj, amigo, enemigo); //medico
        }else if(cod == 117){
            hiperVelocidad(caster,  xObj, yObj, amigo, enemigo); //soldier
        }else if(cod == 118){
            rafaga(caster,  xObj, yObj, amigo, enemigo); //airsoldier
        }else if(cod == 119){
            ataquePEM(caster,  xObj, yObj, amigo, enemigo); //seaSoldier
        }else if(cod == 120){
            cañonYamato(caster,  xObj, yObj, amigo, enemigo); //cruceroBatalla
        }else if(cod == 121){
            torpedo(caster,  xObj, yObj, amigo, enemigo); //submarino
        }else if(cod == 122){
            abducir(caster,  xObj, yObj, amigo, enemigo); //ufo
        }else if(cod == 123){
            teletransportar(caster,  xObj, yObj, amigo, enemigo, campo); //ufo
        }else if(cod == 124){
            cañonRayosGamma(caster,  xObj, yObj, amigo, enemigo); //ufo
        }else if(cod == 125){
            aniquilar(caster,  xObj, yObj, amigo, enemigo);
        }

    }
    public static void ataqueDesenfrenado(Unit caster, int xObj, int yObj, Reino amigo, Reino enemigo){
        int rango = 1;
        int x = caster.getFila();
        int y = caster.getColumna();
        double distancia = Math.sqrt(Math.pow(xObj - x, 2) + Math.pow(yObj - y, 2));
        if (distancia <= rango) {
            JOptionPane.showMessageDialog(null, "El objetivo está dentro del rango para el ataque desenfrenado.");
            Unit obj = findUnit(xObj, yObj, enemigo);
            if(obj != null){
                JOptionPane.showMessageDialog(null, "Atacando a " + obj.getNombre());
            }else{
                JOptionPane.showMessageDialog(null, "No hay objetivo");    
            }
        } else {
            JOptionPane.showMessageDialog(null, "El objetivo está fuera del rango para el ataque desenfrenado.");
        }

    }
    public static void asediar(Unit caster, int xObj, int yObj, Reino amigo, Reino enemigo){
        int rango = 5;
        int x = caster.getFila();
        int y = caster.getColumna();

        double distancia = Math.sqrt(Math.pow(xObj - x, 2) + Math.pow(yObj - y, 2));

        if (distancia <= rango) {
            JOptionPane.showMessageDialog(null, "El objetivo está dentro del rango para el asedio.");
            Unit obj = findUnit(xObj, yObj, enemigo);
            if(obj != null){
                JOptionPane.showMessageDialog(null, "Asedio a distancia a " + obj.getNombre());
            }else{
                JOptionPane.showMessageDialog(null, "No hay objetivo");    
            }
        } else {
            JOptionPane.showMessageDialog(null, "El objetivo está fuera del rango para el ataque desenfrenado.");
        }

    }
    public static void bolaArdiente(Unit caster, int xObj, int yObj, Reino amigo, Reino enemigo) {
        int rangoMinimo = 1;
        int rangoZonaImpacto = 1;
        int x = caster.getFila();
        int y = caster.getColumna();
    
        int distancia = Math.max(Math.abs(xObj - x), Math.abs(yObj - y));
    
        if (distancia >= rangoMinimo && distancia <= rangoZonaImpacto) {
            JOptionPane.showMessageDialog(null, "El objetivo está en el rango deseado y al menos a 1 casilla de distancia.");
    
            for (int i = xObj - rangoZonaImpacto; i <= xObj + rangoZonaImpacto; i++) {
                for (int j = yObj - rangoZonaImpacto; j <= yObj + rangoZonaImpacto; j++) {
                    if (Math.sqrt(Math.pow(i - xObj, 2) + Math.pow(j - yObj, 2)) <= rangoZonaImpacto) {
                        Unit obj = findUnit(i, j, enemigo);
                        if (obj != null) {
                            JOptionPane.showMessageDialog(null, "Asedio a distancia a " + obj.getNombre() + " en la posición (" + i + ", " + j + ")");
                        } else {
                            JOptionPane.showMessageDialog(null, "No hay objetivo en la posición (" + i + ", " + j + ")");
                        }
                    }
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "El objetivo no cumple con los requisitos de rango.");
        }
    }
    
    public static void jinete(Unit caster, int xObj, int yObj, Reino amigo, Reino enemigo) {
        int xCaster = caster.getFila();
        int yCaster = caster.getColumna();
        int distancia = Math.max(Math.abs(xObj - xCaster), Math.abs(yObj - yCaster));
        if (distancia == 1) {
            JOptionPane.showMessageDialog(null, "El caster está a una distancia de una casilla del objetivo.");
            Unit objetivo = findUnit(xObj, yObj, amigo);
            if (objetivo != null) {
                ((Unit_Dragon)caster).setTieneJinete();
                objetivo.setVisible(false);
                JOptionPane.showMessageDialog(null, "Se encontró un objetivo en las coordenadas (" + xObj + ", " + yObj + ").");
            } else {
                JOptionPane.showMessageDialog(null, "No hay objetivo en las coordenadas (" + xObj + ", " + yObj + ").");
            }
        } else {
            JOptionPane.showMessageDialog(null, "El caster no cumple con los requisitos de distancia.");
        }
    }

    public static void cargar(Unit caster, int xObj, int yObj, Reino amigo, Reino enemigo) {
        int maxDesplazamiento = 5;
        int xCaster = caster.getFila();
        int yCaster = caster.getColumna();
    
        int distancia = Math.max(Math.abs(xObj - xCaster), Math.abs(yObj - yCaster));
    
        if (distancia <= maxDesplazamiento) {
            if (findUnit(xCaster, yCaster, enemigo) == null && findUnit(xCaster, yCaster, enemigo) == null) {
                caster.setFila(xObj);
                caster.setColumna(yObj);
                JOptionPane.showMessageDialog(null, "Caballero se ha desplazado a las coordenadas (" + xObj + ", " + yObj + ").");
            } else {
                JOptionPane.showMessageDialog(null, "La ruta de desplazamiento no está vacía.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "El objetivo no está dentro del rango de desplazamiento.");
        }
    }

    public static void curacionMagica(Unit caster, int xObj, int yObj, Reino amigo, Reino enemigo) {
        int distanciaHechizo = 3;
        int xCaster = caster.getFila();
        int yCaster = caster.getColumna();
        int distancia = Math.max(Math.abs(xObj - xCaster), Math.abs(yObj - yCaster));
        if (distancia <= distanciaHechizo) {
            for (int i = xObj - distanciaHechizo; i <= xObj + distanciaHechizo; i++) {
                for (int j = yObj - distanciaHechizo; j <= yObj + distanciaHechizo; j++) {
                    if (Math.sqrt(Math.pow(i - xObj, 2) + Math.pow(j - yObj, 2)) <= distanciaHechizo) {
                            Unit unidadAmiga = findUnit(i, j, amigo);
                            if (unidadAmiga != null) {
                                unidadAmiga.setVida(Math.min(unidadAmiga.getVida() + 100, unidadAmiga.getVidaMaxima()));  // Evitar que la vida supere el máximo
                            }
                        }
                    }
                }
            JOptionPane.showMessageDialog(null, "Curación mágica realizada en el área de 3 casillas alrededor de las coordenadas (" + xObj + ", " + yObj + ").");
        } else {
            JOptionPane.showMessageDialog(null, "El objetivo no está dentro del rango de hechizo.");
        }
    }

    public static void controlMental(Unit caster, int xObj, int yObj, Reino amigo, Reino enemigo) {
        int rangoControlMental = 2;
        int xCaster = caster.getFila();
        int yCaster = caster.getColumna();
        int distancia = Math.max(Math.abs(xObj - xCaster), Math.abs(yObj - yCaster));
    
        if (distancia <= rangoControlMental) {
            Unit unidadEnemiga = findUnit(xObj, yObj, enemigo);
    
            if (unidadEnemiga != null) {
                enemigo.getUnidades().remove(unidadEnemiga);
                amigo.getUnidades().add(unidadEnemiga);
                JOptionPane.showMessageDialog(null, "Control mental realizado en la unidad enemiga en las coordenadas (" + xObj + ", " + yObj + ").");
            } else {
                JOptionPane.showMessageDialog(null, "No hay unidad enemiga en las coordenadas (" + xObj + ", " + yObj + ").");
            }
        } else {
            JOptionPane.showMessageDialog(null, "El objetivo no está dentro del rango de control mental.");
        }
    }//mago

    public static void debilitar(Unit caster, int xObj, int yObj, Reino amigo, Reino enemigo){
        int rangoDebilitar = 2;
        int xCaster = caster.getFila();
        int yCaster = caster.getColumna();
    
        int distancia = Math.max(Math.abs(xObj - xCaster), Math.abs(yObj - yCaster));

        if (distancia <= rangoDebilitar) {
            Unit unidadEnemiga = findUnit(xObj, yObj, enemigo);
    
            if (unidadEnemiga != null) {
                //de debuffea a unidadEnemiga
                JOptionPane.showMessageDialog(null, "Debilitar realizado en la unidad enemiga en las coordenadas (" + xObj + ", " + yObj + ").");
            } else {
                JOptionPane.showMessageDialog(null, "No hay unidad enemiga en las coordenadas (" + xObj + ", " + yObj + ").");
            }
        } else {
            JOptionPane.showMessageDialog(null, "El objetivo no está dentro del rango de debilitar .");
        }
    } //alquimista
    public static void fortalecer(Unit caster, int xObj, int yObj, Reino amigo, Reino enemigo){
        int rangoFortalecer = 2;
        int xCaster = caster.getFila();
        int yCaster = caster.getColumna();
    
        int distancia = Math.max(Math.abs(xObj - xCaster), Math.abs(yObj - yCaster));

        if (distancia <= rangoFortalecer) {
            Unit unidadEnemiga = findUnit(xObj, yObj, enemigo);
    
            if (unidadEnemiga != null) {
                //de debuffea a unidadEnemiga
                JOptionPane.showMessageDialog(null, "Fortalecer realizado en la unidad enemiga en las coordenadas (" + xObj + ", " + yObj + ").");
            } else {
                JOptionPane.showMessageDialog(null, "No hay unidad enemiga en las coordenadas (" + xObj + ", " + yObj + ").");
            }
        } else {
            JOptionPane.showMessageDialog(null, "El objetivo no está dentro del rango de fortalecer .");
        }
    } //alquimista
    public static void pocionSecreta(Unit caster, int xObj, int yObj, Reino amigo, Reino enemigo) {
        // Buscar la unidad en las coordenadas (xObj, yObj) en amigo y enemigo
        Unit unidadObjetivoAmigo = findUnit(xObj, yObj, amigo);
        Unit unidadObjetivoEnemigo = findUnit(xObj, yObj, enemigo);

        if (unidadObjetivoAmigo != null || unidadObjetivoEnemigo != null) {
            // Aplicar pocion secreta al objetivo (50% probabilidad de mejorar, 50% probabilidad de matar)
            Random random = new Random();
            int probabilidad = random.nextInt(2);
            if (unidadObjetivoAmigo != null && probabilidad == 0) {
                //mejorarUnidad(unidadObjetivoAmigo);
                JOptionPane.showMessageDialog(null, "Poción secreta aplicada a la unidad amiga en las coordenadas (" + xObj + ", " + yObj + "). La unidad ha sido mejorada.");
            } else if (unidadObjetivoEnemigo != null && probabilidad == 0) {
                //mejorarUnidad(unidadObjetivoEnemigo);
                JOptionPane.showMessageDialog(null, "Poción secreta aplicada a la unidad enemiga en las coordenadas (" + xObj + ", " + yObj + "). La unidad ha sido mejorada.");
            } else {
                //matarUnidad(unidadObjetivoAmigo, amigo);
                //matarUnidad(unidadObjetivoEnemigo, enemigo);
                JOptionPane.showMessageDialog(null, "Poción secreta aplicada a la unidad en las coordenadas (" + xObj + ", " + yObj + "). La unidad ha sido eliminada.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "No hay unidad en las coordenadas (" + xObj + ", " + yObj + ").");
        }
    } 
    






    public static void bombardear(Unit caster, int xObj, int yObj, Reino amigo, Reino enemigo){
        //Lo mismo que bolaMagma
        int rangoMinimo = 1;
        int rangoZonaImpacto = 1;
        int x = caster.getFila();
        int y = caster.getColumna();
    
        int distancia = Math.max(Math.abs(xObj - x), Math.abs(yObj - y));
    
        if (distancia >= rangoMinimo && distancia <= rangoZonaImpacto) {
            JOptionPane.showMessageDialog(null, "El objetivo está en el rango deseado y al menos a 1 casilla de distancia.");
    
            for (int i = xObj - rangoZonaImpacto; i <= xObj + rangoZonaImpacto; i++) {
                for (int j = yObj - rangoZonaImpacto; j <= yObj + rangoZonaImpacto; j++) {
                    if (Math.sqrt(Math.pow(i - xObj, 2) + Math.pow(j - yObj, 2)) <= rangoZonaImpacto) {
                        Unit obj = findUnit(i, j, enemigo);
                        if (obj != null) {
                            JOptionPane.showMessageDialog(null, "bombardear a distancia a " + obj.getNombre() + " en la posición (" + i + ", " + j + ")");
                        } else {
                            JOptionPane.showMessageDialog(null, "No hay objetivo en la posición (" + i + ", " + j + ")");
                        }
                    }
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "El objetivo no cumple con los requisitos de rango.");
        }
    } //caza




    public static void misilNuclear(Unit caster, int xObj, int yObj, Reino amigo, Reino enemigo){
        //validacion
        int rangoMinimo = 7;
        int rangoZonaImpacto = 1;
        int x = caster.getFila();
        int y = caster.getColumna();
    
        int distancia = Math.max(Math.abs(xObj - x), Math.abs(yObj - y));
    
        if (distancia >= rangoMinimo && distancia <= rangoZonaImpacto) {
            JOptionPane.showMessageDialog(null, "El objetivo está en el rango deseado y al menos a 1 casilla de distancia.");
    
            for (int i = xObj - rangoZonaImpacto; i <= xObj + rangoZonaImpacto; i++) {
                for (int j = yObj - rangoZonaImpacto; j <= yObj + rangoZonaImpacto; j++) {
                    if (Math.sqrt(Math.pow(i - xObj, 2) + Math.pow(j - yObj, 2)) <= rangoZonaImpacto) {
                        Unit obj = findUnit(i, j, enemigo);
                        if (obj != null) {
                            JOptionPane.showMessageDialog(null, "Misil nuclear a distancia a " + obj.getNombre() + " en la posición (" + i + ", " + j + ")");
                        } else {
                            JOptionPane.showMessageDialog(null, "No hay objetivo en la posición (" + i + ", " + j + ")");
                        }
                    }
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "El objetivo no cumple con los requisitos de rango.");
        }

    } //caza




    public static void almacenAviones(Unit caster, int xObj, int yObj, Reino amigo, Reino enemigo) {
        int rango = 1; 
        int xCaster = caster.getFila();
        int yCaster = caster.getColumna();
        int distancia = Math.max(Math.abs(xObj - xCaster), Math.abs(yObj - yCaster));
        if (distancia <= rango) { //verificar otras cosas
            Unit unidadAmiga = findUnit(xObj, xObj, amigo);
            if (unidadAmiga != null) {
                    JOptionPane.showMessageDialog(null, "El portaaviones almaceno a " + unidadAmiga.getNombre());     
            }
            JOptionPane.showMessageDialog(null, "Explosion area realizada en el área de 3 casillas alrededor de las coordenadas (" + xObj + ", " + yObj + ").");     
        } else {
            JOptionPane.showMessageDialog(null, "El objetivo no está dentro del rango de hechizo.");
        }

    }
    //portaaviones

    public static void almacenUnidades(Unit caster, int xObj, int yObj, Reino amigo, Reino enemigo){
        int rango = 1; 
        int xCaster = caster.getFila();
        int yCaster = caster.getColumna();
        int distancia = Math.max(Math.abs(xObj - xCaster), Math.abs(yObj - yCaster));
        if (distancia <= rango) { //verificar otras cosas
            Unit unidadAmiga = findUnit(xObj, xObj, amigo);
            if (unidadAmiga != null) {
                    JOptionPane.showMessageDialog(null, "El avion almaceno a " + unidadAmiga.getNombre());     
            }
            JOptionPane.showMessageDialog(null, "Explosion area realizada en el área de 3 casillas alrededor de las coordenadas (" + xObj + ", " + yObj + ").");     
        } else {
            JOptionPane.showMessageDialog(null, "El objetivo no está dentro del rango de hechizo.");
        }
    } //aviones
    public static void bombaDron(Unit caster, int xObj, int yObj, Reino amigo, Reino enemigo){
        int distanciaHechizo = 3;
        int xCaster = caster.getFila();
        int yCaster = caster.getColumna();
        int distancia = Math.max(Math.abs(xObj - xCaster), Math.abs(yObj - yCaster));
        if (distancia <= distanciaHechizo) {
            for (int i = xObj - distanciaHechizo; i <= xObj + distanciaHechizo; i++) {
                for (int j = yObj - distanciaHechizo; j <= yObj + distanciaHechizo; j++) {
                    if (Math.sqrt(Math.pow(i - xObj, 2) + Math.pow(j - yObj, 2)) <= distanciaHechizo) {
                            Unit unidadAmiga = findUnit(i, j, amigo);
                            if (unidadAmiga != null) {
                                unidadAmiga.setVida(Math.min(unidadAmiga.getVida() + 100, unidadAmiga.getVidaMaxima()));  // Evitar que la vida supere el máximo
                            }
                        }
                    }
                }
            JOptionPane.showMessageDialog(null, "Explosion area realizada en el área de 3 casillas alrededor de las coordenadas (" + xObj + ", " + yObj + ").");
        } else {
            JOptionPane.showMessageDialog(null, "El objetivo no está dentro del rango de hechizo.");
        }
    } //dron
    public static void curarArea(Unit caster, int xObj, int yObj, Reino amigo, Reino enemigo){
        int distanciaHechizo = 3;
        int xCaster = caster.getFila();
        int yCaster = caster.getColumna();
        int distancia = Math.max(Math.abs(xObj - xCaster), Math.abs(yObj - yCaster));
        if (distancia <= distanciaHechizo) {
            for (int i = xObj - distanciaHechizo; i <= xObj + distanciaHechizo; i++) {
                for (int j = yObj - distanciaHechizo; j <= yObj + distanciaHechizo; j++) {
                    if (Math.sqrt(Math.pow(i - xObj, 2) + Math.pow(j - yObj, 2)) <= distanciaHechizo) {
                            Unit unidadAmiga = findUnit(i, j, amigo);
                            if (unidadAmiga != null) {
                                unidadAmiga.setVida(Math.min(unidadAmiga.getVida() + 100, unidadAmiga.getVidaMaxima()));  // Evitar que la vida supere el máximo
                            }
                        }
                    }
                }
            JOptionPane.showMessageDialog(null, "Curación area realizada en el área de 3 casillas alrededor de las coordenadas (" + xObj + ", " + yObj + ").");
        } else {
            JOptionPane.showMessageDialog(null, "El objetivo no está dentro del rango de hechizo.");
        }
    } //medico
    public static void gasVeneno(Unit caster, int xObj, int yObj, Reino amigo, Reino enemigo){
        int distanciaHechizo = 3;
        int xCaster = caster.getFila();
        int yCaster = caster.getColumna();
        int distancia = Math.max(Math.abs(xObj - xCaster), Math.abs(yObj - yCaster));
        if (distancia <= distanciaHechizo) {
            for (int i = xObj - distanciaHechizo; i <= xObj + distanciaHechizo; i++) {
                for (int j = yObj - distanciaHechizo; j <= yObj + distanciaHechizo; j++) {
                    if (Math.sqrt(Math.pow(i - xObj, 2) + Math.pow(j - yObj, 2)) <= distanciaHechizo) {
                            Unit unidadAmiga = findUnit(i, j, amigo);
                            if (unidadAmiga != null) {
                                //unidadAmiga.setVida(Math.min(unidadAmiga.getVida() + 100, unidadAmiga.getVidaMaxima()));  // Evitar que la vida supere el máximo
                            }
                        }
                    }
                }
            JOptionPane.showMessageDialog(null, "Gas mortal area realizada en el área de 3 casillas alrededor de las coordenadas (" + xObj + ", " + yObj + ").");
        } else {
            JOptionPane.showMessageDialog(null, "El objetivo no está dentro del rango de hechizo.");
        }
    } //medico

    public static void hiperVelocidad(Unit caster, int xObj, int yObj, Reino amigo, Reino enemigo){
        int maxDesplazamiento = 5;
        int xCaster = caster.getFila();
        int yCaster = caster.getColumna();
    
        int distancia = Math.max(Math.abs(xObj - xCaster), Math.abs(yObj - yCaster));
    
        if (distancia <= maxDesplazamiento) {
            if (findUnit(xCaster, yCaster, enemigo) == null && findUnit(xCaster, yCaster, enemigo) == null) {
                caster.setFila(xObj);
                caster.setColumna(yObj);
                JOptionPane.showMessageDialog(null, "Soldier se ha desplazado a las coordenadas (" + xObj + ", " + yObj + ").");
            } else {
                JOptionPane.showMessageDialog(null, "La ruta de desplazamiento no está vacía.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "El objetivo no está dentro del rango de desplazamiento.");
        }
    } //soldier

    public static void rafaga(Unit caster, int xObj, int yObj, Reino amigo, Reino enemigo){
        int maxDesplazamiento = 5;
        int xCaster = caster.getFila();
        int yCaster = caster.getColumna();
    
        int distancia = Math.max(Math.abs(xObj - xCaster), Math.abs(yObj - yCaster));
    
        if (distancia <= maxDesplazamiento) {
            if (findUnit(xCaster, yCaster, enemigo) == null && findUnit(xCaster, yCaster, enemigo) == null) {
                caster.setFila(xObj);
                caster.setColumna(yObj);
                JOptionPane.showMessageDialog(null, "Airsoldier se ha desplazado a las coordenadas (" + xObj + ", " + yObj + ").");
            } else {
                JOptionPane.showMessageDialog(null, "La ruta de desplazamiento no está vacía.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "El objetivo no está dentro del rango de desplazamiento.");
        }
    } //airsoldier

    public static void ataquePEM(Unit caster, int xObj, int yObj, Reino amigo, Reino enemigo){
        int rango = 3;
        int x = caster.getFila();
        int y = caster.getColumna();
        int distancia = Math.max(Math.abs(xObj - x), Math.abs(yObj - y));
        if (distancia <= rango) {
            JOptionPane.showMessageDialog(null, "El objetivo está dentro del rango para el ataque PEM.");
            Unit obj = findUnit(xObj, yObj, enemigo);
            if(obj != null){
                JOptionPane.showMessageDialog(null, "Ataque PEM a " + obj.getNombre());
            }else{
                JOptionPane.showMessageDialog(null, "No hay objetivo");    
            }
        } else {
            JOptionPane.showMessageDialog(null, "El objetivo está fuera del rango para el ataque desenfrenado.");
        }
    } //seaSoldier

    public static void cañonYamato(Unit caster, int xObj, int yObj, Reino amigo, Reino enemigo){
        int rango = 5;
        int x = caster.getFila();
        int y = caster.getColumna();
        int distancia = Math.max(Math.abs(xObj - x), Math.abs(yObj - y));
        if (distancia <= rango) {
            JOptionPane.showMessageDialog(null, "El objetivo está dentro del rango para recibir el poderoso cañon yamato.");
            Unit obj = findUnit(xObj, yObj, enemigo);
            if(obj != null){
                JOptionPane.showMessageDialog(null, "yamato a " + obj.getNombre());
            }else{
                JOptionPane.showMessageDialog(null, "No hay objetivo");    
            }
        } else {
            JOptionPane.showMessageDialog(null, "El objetivo está fuera del rango para aniquilar.");
        }
    } //cruceroBatalla
    public static void torpedo(Unit caster, int xObj, int yObj, Reino amigo, Reino enemigo){
        int rango = 5;
        int x = caster.getFila();
        int y = caster.getColumna();
        int distancia = Math.max(Math.abs(xObj - x), Math.abs(yObj - y));
        if (distancia <= rango) {
            JOptionPane.showMessageDialog(null, "El objetivo está dentro del rango para recibir el poderoso torpedo");
            Unit obj = findUnit(xObj, yObj, enemigo);
            if(obj != null){
                JOptionPane.showMessageDialog(null, "torpedo a " + obj.getNombre());
            }else{
                JOptionPane.showMessageDialog(null, "No hay objetivo");    
            }
        } else {
            JOptionPane.showMessageDialog(null, "El objetivo está fuera del rango para aniquilar.");
        }
    } //submarino

    public static void abducir(Unit caster, int xObj, int yObj, Reino amigo, Reino enemigo){

    } //ufo
    public static void teletransportar(Unit caster, int xObj, int yObj, Reino amigo, Reino enemigo, Field campo) {
        // Verificar que la unidad a teleportar sea amiga y esté a una distancia de 4 unidades
        Unit unidadObjetivo = findUnit(xObj, yObj, amigo);

        if (unidadObjetivo != null && calcularDistanciaManhattan(caster, unidadObjetivo) == 4) {
            // Obtener nuevas coordenadas del campo
            int[] nuevasCoordenadas = campo.getCoordenadas();

            // Verificar la distancia máxima permitida
            if (calcularDistanciaManhattan(caster, nuevasCoordenadas[0], nuevasCoordenadas[1]) <= 10) {
                // Modificar las coordenadas de la unidad objetivo
                unidadObjetivo.setFila(nuevasCoordenadas[0]);
                unidadObjetivo.setColumna(nuevasCoordenadas[1]);

                JOptionPane.showMessageDialog(null, "Teletransporte exitoso a la posición (" + nuevasCoordenadas[0] + ", " + nuevasCoordenadas[1] + ").");
            } else {
                JOptionPane.showMessageDialog(null, "La distancia máxima permitida es de 10 casillas.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "No se encontró una unidad amiga válida para teletransportar.");
        }
    }

    // Método para calcular la distancia Manhattan entre dos unidades
    private static int calcularDistanciaManhattan(Unit unit1, Unit unit2) {
        return Math.abs(unit1.getFila() - unit2.getFila()) + Math.abs(unit1.getColumna() - unit2.getColumna());
    }

    // Método para calcular la distancia Manhattan entre una unidad y unas coordenadas
    private static int calcularDistanciaManhattan(Unit unit, int x, int y) {
        return Math.abs(unit.getFila() - x) + Math.abs(unit.getColumna() - y);
    }

    public static void cañonRayosGamma(Unit caster, int xObj, int yObj, Reino amigo, Reino enemigo) {
        int rango = 5;

        // Verificar la posición del objetivo en relación con el caster
        if (xObj == caster.getFila()) {
            // El objetivo está en la misma fila que el caster
            if (yObj > caster.getColumna()) {
                // Atacar a la derecha
                for (int i = 1; i <= rango; i++) {
                    int newY = caster.getColumna() + i;
                    if (newY < 50) {
                        // Realizar el ataque en la dirección especificada
                        // Implementa la lógica del ataque según tus necesidades
                        // Puedes acceder al terreno y a las unidades usando amigo y enemigo
                        JOptionPane.showMessageDialog(null, "Ataque en la dirección derecha a la coordenada (" + xObj + ", " + newY + ").");
                    } else {
                        break; // Salir del bucle si llegamos al final del rango
                    }
                }
            } else {
                // Atacar a la izquierda
                for (int i = 1; i <= rango; i++) {
                    int newY = caster.getColumna() - i;
                    if (newY >= 0) {
                        // Realizar el ataque en la dirección especificada
                        // Implementa la lógica del ataque según tus necesidades
                        // Puedes acceder al terreno y a las unidades usando amigo y enemigo
                        JOptionPane.showMessageDialog(null, "Ataque en la dirección izquierda a la coordenada (" + xObj + ", " + newY + ").");
                    } else {
                        break; // Salir del bucle si llegamos al final del rango
                    }
                }
            }
        } else if (yObj == caster.getColumna()) {
            // El objetivo está en la misma columna que el caster
            if (xObj > caster.getFila()) {
                // Atacar hacia abajo
                for (int i = 1; i <= rango; i++) {
                    int newX = caster.getFila() + i;
                    if (newX < 50) {
                        // Realizar el ataque en la dirección especificada
                        // Implementa la lógica del ataque según tus necesidades
                        // Puedes acceder al terreno y a las unidades usando amigo y enemigo
                        JOptionPane.showMessageDialog(null, "Ataque en la dirección abajo a la coordenada (" + newX + ", " + yObj + ").");
                    } else {
                        break; // Salir del bucle si llegamos al final del rango
                    }
                }
            } else {
                // Atacar hacia arriba
                for (int i = 1; i <= rango; i++) {
                    int newX = caster.getFila() - i;
                    if (newX >= 0) {
                        // Realizar el ataque en la dirección especificada
                        // Implementa la lógica del ataque según tus necesidades
                        // Puedes acceder al terreno y a las unidades usando amigo y enemigo
                        JOptionPane.showMessageDialog(null, "Ataque en la dirección arriba a la coordenada (" + newX + ", " + yObj + ").");
                    } else {
                        break; // Salir del bucle si llegamos al final del rango
                    }
                }
            }
        } else {
            // El objetivo no está en la misma fila ni columna que el caster, no se permite el ataque diagonal
            JOptionPane.showMessageDialog(null, "El objetivo debe estar en la misma fila o columna que el caster.");
        }
    }//ufo

    public static void aniquilar(Unit caster, int xObj, int yObj, Reino amigo, Reino enemigo){
        int rango = 15;
        int x = caster.getFila();
        int y = caster.getColumna();
        int distancia = Math.max(Math.abs(xObj - x), Math.abs(yObj - y));
        if (distancia <= rango) {
            JOptionPane.showMessageDialog(null, "El objetivo está dentro del rango para recibir el poderoso aniquilar.");
            Unit obj = findUnit(xObj, yObj, enemigo);
            if(obj != null){
                JOptionPane.showMessageDialog(null, "Atacando a " + obj.getNombre());
            }else{
                JOptionPane.showMessageDialog(null, "No hay objetivo");    
            }
        } else {
            JOptionPane.showMessageDialog(null, "El objetivo está fuera del rango para aniquilar.");
        }

    };//titan

    public static Unit findUnit(int x, int y, Reino buscar){
        for(Unit u: buscar.getUnidades()){
            if(u.getFila() == x && u.getColumna() == y){
                return u;
            }
        }
        return null;
    }
}
