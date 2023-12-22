package IVS.main.listener;

import IVS.main.ui.WDParameterWinInput;
import IVS.main.ui.ResultWin;
import IVS.main.generator.GeneratorWD;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WDParameterWinInputListener implements ActionListener {
        private final JFrame parentFrame;

        private double[] dataRR;
        public WDParameterWinInputListener(JFrame parentFrame, double[] dataRR) {
            this.parentFrame = parentFrame;
            this.dataRR = dataRR;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            WDParameterWinInput inputWindow = (WDParameterWinInput) parentFrame;
            String distributionType = inputWindow.getDistributionType();

            // Get parameters from the input window
            double[] parameters = inputWindow.getParameters();
            if (parameters == null) {
                return; // Invalid parameters, don't proceed
            }

            double[] dataWD = GeneratorWD.generateRandomNumbers(distributionType, dataRR, parameters);
            ResultWin resultWindow = new ResultWin(dataWD);
            resultWindow.setVisible(true);
            parentFrame.dispose();
        }
    }
