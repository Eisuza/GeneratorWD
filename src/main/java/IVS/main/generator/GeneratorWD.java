package IVS.main.generator;

import java.util.Random;

public class GeneratorWD {

    public static double[] generateRandomNumbers(String distribution, double[] dataRR, double[] parameters) {
        int size = dataRR.length;
        double[] data;
        int dataSize;
        int endIndex;
        double a, b, mean, stdDev, sum, lambda;
        switch (distribution) {
            case "Равномерное":
                data = new double[size];
                a = parameters[0];
                b = parameters[1];
                for (int i = 0; i < size; i++) {
                    data[i] = a + (b - a) * dataRR[i];
                }
                break;
            case "Гауссовское":
                dataSize = size /6;
                data = new double[dataSize];
                endIndex = dataRR.length - (dataRR.length % 6);
                mean = parameters[0];
                stdDev = parameters[1];

                for (int i = 0, j = 0; i <endIndex; i += 6, j++) {
                    sum = dataRR[i] + dataRR[i + 1] + dataRR[i + 2] + dataRR[i + 3] + dataRR[i + 4] + dataRR[i + 5];
                    double z = Math.sqrt(2)*(sum-3);
                    data[j] = mean + stdDev * z;
                }
                break;
            case "Экспоненциальное":
                data = new double[size];
                lambda = parameters[0];
                for (int i = 0; i < size; i++) {
                    if (dataRR[i] != 0.0) {
                        data[i] = -Math.log(dataRR[i]) / lambda;
                    }
                    else data[i] = 0.0;
                }
                break;
            case "Гамма":
                int n = (int)parameters[0];
                lambda = parameters[1];
                dataSize = size/ n;
                data = new double[dataSize];
                endIndex = dataRR.length - (dataRR.length % n);
                for (int i = 0, j = 0; i <endIndex; i += n, j++) {
                    sum = 0;
                    for (int z = i; z < i + n; z++) {
                        sum += dataRR[z];
                    }
                    data[j] = 1/lambda*Math.log(sum);
                }
                break;
            case "Треугольное":
                dataSize = size/2;
                endIndex = dataRR.length - (dataRR.length % 2);
                data = new double[dataSize];
                a = parameters[0];
                b = parameters[1];
                for (int i = 0, j = 0; i < endIndex; i+= 2, j++) {
                    data[j] = a + (b - a) * maxDouble(dataRR[i], dataRR[i+1]);
                }
                break;
            case "Симпсона":
                dataSize = size/2;
                endIndex = dataRR.length - (dataRR.length % 2);
                data = new double[dataSize];
                a = parameters[0];
                b = parameters[1];
                for (int i = 0, j = 0; i < endIndex; i += 2, j++) {
                    double y = a/2 + (b/2 - a/2)*dataRR[i];
                    double z = a/2 + (b/2 - a/2)*dataRR[i+1];
                    data[j]= y + z;
                }
                break;
            default:
                data = new double[0]; // Default to an empty array for unknown distribution
                break;
        }
        if (data == null) {
            throw new IllegalArgumentException("Unknown distribution type: " + distribution);
        }
        return data;
    }

    public static double[] calculateStatistics(double[] data) {
        double mean = 0;
        for (double value : data) {
            mean += value;
        }
        mean /= data.length;

        double variance = 0;
        for (double value : data) {
            variance += Math.pow(value - mean, 2);
        }
        variance /= data.length;

        double stdDev = Math.sqrt(variance);

        return new double[]{mean, variance, stdDev};
    }

    private static double maxDouble(double num1, double num2) {
        return (num1 > num2) ? num1 : num2;
    }
}
