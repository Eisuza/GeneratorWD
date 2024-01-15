package IVS.main.generator;

public class GeneratorRR {
    private double[] randomNumbers;
    public GeneratorRR(int a, int R0, int m, int n) {
        randomNumbers = new double[n];
        for (int i = 0; i < n; i++) {
            R0 = (a * R0) % m;
            randomNumbers[i] = (double) R0 / m;
        }
    }

    public double[] getRandomNumbers() {
        return randomNumbers;
    }
}
