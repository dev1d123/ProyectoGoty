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
    private static Field campo;

    public static void habilidad(int cod, Unit cast, int x, int y, Reino a, Reino e, Field c){
        caster = cast;
        xObj = x;
        yObj = y;
        amigo = a;
        enemigo = e;
        campo = c;
        if(cod == 100){
            ataqueDesenfrenado();
        }else if(cod == 101){
            asediar();
        }else if(cod == 102){
            bolaArdiente(); //dragon
        }else if(cod == 104){
            cargar(); //caballero
        }else if(cod == 105){
            curacionMagica(); //mago
        }else if (cod == 106){
            controlMental(); //mago
        }else if (cod == 107){
            debilitar(); //alquimista
        }else if(cod == 108){
            fortalecer(); //alquimista
        }else if(cod == 109){
            pocionSecreta(); //alquimista
        }else if(cod == 110){
            bombardear(); //caza
        }else if(cod == 111){
            misilNuclear(); //caza
        }else if(cod == 114){
            bombaDron(); //dron
        }else if(cod == 115){
            curarArea(); //medico
        }else if(cod == 116){
            gasVeneno(); //medico
        }else if(cod == 117){
            hiperVelocidad(); //soldier
        }else if(cod == 118){
            rafaga(); //airsoldier
        }else if(cod == 119){
            ataquePEM(); //seaSoldier
        }else if(cod == 120){
            cañonYamato(); //cruceroBatalla
        }else if(cod == 121){
            torpedo(); //submarino
        }else if(cod == 124){
            cañonRayosGamma(); //ufo
        }else if(cod == 125){
            aniquilar();
        }

    }
    public static void ataqueDesenfrenado(){
        int rango = 1;
        int x = caster.getFila();
        int y = caster.getColumna();

        int distancia = Math.max(Math.abs(xObj - x), Math.abs(yObj - y));

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
    public static void asediar(){
        int rango = 5;
        int x = caster.getFila();
        int y = caster.getColumna();

        int distancia = Math.max(Math.abs(xObj - x), Math.abs(yObj - y));

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
    public static void bolaArdiente() {
        int rangoZonaImpacto = 1;
        int x = caster.getFila();
        int y = caster.getColumna();
    
        int distancia = Math.max(Math.abs(xObj - x), Math.abs(yObj - y));
        if (distancia > 1) {
            JOptionPane.showMessageDialog(null, "El objetivo está en el rango deseado y al menos a 1 casilla de distancia.");
    
            for (int i = xObj - rangoZonaImpacto; i <= xObj + rangoZonaImpacto; i++) {
                for (int j = yObj - rangoZonaImpacto; j <= yObj + rangoZonaImpacto; j++) {
                    if (Math.max(Math.abs(xObj - x), Math.abs(yObj - y)) <= rangoZonaImpacto) {
                        Unit obj = findUnit(i, j, enemigo);
                        if (obj != null) {
                            JOptionPane.showMessageDialog(null, "Asedio a distancia a " + obj.getNombre() + " en la posición (" + i + ", " + j + ")");
                        }
                    }
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "El objetivo no cumple con los requisitos de rango.");
        }
    }
    public static void cargar() {
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

    public static void curacionMagica() {
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

    public static void controlMental() {
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

    public static void debilitar(){
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
    public static void fortalecer(){
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
    public static void pocionSecreta() {
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
    
    public static void bombardear(){
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




    public static void misilNuclear(){
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


    public static void bombaDron(){
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
    public static void curarArea(){
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
    public static void gasVeneno(){
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

    public static void hiperVelocidad(){
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

    public static void rafaga(){
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

    public static void ataquePEM(){
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

    public static void cañonYamato(){
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
    public static void torpedo(){
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


    public static void cañonRayosGamma() {
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

    public static void aniquilar(){
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
    //Dado un rango calcula si la unidad esta dentro del rango
    public static boolean verificarDistanciaManhattan(int rango){
        int x = caster.getFila();
        int y = caster.getColumna();

        int distancia = Math.max(Math.abs(xObj - x), Math.abs(yObj - y));
        if (distancia <= rango) {
            return true;
        } else {
            return false;
        }

    }
}
