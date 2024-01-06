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

        Reino r1 = new Reino(opt1, 1);
        Reino r2 = new Reino(opt2, 2);
        // EN VEZ DE LLAMAR A JUEGO, SE LLAMA A LA FASE DE PREPARACION -> Juego se encarga
        Juego.iniciarJuego(r1, r2);
    }

    private class ListenerBoton implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            asignarOpcionesSeleccionadas();
            latch.countDown();
        }
    }

    private void asignarOpcionesSeleccionadas() {
        asignarOpcionesSeleccionadas(panelReino1, 1);
        asignarOpcionesSeleccionadas(panelReino2, 2);
    }

    private void asignarOpcionesSeleccionadas(JPanel panelReino, int r) {
        ButtonGroup grupoRadioButtons = (ButtonGroup) panelReino.getClientProperty("grupoRadioButtons");
        Enumeration<AbstractButton> elementos = grupoRadioButtons.getElements();
        while (elementos.hasMoreElements()) {
            AbstractButton button = elementos.nextElement();
            if (button.isSelected()) {
                if (r == 1) opt1 = button.getText().charAt(0);
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

        ButtonGroup grupoRadioButtons = new ButtonGroup();

        JRadioButton radioButton1 = new JRadioButton("Imperio Medieval");
        radioButton1.setAlignmentX(Component.CENTER_ALIGNMENT);
        grupoRadioButtons.add(radioButton1);
        panelReino.add(radioButton1);

        JRadioButton radioButton2 = new JRadioButton("Republica contemporanea");
        radioButton2.setAlignmentX(Component.CENTER_ALIGNMENT);
        grupoRadioButtons.add(radioButton2);
        panelReino.add(radioButton2);

        JRadioButton radioButton3 = new JRadioButton("Dictadura Futurista");
        radioButton3.setAlignmentX(Component.CENTER_ALIGNMENT);
        grupoRadioButtons.add(radioButton3);
        panelReino.add(radioButton3);

        panelReino.putClientProperty("grupoRadioButtons", grupoRadioButtons);

        return panelReino;
    }

    public static void main(String[] args) {
        InicioJuego h = new InicioJuego();
    }
}

