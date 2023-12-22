package IVS.main.listener;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import IVS.main.ui.WDParameterWinInput;

public class WDTypeWinInputListener implements ActionListener {
    private static final int UNIFORM_PARAMETERS = 2;
    private static final int GAUSSIAN_PARAMETERS = 2;
    private static final int EXPONENTIAL_PARAMETERS = 1;
    private static final int GAMMA_PARAMETERS = 2;
    private static final int TRIANGULAR_PARAMETERS = 2;
    private static final int SIMPSON_PARAMETERS = 2;
    private final String distributionType;
    private final JFrame parentFrame;
    private double[] data;

    public WDTypeWinInputListener (String distributionType, JFrame parentFrame, double[] dataRR) {
        this.distributionType = distributionType;
        this.parentFrame = parentFrame;
        this.data = dataRR;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        WDParameterWinInput inputWindow;
        switch (distributionType) {
            case "Равномерное":
                inputWindow = new WDParameterWinInput(distributionType, UNIFORM_PARAMETERS, data);
                break;
            case "Гауссовское":
                inputWindow = new WDParameterWinInput(distributionType, GAUSSIAN_PARAMETERS, data);
                break;
            case "Экспоненциальное":
                inputWindow = new WDParameterWinInput(distributionType, EXPONENTIAL_PARAMETERS, data);
                break;
            case "Гамма":
                inputWindow = new WDParameterWinInput(distributionType, GAMMA_PARAMETERS, data);
                break;
            case "Треугольное":
                inputWindow = new WDParameterWinInput(distributionType, TRIANGULAR_PARAMETERS, data);
                break;
            case "Симпсона":
                inputWindow = new WDParameterWinInput(distributionType, SIMPSON_PARAMETERS, data);
                break;
            default:
                return;
        }
        inputWindow.setVisible(true);
        parentFrame.dispose();
    }
}
