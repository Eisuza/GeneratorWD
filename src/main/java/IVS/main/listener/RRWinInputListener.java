package IVS.main.listener;

import IVS.main.generator.GeneratorRR;
import IVS.main.ui.WDTypeWinInput;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RRWinInputListener implements ActionListener {
    private JFrame parentFrame;
    private JTextField aField, R0Field, mField, nField;

    public RRWinInputListener(JFrame parentFrame,
                                  JTextField aField, JTextField R0Field, JTextField mField, JTextField nField) {
        this.parentFrame = parentFrame;
        this.aField = aField;
        this.R0Field = R0Field;
        this.mField = mField;
        this.nField = nField;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        int a = 0, R0 = 0, m = 0, n = 0;

        try {
            // Move these lines inside the try block to get the values after user input
            a = Integer.parseInt(aField.getText());
            R0 = Integer.parseInt(R0Field.getText());
            m = Integer.parseInt(mField.getText());
            n = Integer.parseInt(nField.getText());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(parentFrame, "Введены неверные значения. Пожалуйста, введите целочисленные значения.");
            return; // Exit the method if there's an error
        }
        GeneratorRR generatorRR = new GeneratorRR(a, R0, m, n);
        WDTypeWinInput wdTypeWinInput = new WDTypeWinInput(generatorRR.getRandomNumbers());
        wdTypeWinInput.setVisible(true);
        parentFrame.dispose();
    }
}
