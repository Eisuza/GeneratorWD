package IVS.main.ui;

import IVS.main.listener.WDTypeWinInputListener;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class WDTypeWinInput extends JFrame {
    private double[] data;

    public WDTypeWinInput(double[] dataRR) {
        this.data = dataRR;
        setTitle("Тип распределения случайных чисел");
        setSize(600, 200);
        getContentPane().setBackground(new Color(218, 228, 245));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JLabel label = new JLabel("Выберите тип распределения");
        label.setFont(new Font("Georgia", Font.BOLD, 16));
        label.setHorizontalAlignment(JLabel.CENTER);
        add(label, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel(new GridLayout(2, 3, 10, 10));
        buttonPanel.setBackground(new Color(218, 228, 245));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        String[] distributions = {"Равномерное", "Гауссовское", "Экспоненциальное", "Гамма", "Треугольное", "Симпсона"};

        for (String distribution : distributions) {
            JButton distributionButton = new JButton(distribution);
            distributionButton.setFont(new Font("Georgia", Font.PLAIN, 14));
            distributionButton.addActionListener(new WDTypeWinInputListener(distribution, this, data));
            buttonPanel.add(distributionButton);
        }
        add(buttonPanel, BorderLayout.CENTER);
        ImageIcon icon = getCustomIcon();
        setIconImage(icon.getImage());
        setLocationRelativeTo(null);
    }
    private ImageIcon getCustomIcon() {
        return new ImageIcon(Objects.requireNonNull(RRWinInput.class.getResource("/icon.png")));
    }
}
