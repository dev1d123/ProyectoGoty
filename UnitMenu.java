import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.concurrent.CountDownLatch;

public class UnitMenu extends JFrame {
    private String[] datos;
    private String[] opciones;
    private CountDownLatch latch = new CountDownLatch(1);

    public UnitMenu(String[] datos, String[] opciones) {
        this.datos = datos;
        this.opciones = opciones;
        int ancho = 200;
        int alto = (datos.length + opciones.length - 1) * 50;
        setSize(ancho, alto);
        setLayout(new GridLayout(datos.length + opciones.length, 1, 2, 2));
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                // Llamar a tu método cuando la ventana se cierra
                latch.countDown();
                dispose();            
            }
        });
        createContents();

        // Hacer la ventana visible de manera modal
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);

        // Esperar hasta que la ventana se cierre
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
        }

        JButton closeButton = new JButton("Cerrar");
        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Al hacer clic en el botón de cerrar, contar abajo el latch
                latch.countDown();
                // Cerrar la ventana
                dispose();
            }
        });
        add(closeButton);
    }
}
