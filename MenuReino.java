import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.security.PublicKey;
import java.util.concurrent.CountDownLatch;

import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.util.Date;
public class MenuReino extends JFrame {
    private Reino reinoMenu;
    private Reino reinoOtro;

    private CountDownLatch latch = new CountDownLatch(1);

    public MenuReino(Reino r1, Reino r2) {
        reinoMenu = r1;
        reinoOtro = r2;
        int ancho = 600;
        int alto = 400;
        setSize(ancho, alto);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        createContents();
        
    }

    public void createContents() {
        JPanel infoPanel = new JPanel();
        infoPanel.setLayout(new GridLayout(1, 3));
        
        ImageIcon dineroIcon = new ImageIcon(getClass().getResource("images_icon/icon-dinero.jpg"));
        dineroIcon = resizeImage(dineroIcon, 25, 25);
        JLabel dinero = new JLabel("Dinero: " + reinoMenu.getDinero(), dineroIcon, JLabel.LEFT);
        infoPanel.add(dinero);
    
        ImageIcon recursosIcon = new ImageIcon(getClass().getResource("images_icon/icon-recursos.jpg"));
        recursosIcon = resizeImage(recursosIcon, 25, 25);
        JLabel recursos = new JLabel("Recursos: " + reinoMenu.getRecursos(), recursosIcon, JLabel.LEFT);
        infoPanel.add(recursos);
    
        ImageIcon manutencionIcon = new ImageIcon(getClass().getResource("images_icon/icon-manuten.jpg"));
        manutencionIcon = resizeImage(manutencionIcon, 25, 25);
        JLabel manutencion = new JLabel("Manutención: " + reinoMenu.getManutenActual() + " / " + reinoMenu.getManutenMaxima(), manutencionIcon, JLabel.LEFT);
        infoPanel.add(manutencion);
        add(infoPanel, BorderLayout.NORTH);
    
        JPanel infoUnitBuild = new JPanel();
        infoUnitBuild.setLayout(new BorderLayout());
        // Panel para mostrar información de unidades
        JPanel infoUnit = new JPanel(new FlowLayout());
        infoUnit.add(new JLabel("UNIDADES CREADAS"));
        for (Unit unidad : reinoMenu.getUnidades()) {
            ImageIcon unidadIcon = resizeImage(unidad.getIcon(), 50, 50);
            JLabel unidadLabel = new JLabel(unidad.getNombre(), unidadIcon, JLabel.CENTER);
            unidadLabel.setVerticalTextPosition(JLabel.BOTTOM);
            unidadLabel.setHorizontalTextPosition(JLabel.CENTER);
            infoUnit.add(unidadLabel);
        }
        infoUnitBuild.add(infoUnit, BorderLayout.NORTH);
    
        // Panel para mostrar información de edificios
        JPanel infoBuild = new JPanel(new FlowLayout());
        infoBuild.add(new JLabel("EDIFICIOS"));
        for (Buildings edificio : reinoMenu.getEdificios()) {
            ImageIcon edificioIcon = resizeImage(edificio.getIcon(), 50, 50);
            JButton edificioButton = new JButton(edificio.getNombre(), edificioIcon);
            edificioButton.setVerticalTextPosition(JButton.BOTTOM);
            edificioButton.setHorizontalTextPosition(JButton.CENTER);
            edificioButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    edificio.hacerAccion(reinoMenu);
                    repintar();
                }
            });
    
            infoBuild.add(edificioButton);
        }
        infoUnitBuild.add(infoBuild, BorderLayout.SOUTH);
        
        add(infoUnitBuild, BorderLayout.CENTER);
        
        // Botones-> crear Edificio, crear trabajador, eliminar trabajador, guardar, salir
        JPanel botones = new JPanel();
        botones.setLayout(new GridLayout(1, 5));
        JButton crearEdificio = new JButton("Crear Edificio");
        crearEdificio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] opciones = reinoMenu.getData();
                int indiceSeleccionado = JOptionPane.showOptionDialog(
                        null,
                        "Selecciona una opción:",
                        "Opciones",
                        JOptionPane.DEFAULT_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        opciones,
                        opciones[0]);
                Buildings edificio = PreparacionScript.obtenerEdificio(reinoMenu, indiceSeleccionado);
                if(reinoMenu.getDinero() >= edificio.getCosto()){
                    reinoMenu.getEdificios().add(edificio);
                    if(edificio instanceof Granjas || edificio instanceof Asimilador){
                        reinoMenu.actualizarCtdManuten();
                    }
                    reinoMenu.gastarDinero(edificio.getCosto());
                    repintar();
                }else{
                    JOptionPane.showMessageDialog(null, "DINERO INSUFICIENTE");
                }
            }    
        });
        botones.add(crearEdificio);
        JButton crearTrabajador = new JButton("Crear unidad productora");
        crearTrabajador.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                if(reinoMenu.getEpoca() == 'I'){
                    Unit.crearUnidad(new Unit_Esclavo(), reinoMenu);
                }else if(reinoMenu.getEpoca() == 'R'){
                    Unit.crearUnidad(new Unit_Obrero(), reinoMenu);
                }else{
                    Unit.crearUnidad(new Unit_Robot(), reinoMenu);
                }
                reinoMenu.setTrabajadores(reinoMenu.getTrabajadores() + 1);
                repintar();
            }
        });
        botones.add(crearTrabajador);
        JButton eliminarTrabajador = new JButton("Eliminar unidad productora");
        eliminarTrabajador.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                boolean valid = true;
                Unit remover = null;
                for(Unit u: reinoMenu.getUnidades()){
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
                    reinoMenu.getUnidades().remove(remover);
                    reinoMenu.setTrabajadores(reinoMenu.getTrabajadores() - 1);
                }      
                repintar();
            }
        });
        botones.add(eliminarTrabajador);
        
        //Boton para guardar -> Genera un archivo
        JButton guardar = new JButton("Guardar y salir");
        guardar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                //almacenar 
                try{
                    String nombreGuardado ="ProyectoGoty/save/";
                    Object[] opciones = {"Slot 1", "Slot 2", "Slot 3"};
                    int opcionSeleccionada = JOptionPane.showOptionDialog(
                            null,
                            "Seleccione un slot de guardado",
                            "Archivos de guardado",
                            JOptionPane.YES_NO_CANCEL_OPTION,
                            JOptionPane.QUESTION_MESSAGE,
                            null,
                            opciones,
                            opciones[0]
                    );
            
                    // La variable 'opcionSeleccionada' contendrá el índice de la opción seleccionada.
                    // Puedes utilizar un switch o if-else para manejar las opciones.
                    switch (opcionSeleccionada) {
                        case 0:
                            System.out.println("Usuario seleccionó Slot 1");
                            nombreGuardado+= "slot1.dat";
                            // Puedes agregar lógica específica para Slot 1 aquí
                            break;
                        case 1:
                            System.out.println("Usuario seleccionó Slot 2");
                            nombreGuardado+= "slot2.dat";
                            // Puedes agregar lógica específica para Slot 2 aquí
                            break;
                        case 2:
                            System.out.println("Usuario seleccionó Slot 3");
                            nombreGuardado+= "slot3.dat";
                            // Puedes agregar lógica específica para Slot 3 aquí
                            break;
                        default:
                            System.out.println("Usuario canceló la operación");
                            // Puedes agregar lógica para el caso de cancelación aquí
                            break;
                    }
                    //Interfaz para seleccionar el slot de guardado.
                    ObjectOutputStream fileOut = new ObjectOutputStream(new FileOutputStream(nombreGuardado));
                    Date fechaActual = new Date();
                    fileOut.writeObject(fechaActual);
                    fileOut.writeObject(reinoMenu);
                    fileOut.writeObject(reinoOtro);
                    //Siempre el primero es el que continua
                    fileOut.close();
                    System.out.println("exito en la escritura de archivos");

                    System.exit(0);
                }catch(Exception ex){
                    System.out.println("Error en la escritura de archivos");
                    System.out.println(ex.getMessage());
                }
            }
        });

        botones.add(guardar);
    

        // Botón para cerrar
        JButton cerrar = new JButton("Salir");
        cerrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                latch.countDown();
                dispose();
            }
        });
        botones.add(cerrar);
        add(botones, BorderLayout.SOUTH);
    }

    private ImageIcon resizeImage(ImageIcon icon, int width, int height) {
        Image img = icon.getImage();
        Image newImg = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(newImg);
    }

    public void mostrar() {
        setVisible(true);
        
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void repintar(){
        getContentPane().removeAll(); 
        createContents(); 
        revalidate(); 
        repaint();    
    }

}


