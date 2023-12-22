package IVS.main.ui;

import IVS.main.listener.WDParameterWinInputListener;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class WDParameterWinInput extends JFrame {
    private final String distributionType;
    private final JTextField[] parameterFields;
    private double[] data;

    public WDParameterWinInput(String distributionType, int numParameters, double[] dataRR) {
        super("Ввод параметров для заданного распределения");
        this.data = dataRR;
        this.distributionType = distributionType;
        setSize(400, 200);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        //setLayout(new GridLayout(numParameters + 1, 2));
        setLayout (new BorderLayout());

        JPanel infoPanel = new JPanel();
        infoPanel.setBackground(new Color(218, 228, 245));
        infoPanel.add(new JLabel("Тип распределения: " + distributionType + "\n"));
        add(infoPanel, BorderLayout.NORTH);

        JPanel inputPanel = new JPanel();
        inputPanel.setBackground(new Color(218, 228, 245));
        inputPanel.setLayout(new GridLayout(numParameters, 2));
        parameterFields = new JTextField[numParameters];

        for (int i = 0; i < numParameters; i++) {
            inputPanel.add(new JLabel("Введите параметр " + (i + 1) + ":"));
            parameterFields[i] = new JTextField(10);
            parameterFields[i].setFont(new Font("Georgia", Font.PLAIN, 14));
            inputPanel.add(parameterFields[i]);
        }

        add(inputPanel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.setBackground(new Color(218, 228, 245));
        JButton generateButton = new JButton("Сгенерировать");
        generateButton.setFont(new Font("Georgia", Font.PLAIN, 14));
        generateButton.addActionListener(new WDParameterWinInputListener(this, data));
        buttonPanel.add(generateButton);
        add(buttonPanel, BorderLayout.SOUTH);
        ImageIcon icon = getCustomIcon();
        setIconImage(icon.getImage());
        setLocationRelativeTo(null);
    }

    public String getDistributionType() {
        return distributionType;
    }

    public double[] getParameters() {
        double[] parameters = new double[parameterFields.length];
        for (int i = 0; i < parameterFields.length; i++) {
            try {
                parameters[i] = Double.parseDouble(parameterFields[i].getText());
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Неверный формат параметров. Введите допустимые значения.");
                return null;
            }
        }
        return parameters;
    }
    private ImageIcon getCustomIcon() {
        return new ImageIcon(Objects.requireNonNull(RRWinInput.class.getResource("/icon.png")));
    }
}



