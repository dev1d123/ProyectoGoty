import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.concurrent.CountDownLatch;

import javax.swing.*;

public class Field extends JFrame{
    private static int turno;
    private static final int ALTO = 800; //ancho de la ventana
    private static final int ANCHO = 1000; //largo de la ventana
    private static final int MED = 50; //cantidad de filas y columnas del juego
    private boolean esMenu = false;

    private GridLayout lay = new  GridLayout(MED, MED);
    private JButton[][] arr = new JButton[MED][MED]; 

    private int[][] terreno = new int[MED][MED];
    private boolean[][] posicionUnidades;
    //1->AGUA
    //2->MONTAÑA1 3->MONTAÑA2

    //3->TERRENO1, 4->TERRENO2, 5->TERRENO3

    //Revisar
    private Reino r1;
    private Reino r2;
    //Revisar


    public Field(Reino r1, Reino r2){
        this.r1 = r1;
        this.r2 = r2;

        for(int i = 0; i <= 43; i++){
            for(int j = 0; j <= 3; j++){
                terreno[i][j] = 1;
            }
        }
        for(int i = 0; i <= 3; i++){
            for(int j = 0; j <= 43; j++){
                terreno[i][j] = 1;
            }
        }
        for(int i = 6; i <= 46; i++){
            for(int j = 46; j <= 49; j++){
                terreno[i][j] = 1;
            }
        }
        for(int i = 46; i <= 49; i++){
            for(int j = 6; j <= 49; j++){
                terreno[i][j] = 1;    
            }
        }
        for(int i = 6, j = 43; i <= 43 || j >=6; i++, j--){
                Random random = new Random();
                int var = random.nextInt(2);    
                if(var == 0 && terreno[i][j] != 1){
                    terreno[i][j] = 2;
                }else{
                    terreno[i][j] = 3;
                }
        }

        for(int i = 0; i < MED; i++){
            for(int j = 0; j < MED; j++){
                if(terreno[i][j] == 0 || terreno[i][j] == 10){
                    Random random = new Random();
                    int var = random.nextInt(3);    
                    if(var == 0){
                        terreno[i][j] = 4;
                    }else if (var == 1){
                        terreno[i][j] = 5;
                    }else{
                        terreno[i][j] = 6;
                    }
                }
            }
        }
        


        setTitle("Goty2024"); 
        setSize(ANCHO, ALTO);

        setLayout(new BorderLayout());
        createContents(turno);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }



    public void createContents(int turno) {
        esMenu = false;
        JPanel infoPanel = new JPanel(new BorderLayout());
        Font font = new Font("Arial", Font.PLAIN, 16);
        // Etiquetas para mostrar la información
        JLabel nameLabel = new JLabel();
        JLabel oroLabel = new JLabel();
        JLabel recursosLabel = new JLabel();
        JLabel manutencionLabel = new JLabel();
        
        // Configurar la información según el turno

        if (turno == 1) {
            nameLabel.setText("REINO 1: " + r1.getTipo());
            oroLabel.setText("Oro: " + r1.getDinero()+"                                                                   ");
            recursosLabel.setText("Recursos: " + r1.getRecursos()+"               "); 
            manutencionLabel.setText("Manutención: " + r1.getManutenActual() + " / " + r1.getManutenMaxima());
        } else if (turno == 2) {
            nameLabel.setText("REINO 2: " + r2.getTipo());
            oroLabel.setText("Oro: " + r2.getDinero()+"                                                                   ");
            recursosLabel.setText("Recursos: " + r2.getRecursos()+"               ");
            manutencionLabel.setText("Manutención: " + r2.getManutenActual() + " / " + r2.getManutenMaxima());
        }
        
        // Configurar colores de texto
        oroLabel.setForeground(Color.RED);
        recursosLabel.setForeground(Color.GRAY);
        manutencionLabel.setForeground(Color.ORANGE);
        nameLabel.setFont(font);
        oroLabel.setFont(font);
        recursosLabel.setFont(font);
        manutencionLabel.setFont(font);
        // Añadir etiquetas al panel
        infoPanel.add(nameLabel, BorderLayout.NORTH);
        infoPanel.add(oroLabel, BorderLayout.WEST);
        infoPanel.add(recursosLabel, BorderLayout.CENTER);
        infoPanel.add(manutencionLabel, BorderLayout.EAST);
        
        // Añadir el panel al contenedor principal (supongo que estás usando un contenedor principal)
        add(infoPanel, BorderLayout.NORTH);
        //add(titulo, BorderLayout.NORTH);
        //Primero imprimimos las dos fortalezas
        JPanel panelGen = new Fondo(lay, r1.getEpoca(), r2.getEpoca());

        for (int i = 0; i < MED; i++) {
            for (int j = 0; j < MED; j++) {
                arr[i][j] = new JButton("");
                panelGen.add(arr[i][j]);  
            }
        }
        //CREAMOS LAS ZONAS DE AGUA
        //Darle los iconos a los botones de agua
        for(int i = 0; i <= 43; i++){
            for(int j = 0; j <= 3; j++){
                arr[i][j].setIcon(new ImageIcon(getClass().getResource("images/map-water.jpeg")));
            }
        }
        for(int i = 0; i <= 3; i++){
            for(int j = 0; j <= 43; j++){
                arr[i][j].setIcon(new ImageIcon(getClass().getResource("images/map-water.jpeg")));
            }
        }
        for(int i = 6; i <= 46; i++){
            for(int j = 46; j <= 49; j++){
                arr[i][j].setIcon(new ImageIcon(getClass().getResource("images/map-water.jpeg")));
            }
        }
        for(int i = 46; i <= 49; i++){
            for(int j = 6; j <= 49; j++){
                arr[i][j].setIcon(new ImageIcon(getClass().getResource("images/map-water.jpeg")));
            }
        }
        //CREAMOS LAS ZONAS DE MONTAÑA
        //Darle los iconos a los botones de montaña
        for(int i = 6, j = 43; i <= 43 || j >=6; i++, j--){
                if(terreno[i][j] == 2){
                    arr[i][j].setIcon(new ImageIcon(getClass().getResource("images/map-mountain1.jpg")));
                    
                }else if (terreno[i][j] == 3){
                    arr[i][j].setIcon(new ImageIcon(getClass().getResource("images/map-mountain2.jpg")));
                }
        }
        //Establecer las bases

        for(int i = 0; i < MED; i++){
            for(int j = 0; j < MED; j++){
                    if(terreno[i][j] == 4){
                        arr[i][j].setIcon(new ImageIcon(getClass().getResource("images/map-land1.jpg")));
                    }else if (terreno[i][j] == 5){
                        arr[i][j].setIcon(new ImageIcon(getClass().getResource("images/map-land2.png")));
                    }else if (terreno[i][j] == 6){
                        arr[i][j].setIcon(new ImageIcon(getClass().getResource("images/map-land3.jpg")));
                    }
            }
        }
        //REINO1
        for(int i = MED - 6; i < MED; i++){
            for (int j = 0; j < 6; j++) {
                arr[i][j].setIcon(null);
                arr[i][j].setOpaque(false);
                arr[i][j].setContentAreaFilled(false);
                arr[i][j].setBorderPainted(false);                
            }
        }   
        //REINO2
        for(int i = 0; i < 6; i++){
            for (int j = MED - 6; j < MED; j++) {
                arr[i][j].setIcon(null);
                arr[i][j].setOpaque(false);
                arr[i][j].setContentAreaFilled(false);
                arr[i][j].setBorderPainted(false);                
                                 
            }
        }

        //Imprimimos a los ejercitos restantes
        
        posicionUnidades = new boolean[MED][MED];

        for (int i = 0; i < MED; i++) {
            for (int j = 0; j < MED; j++) {
                for (Unit u: r1.getUnidades()) {
                    if (u.getFila() == i && u.getColumna() == j && !(u instanceof Unit_Esclavo || u instanceof Unit_Obrero || u instanceof Unit_Robot)) {
                        System.out.println("El reino 1 tiene una unidad en las coordenadas " + i + " " + j);
                        posicionUnidades[i][j] = true;
                        arr[i][j].setIcon(null);
                        arr[i][j].setBackground(Color.RED);
                        arr[i][j].setOpaque(true);                       
                        break;
                    }
                }
                for (Unit u: r2.getUnidades()) {
                    if (u.getFila() == i && u.getColumna() == j && !(u instanceof Unit_Esclavo || u instanceof Unit_Obrero || u instanceof Unit_Robot)) {
                        System.out.println("El reino 2 tiene una unidad en las coordenadas " + i + " " + j);
                        posicionUnidades[i][j] = true;
                        arr[i][j].setIcon(null);
                        arr[i][j].setBackground(Color.BLUE);
                        arr[i][j].setOpaque(true);                       
                        break;
                    }
                }
                arr[i][j].addActionListener(new ButtonListener(i, j));
            }
        }

        add(panelGen, BorderLayout.CENTER);

        System.out.println("Create contens terminado");
    }

    private int filaSeleccion = -1;
    private int columnaSeleccion = -1;

    private CountDownLatch latch = new CountDownLatch(1);

    private class ButtonListener implements ActionListener {
        private int f;
        private int c;
        public ButtonListener(int f, int c) {
            this.f = f;
            this.c = c;
        }
        public void actionPerformed(ActionEvent e) {
            //Abrir el menu del determinado soldado
            filaSeleccion = f;
            columnaSeleccion = c;
            latch.countDown(); 
        }
    }

    public int[] getCoordenadas() {
        System.out.println("Seleccione coordenadas");
        try {
            System.out.println("wait");
            latch.await(); 
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int[] arr = new int[2];
        arr[0] = filaSeleccion + 1;
        arr[1] = columnaSeleccion + 1;
        filaSeleccion = -1;
        columnaSeleccion = -1;
        latch = new CountDownLatch(1);
        System.out.println(arr[0] + " " + arr[1]);
        return arr;
    }

    public int[] getCoordenadasObjetivo(int x, int y, Unit unidadSeleccionada, int turno) {
        System.out.println("Seleccione coordenadas");
        boolean[][] movValidos = resaltarBotonesColindantes(x, y, unidadSeleccionada, turno); //Retorna la matriz de movimientos validos!!!

        try {
            System.out.println("wait");
            latch.await(); 
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int[] arr = new int[2];
        arr[0] = filaSeleccion + 1;
        arr[1] = columnaSeleccion + 1;

        latch = new CountDownLatch(1);

        if(turno%2== 0){
            //Verifica en r2
            for(Unit u: r1.getUnidades()){
                if(u.getFila() == arr[0]-1 && u.getColumna() == arr[1] - 1){
                    movValidos[arr[0]-1][arr[1]-1] = true;
                } 
            }
        }else{
            //Verifica en r1
            for(Unit u: r2.getUnidades()){
                if(u.getFila() == arr[0]-1 && u.getColumna() == arr[1] - 1){
                    movValidos[arr[0]-1][arr[1]-1] = true;
                } 
            }
        }
        
        if(movValidos[arr[0]-1][arr[1]-1]){
            //Si hay un enemigo en la posicion arr[0]-1 y arr[1] - 1

            JOptionPane.showMessageDialog(null, "Valores de movimeinto correctos");   
        }else{
            JOptionPane.showMessageDialog(null, "incorrecto!!!!");   
            arr[0] = x + 1;
            arr[1] = y + 1;
        }
        filaSeleccion = -1;
        columnaSeleccion = -1;
        return arr;
        

    }

    public void repintar(int turno){
        getContentPane().removeAll(); 
        createContents(turno); 
        revalidate(); 
        repaint();    
    }
    public Reino getReino1(){
        return r1;
    }
    public Reino getReino2(){
        return r2;
    }
 
    //Hacer la verificacion
    //Verdadero si la casilla es correcta

    private boolean[][] resaltarBotonesColindantes(int x, int y, Unit unidadSeleccionada, int turno) {
        boolean[][] movValidos = new boolean[50][50];
        
        int rango = unidadSeleccionada.getVelocidad();
        for (int i = x - rango; i <= x + rango; i++) {
            for (int j = y - rango; j <= y+rango; j++) {
                if(i == x && j == y){
                    continue;
                }
                //comprobar que i y j esten en el rango 
                //Comprobar si es enemigo o amigo!!!
                 //se ha seleccionado a una unidad enemiga -> 

                if(0<=i&&i<=49&&0<=j&&j<=49 && posicionUnidades[i][j]) continue;

                if(unidadSeleccionada.getTerreno() == 1){
                    if(estaEnParteSuperior(x, y)){
                        if(estaEnParteInferior(i,j)) continue;
                    }else{
                        if(estaEnParteSuperior(i,j)) continue;
                    }
                    if((0<=i && i<=49)&&(0<=j && j<=49) && (terreno[i][j] == 4 || terreno[i][j] == 5 || terreno[i][j] == 6)){
                        arr[i][j].setIcon(null);
                        arr[i][j].setBackground(Color.YELLOW);
                        movValidos[i][j] = true;
                    }
                }
                if(unidadSeleccionada.getTerreno() == 2){
                    if(0<=i&&i<=49&&0<=j&&j<=49 && terreno[i][j] == 1){
                        arr[i][j].setIcon(null);
                        arr[i][j].setBackground(Color.YELLOW);
                        movValidos[i][j] = true;
                    }
                }
                if(0<=i&&i<=49&&0<=j&&j<=49 && (unidadSeleccionada.getTerreno() == 3 || unidadSeleccionada.getTerreno() == 4)){
                    arr[i][j].setIcon(null);
                    arr[i][j].setBackground(Color.YELLOW);
                    movValidos[i][j] = true;
                    
                }

                
                // Resalta el botón (i, j) según tus criterios
                // Puedes cambiar el fondo, el color, o cualquier otro atributo visual.

            }
        }
        return movValidos;
    }
    public static boolean estaEnParteSuperior(int fila, int columna) {
        return fila < 49 - columna;
    }
    public static boolean estaEnParteInferior(int fila, int columna) {
        return fila >= 49 - columna;
    }
}

