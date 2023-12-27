import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;
import java.util.concurrent.CountDownLatch;

import javax.swing.*;

public class InicioJuego extends JFrame {
    private static CountDownLatch latch = new CountDownLatch(1);

    private JPanel panelReino1;
    private JPanel panelReino2;

    private char opt1;
    private char opt2;
    public InicioJuego() {
        setTitle("Juego de Reinos");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panelPrincipal = new JPanel(new BorderLayout());



        panelReino1 = crearPanelReino("Reino 1");
        panelReino2 = crearPanelReino("Reino 2");

        panelPrincipal.add(panelReino1, BorderLayout.LINE_START);
        panelPrincipal.add(panelReino2, BorderLayout.LINE_END);

        // Botón en la parte inferior
        JButton enviarButton = new JButton("JUGAR!!!");
        panelPrincipal.add(enviarButton, BorderLayout.PAGE_END);

        add(panelPrincipal);

        enviarButton.addActionListener(new ListenerBoton());

        setLocationRelativeTo(null); 
        setVisible(true);

        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        dispose();
        System.out.println("Opcion del reino 1: " + opt1);
        System.out.println("Opcion del reino 2: " + opt2);
        //EN VEZ DE LLAMAR A JUEGO, SE LLAMA A LA FASE DE PREPARACION
        Juego.iniciarJuego(opt1, opt2);
    }

    private class ListenerBoton implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            imprimirOpcionesSeleccionadas();
            latch.countDown();
        }
    }

    private void imprimirOpcionesSeleccionadas() {
        imprimirOpcionesSeleccionadas(panelReino1, 1);
        imprimirOpcionesSeleccionadas(panelReino2, 2);
    }

    private void imprimirOpcionesSeleccionadas(JPanel panelReino, int r) {
        ButtonGroup grupoCheckBox = (ButtonGroup) panelReino.getClientProperty("grupoCheckBox");
        Enumeration<AbstractButton> elementos = grupoCheckBox.getElements();
        while (elementos.hasMoreElements()) {
            AbstractButton button = elementos.nextElement();
            if (button.isSelected()) {
                if(r == 1) opt1 = button.getText().charAt(0);
                else opt2 = button.getText().charAt(0);
                break;
            }
        }
    }

    private JPanel crearPanelReino(String nombreReino) {
        JPanel panelReino = new JPanel();
        panelReino.setLayout(new BoxLayout(panelReino, BoxLayout.Y_AXIS));

        JLabel labelReino = new JLabel(nombreReino);
        labelReino.setAlignmentX(Component.CENTER_ALIGNMENT);
        panelReino.add(labelReino);

        ButtonGroup grupoCheckBox = new ButtonGroup();

        JCheckBox checkBox1 = new JCheckBox("Imperio Medieval");
        checkBox1.setAlignmentX(Component.CENTER_ALIGNMENT);
        grupoCheckBox.add(checkBox1);
        panelReino.add(checkBox1);

        JCheckBox checkBox2 = new JCheckBox("Republica contemporanea");
        checkBox2.setAlignmentX(Component.CENTER_ALIGNMENT);
        grupoCheckBox.add(checkBox2);
        panelReino.add(checkBox2);

        JCheckBox checkBox3 = new JCheckBox("Dictadura Futurista");
        checkBox3.setAlignmentX(Component.CENTER_ALIGNMENT);
        grupoCheckBox.add(checkBox3);
        panelReino.add(checkBox3);

        panelReino.putClientProperty("grupoCheckBox", grupoCheckBox);

        return panelReino;
    }

    public static void main(String[] args) {
        InicioJuego h = new InicioJuego();
    }
}
