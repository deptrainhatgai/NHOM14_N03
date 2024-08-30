public class Main { 
    public int i; 

    public static void main(String[] args) { 
        Main n1 = new Main(); 
        Main n2 = new Main();
        n1.i = 2;
        n2.i = 5;
        n1.i = n2.i; 
        n2.i = 10;
        System.out.println("Giá trị của n1.i: " + n1.i); 
    } 
}