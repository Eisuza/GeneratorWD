package IVS.main.ui;

import IVS.main.generator.GeneratorWD;

import javax.swing.*;
import java.awt.*;
import java.text.DecimalFormat;
import java.util.Objects;

public class ResultWin extends JFrame {
    private final double[] data;

    public ResultWin(double[] dataWD) {
        super("Результаты");
        this.data = dataWD;
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        JTextArea resultsTextArea = new JTextArea();
        resultsTextArea.setBackground(new Color(218, 228, 245)); // Light Blue background
        Font georgiaFont = new Font("Times New Roman", Font.PLAIN, 14);
        resultsTextArea.setFont(georgiaFont);
        resultsTextArea.setEditable(false);

        // Display results
        resultsTextArea.append("Сгенерированные случайные величины:\n");
        for (int i = 0; i < data.length; i++) {
            resultsTextArea.append(formatDecimal(data[i]) + "\t");
            if ((i + 1) % 10 == 0) {
                resultsTextArea.append("\n");
            }
        }

        double[] statistics = GeneratorWD.calculateStatistics(data);

        resultsTextArea.append("\nОценки: ");
        resultsTextArea.append("\nМатематическое ожидание: " + formatDecimal(statistics[0]));
        resultsTextArea.append("\nДисперсия: " + formatDecimal(statistics[1]));
        resultsTextArea.append("\nСреднее квадратичное отклонение: " + formatDecimal(statistics[2]));

        JScrollPane scrollPane = new JScrollPane(resultsTextArea);
        add(scrollPane, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(null);
        ImageIcon icon = getCustomIcon();
        setIconImage(icon.getImage());
        HistogramWin histogramWindow = new HistogramWin(data);
    }

    private String formatDecimal(double value) {
        return String.format("%.4f", value);
    }
    private ImageIcon getCustomIcon() {
        return new ImageIcon(Objects.requireNonNull(ResultWin.class.getResource("/icon.png")));
    }
}
