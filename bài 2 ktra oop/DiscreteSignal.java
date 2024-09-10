public class DiscreteSignal implements Signal {
    private int k; // Độ trễ (delay)

    // Constructor để khởi tạo độ trễ k
    public DiscreteSignal(int k) {
        this.k = k;
    }

    // Phương thức tính giá trị của x(n) dựa vào x(n - k)
    public int compute(int n, int[] x) {
        int d_n = (n == 0) ? 1 : 0; // Dãy xung đơn vị d(n)
        if (n - k >= 0) {
            return d_n * x[n - k];
        }
        return 0;
    }

    
    public int[] generateSignal(int size) {
        int[] signal = new int[size];
        for (int i = 0; i < size; i++) {
            signal[i] = compute(i, signal);
        }
        return signal;
    }

    
    public void activate() {
        System.out.println("DiscreteSignal is activated");
    }

    
    public void deactivate() {
        System.out.println("DiscreteSignal is deactivated");
    }
}
