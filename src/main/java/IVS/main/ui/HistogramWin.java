package IVS.main.ui;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.DefaultDrawingSupplier;
import org.jfree.data.statistics.HistogramDataset;


import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class HistogramWin extends JFrame {

    public HistogramWin(double[] data) {
        // Create a histogram dataset
        HistogramDataset dataset = new HistogramDataset();
        dataset.addSeries("Случайные числа", data, 20);

        // Create a chart
        JFreeChart chart = ChartFactory.createHistogram(
                "Гистограмма случайных чисел с заданным распределением",
                "Значение",
                "Частота",
                dataset
        );

        // Set a blue color for the histogram bars
        chart.getPlot().setBackgroundPaint(new Color(218, 228, 245));  // Light Blue background
        chart.getPlot().setDrawingSupplier(
                new DefaultDrawingSupplier(
                        new Paint[]{new Color(120, 149, 196)},  // Blue color for bars
                        DefaultDrawingSupplier.DEFAULT_OUTLINE_PAINT_SEQUENCE,
                        DefaultDrawingSupplier.DEFAULT_STROKE_SEQUENCE,
                        DefaultDrawingSupplier.DEFAULT_OUTLINE_STROKE_SEQUENCE,
                        DefaultDrawingSupplier.DEFAULT_SHAPE_SEQUENCE
                )
        );

        // Display the chart in a JFrame
        SwingUtilities.invokeLater(() -> {
            JFrame chartFrame = new JFrame("Гистограмма");
            chartFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            chartFrame.setLayout(new BorderLayout());

            ChartPanel chartPanel = new ChartPanel(chart);
            chartFrame.add(chartPanel, BorderLayout.CENTER);

            chartFrame.pack();
            chartFrame.setLocationRelativeTo(null);
            ImageIcon icon = getCustomIcon();
            chartFrame.setIconImage(icon.getImage());
            chartFrame.setVisible(true);
        });
    }

    private ImageIcon getCustomIcon() {
        return new ImageIcon(Objects.requireNonNull(HistogramWin.class.getResource("/icon.png")));
    }
}