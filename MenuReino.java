import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.CountDownLatch;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

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
        setLayout(new GridLayout(5, 1)); // 5 filas y 1 columna
    
        // Panel para mostrar información de dinero, recursos y manutención
        JPanel infoPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
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
        add(infoPanel);
    
        // Panel para mostrar información de unidades
        JPanel infoUnit = new JPanel(new FlowLayout(FlowLayout.LEFT));
        infoUnit.add(new JLabel("UNIDADES CREADAS"));
        for (Unit unidad : reinoMenu.getUnidades()) {
            ImageIcon unidadIcon = resizeImage(unidad.getIcon(), 50, 50);
            JLabel unidadLabel = new JLabel(unidad.getNombre(), unidadIcon, JLabel.CENTER);
            unidadLabel.setVerticalTextPosition(JLabel.BOTTOM);
            unidadLabel.setHorizontalTextPosition(JLabel.CENTER);
            infoUnit.add(unidadLabel);
        }
        add(infoUnit);
    
        // Panel para mostrar información de edificios
        JPanel infoBuild = new JPanel(new FlowLayout(FlowLayout.LEFT));
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
        add(infoBuild);
    
        // Botón para crear edificio
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
                    reinoMenu.gastarDinero(edificio.getCosto());
                    repintar();
                }else{
                    JOptionPane.showMessageDialog(null, "DINERO INSUFICIENTE");
            
                }
            }    
        });
        add(crearEdificio);
    
        // Botón para cerrar
        JButton cerrar = new JButton("Salir");
        cerrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                latch.countDown();
                dispose();
            }
        });
        add(cerrar);
    }

    private ImageIcon resizeImage(ImageIcon icon, int width, int height) {
        Image img = icon.getImage();
        Image newImg = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(newImg);
    }

    public void mostrar() {
        setVisible(true);
        JOptionPane.showMessageDialog(null, "llega a este punto!!!");
        
        try {
            System.out.println("??????");
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


