public class Main {
    public static void main(String[] args) {
        // Tạo và thử nghiệm DiscreteSignal
        DiscreteSignal discreteSignal = new DiscreteSignal(2); // Ví dụ k = 4
        int[] signal = discreteSignal.generateSignal(10);
        System.out.println("Discrete Signal:");
        for (int value : signal) {
            System.out.print(value + " ");
        }
        System.out.println();
        
        discreteSignal.activate();
        discreteSignal.deactivate();

        // Tạo và thử nghiệm ContinuousSignal
        // ContinuousSignal continuousSignal = new ContinuousSignal();
        // continuousSignal.activate();
        // continuousSignal.deactivate();
        
        // Thử nghiệm Radar
        Radar radar = new Radar();
        double[] analyzedSignal = radar.analyzeSignal(4); // Phân tích tín hiệu với kích thước n = 4
        System.out.println("Radar Analyzed Signal:");
        for (double value : analyzedSignal) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}


