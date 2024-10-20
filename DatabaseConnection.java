package com.example.oopcki;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {
    public Connection databaseLink; // Vẫn giữ nguyên không tĩnh

    public static void main(String[] args) {
        DatabaseConnection dbConnection = new DatabaseConnection(); // Tạo đối tượng DatabaseConnection
        dbConnection.connect(); // Gọi phương thức kết nối

        // Có thể kiểm tra kết nối
        if (dbConnection.databaseLink != null) {
            System.out.println("Kết nối thành công!");
        } else {
            System.out.println("Kết nối thất bại!");
        }
    }

    public void connect() { // Tạo phương thức connect
        // Cấu hình thông tin kết nối
        String databaseName = "tenDanngNhap";
        String databaseUser = "tenDanngNhap";
        String databasePassword = "tenDanngNhap";
        String url = "jdbc:mysql://localhost/" + databaseName;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            databaseLink = DriverManager.getConnection(url, databaseUser, databasePassword);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
