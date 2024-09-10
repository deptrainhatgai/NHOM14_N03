public class Radar {
    // Phương thức phân tích tín hiệu với mẫu tín hiệu
    public double[] analyzeSignal(int size) {
        double[] signal = new double[size];
        for (int n = 0; n < size; n++) {
            if (n >= 0 && n <= 15) {
                signal[n] = 1 - (n / 15.0);
            } else {
                signal[n] = 0;
            }
        }
        return signal;
    }

    public static void main(String[] args) {
        Radar radar = new Radar();
        double[] analyzedSignal = radar.analyzeSignal(4); // Phân tích tín hiệu với kích thước n = 4
        System.out.println("Radar Analyzed Signal:");
        for (double value : analyzedSignal) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}
