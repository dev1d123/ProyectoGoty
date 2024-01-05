import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.concurrent.CountDownLatch;

public class PreparacionMenu extends JFrame {
    private int opcionSeleccionada;
    private CountDownLatch latch = new CountDownLatch(1);
    private Reino r;
    private int indiceEdificio = -1;

    public PreparacionMenu(Reino r) {
        this.r = r;
        int ancho = 600;
        int alto = 400;
        setSize(ancho, alto);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        crearContenido();


        setVisible(true);
    }
    private void crearContenido(){
        JPanel infoPanel = new JPanel(new BorderLayout());
        mostrarInfoInicial(infoPanel);
        add(infoPanel, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel(new FlowLayout());
        createContents(buttonPanel);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    private void mostrarInfoInicial(JPanel panel) {
        // Itera sobre todas las unidades y muestra su información
        JPanel infoUnit = new JPanel();
        infoUnit.add(new JLabel("UNIDADES"));
        for (Unit unidad : r.getUnidades()) {
            ImageIcon unidadIcon = resizeImage(unidad.getIcon(), 50, 50);
            JLabel unidadLabel = new JLabel(unidad.getNombre(), unidadIcon, JLabel.CENTER);
            unidadLabel.setVerticalTextPosition(JLabel.BOTTOM);
            unidadLabel.setHorizontalTextPosition(JLabel.CENTER);
            infoUnit.add(unidadLabel);
        }
        panel.add(infoUnit, BorderLayout.NORTH);

        JPanel infoBuild = new JPanel();
        infoBuild.add(new JLabel("EDIFICIOS"));
        // Itera sobre todos los edificios y muestra su información
        for (Buildings edificio : r.getEdificios()) {
            ImageIcon edificioIcon = resizeImage(edificio.getIcon(), 50, 50);
            JLabel edificioLabel = new JLabel(edificio.getNombre(), edificioIcon, JLabel.CENTER);
            edificioLabel.setVerticalTextPosition(JLabel.BOTTOM);
            edificioLabel.setHorizontalTextPosition(JLabel.CENTER);
            infoBuild.add(edificioLabel);
        }
        panel.add(infoBuild, BorderLayout.SOUTH);

    }

    private ImageIcon resizeImage(ImageIcon icon, int width, int height) {
        Image img = icon.getImage();
        Image newImg = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(newImg);
    }

    private void createContents(JPanel panel) {
        JButton crearUnidad = new JButton("Crear unidad productora");
        crearUnidad.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                opcionSeleccionada = 2;
                latch.countDown();
                repintar();
                dispose();
            }
        });
        panel.add(crearUnidad);

        JButton popUnidad = new JButton("Eliminar un trabajador");
        popUnidad.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                opcionSeleccionada = 3;
                latch.countDown();
                repintar();
                dispose();
            }
        });
        panel.add(popUnidad);

        JButton crearEdificio = new JButton("Crear Edificio");
        crearEdificio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] opciones = r.getData();
                int indiceSeleccionado = JOptionPane.showOptionDialog(
                        null,
                        "Selecciona una opción:",
                        "Opciones",
                        JOptionPane.DEFAULT_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        opciones,
                        opciones[0]);

                if (indiceSeleccionado != JOptionPane.CLOSED_OPTION) {
                    indiceEdificio = indiceSeleccionado;
                }

                opcionSeleccionada = 1;
                latch.countDown();
                dispose();
            }
        });
        panel.add(crearEdificio);
    }

    public int getIndiceEdificio() {
        return indiceEdificio;
    }

    public int getOpcionSeleccionada() {
        mostrar();
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return opcionSeleccionada;
    }

    public void mostrar() {
        setVisible(true);
    }
    public void repintar(){
        getContentPane().removeAll(); 
        crearContenido();
        revalidate(); 
        repaint();    
    }
}
