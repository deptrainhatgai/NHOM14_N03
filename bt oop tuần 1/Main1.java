public // Lớp Main với biến thành viên 'i'
public class Main1 { 
    public int i; 
}

public class Assignment2 {
    public static void main(String[] args) {
        Main1 n1 = new Main1(); 
        Main1 n2 = new Main1(); 
        n1.i = 2;
        n2.i = 5;
        n1 = n2; 
        n2.i = 10; 
        System.out.println("Giá trị của n1.i: " + n1.i); // Kết quả sẽ là 10
        System.out.println("Giá trị của n2.i: " + n2.i); // Kết quả sẽ là 10
        n1.i = 20;
        System.out.println("Giá trị của n1.i sau khi n1.i = 20: " + n1.i); // Kết quả sẽ là 20
        System.out.println("Giá trị của n2.i sau khi n1.i = 20: " + n2.i); // Kết quả sẽ là 20
    } 
}
 {
    
}
