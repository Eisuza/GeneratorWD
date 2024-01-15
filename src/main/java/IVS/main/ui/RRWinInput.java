package IVS.main.ui;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

import IVS.main.listener.RRWinInputListener;

public class RRWinInput extends JFrame {

    public RRWinInput() {
        setTitle("Параметры для генерации последовательности РРСЧ");
        setLayout(new GridLayout(6, 2));
        getContentPane().setBackground(new Color(218, 228, 245));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTextField aField = new JTextField();
        JTextField R0Field = new JTextField();
        JTextField mField = new JTextField();
        JTextField nField = new JTextField();

        Font inputFont = new Font("Georgia", Font.PLAIN, 14);
        aField.setFont(inputFont);
        R0Field.setFont(inputFont);
        mField.setFont(inputFont);
        nField.setFont(inputFont);

        add(new JLabel("Введите параметр 'a':")).setFont(inputFont);
        add(aField);

        add(new JLabel("Введите параметр 'R0':")).setFont(inputFont);
        add(R0Field);

        add(new JLabel("Введите параметр 'm'('m' > 'a'):")).setFont(inputFont);
        add(mField);

        add(new JLabel("Введите количество генерируемых чисел 'n':")).setFont(inputFont);
        add(nField);

        JButton generateButton = new JButton("Сгенерировать случайные р.р. числа");
        generateButton.setFont(new Font("Georgia", Font.PLAIN, 14));
        generateButton.addActionListener(new RRWinInputListener(this, aField, R0Field, mField, nField));
        add(generateButton);

        pack();
        ImageIcon icon = getCustomIcon();
        setIconImage(icon.getImage());
        setLocationRelativeTo(null);
        setVisible(true);
    }
    private ImageIcon getCustomIcon() {
        return new ImageIcon(Objects.requireNonNull(RRWinInput.class.getResource("/icon.png")));
    }
}
