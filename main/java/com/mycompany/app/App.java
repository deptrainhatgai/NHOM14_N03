package com.mycompany.app;

public class App {
    public static void main(String[] args) {
        // Tạo đối tượng book
        Book book = new Book("Nhung Dieu Ky Dieu", "Nhóm14_N03");
        
        // Tạo đối tượng Time
        Time time = new Time(10, 30);
        //tạo đối tượng recursion
        Recursion recursion = new Recursion();
// Tạo đối tượng NNcollection
        NNCollection nnCollection = new NNCollection();
        // Tạo đối tượng namenumber
        NameNumber nameNumber = new NameNumber("Alice", 123);
        // In thông tin sách
        System.out.println("Ten sach: " + book.getTen());
        System.out.println("Tac gia: " + book.getTacGia());
        
        // In thông tin thời gian
        System.out.println("Gio: " + time.getGio());
        System.out.println("Phut: " + time.getPhut());

        System.out.println("Factorial of 5: " + recursion.factorial(5));
        nnCollection.addItem("Nhóm14");
        nnCollection.addItem("N03");
        System.out.println("NNCollection items: " + nnCollection.getItems());
        System.out.println("NameNumber: " + nameNumber.getName() + ", " + nameNumber.getNumber());
    }
}
