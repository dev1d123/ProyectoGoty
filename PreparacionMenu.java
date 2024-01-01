import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.concurrent.CountDownLatch;

public class PreparacionMenu extends JFrame {
    public int opcionSeleccionada; 
    private CountDownLatch latch = new CountDownLatch(1);
    private Reino r;
    private int indiceEdificio = -1;
    public PreparacionMenu(Reino r) {
        this.r = r;
        int ancho = 200;
        int alto = 400;
        setSize(ancho, alto);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                latch.countDown();
                dispose();
            }
        });
        setLayout(new GridLayout(2,1));
        createContents();


    }

    public void createContents() {
        JButton crearUnidad = new JButton("Crear Unidad");
        crearUnidad.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                opcionSeleccionada = 2;
                latch.countDown();
                dispose();
            }
        });
        add(crearUnidad);

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
                
                // Verifica si se hizo una selección y muestra el resultado
                if (indiceSeleccionado != JOptionPane.CLOSED_OPTION) {
                    indiceEdificio = indiceSeleccionado;
                }
                                
                opcionSeleccionada = 1;
                latch.countDown();
                dispose();
            }
        });
        add(crearEdificio);
    }
    public int getIndiceEdificio(){
        return indiceEdificio;
    }
    public int getOpcionSeleccionada() {
        mostrar();
        try {
            latch.await(); 
        } catch (InterruptedException e) {
            e.printStackTrace();
        }    
        int sol = opcionSeleccionada;

        return sol;
    }
    public void mostrar(){
        setVisible(true);
    }

}
