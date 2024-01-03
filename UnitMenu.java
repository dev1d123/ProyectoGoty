import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.concurrent.CountDownLatch;

public class UnitMenu extends JFrame {
    private String[] datos;
    private String[] opciones;
    private int opcionSeleccionada; // Nueva variable para almacenar la opción seleccionada
    //1 -> mover
    //2 -> habilidades
    //3 -> cerrar
    private CountDownLatch latch = new CountDownLatch(1);
    private Field campo;
    private Reino r;
    private Unit u;
    public UnitMenu(Field campo, String[] datos, String[] opciones, Unit u, Reino r) {
        this.r = r;
        this.u = u;
        this.campo = campo;
        this.datos = datos;
        this.opciones = opciones;
        int ancho = 400;
        int alto = (datos.length + opciones.length - 1) * 50;
        setSize(ancho, alto);
        setLayout(new GridLayout(datos.length + opciones.length, 1, 2, 2));
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                latch.countDown();
                dispose();
            }
        });
        createContents();

        // Hacer la ventana visible de manera modal
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);

        // Esperar hasta que latchDown -> sea 0
        try {
            latch.await();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }

    public void createContents() {
        String nombreSoldado = opciones[0];
        setTitle(nombreSoldado);

        // Datos
        for (String dato : datos) {
            JLabel label = new JLabel(dato);
            add(label);
        }

        // Opciones
        for (int i = 1; i < opciones.length; i++) {
            JButton button = new JButton(opciones[i]);
            add(button);
            if (i == 1) {
                button.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        opcionSeleccionada = 1;
                        dispose();
                        latch.countDown();
                    }
                });
            }
            if(i == 2){
                button.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        JOptionPane.showMessageDialog(null, "1Has seleccionado una habilidad");
                        opcionSeleccionada = u.hacerAccion(r, campo); 
                        dispose();
                        latch.countDown();
                    }
                });
            }
            
        }

        JButton closeButton = new JButton("Cerrar");
        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                opcionSeleccionada = 3;
                latch.countDown();
                dispose();
            }
        });
        add(closeButton);
    }

    // Nuevo método para obtener la opción seleccionada
    public int getOpcionSeleccionada() {
        return opcionSeleccionada;
    }
}
