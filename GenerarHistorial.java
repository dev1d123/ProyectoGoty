import javax.swing.*;
import java.awt.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class GenerarHistorial extends JFrame {
    private JTextArea historialTextArea;

    public GenerarHistorial() {
        setTitle("Historial de Partidas");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);

        historialTextArea = new JTextArea();
        historialTextArea.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(historialTextArea);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        add(scrollPane);

        cargarHistorial();

        setVisible(true);
    }

    private void cargarHistorial() {
        try (Scanner scanner = new Scanner(new FileInputStream("historial.txt"))) {
            int numeroPartida = 1;

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.equals("Winner")) {
                    historialTextArea.append("Partida " + numeroPartida + "\n");
                    historialTextArea.append("Winner\n");
                } else if (line.equals("Looser")) {
                    historialTextArea.append("Looser\n");
                } else if (line.equals("0")) {
                    historialTextArea.append("0\n\n");
                    numeroPartida++;
                } else {
                    historialTextArea.append(line + "\n");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
