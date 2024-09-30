package com.example.oopcki;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.List;

public class MainApp extends Application {
    private QuanLyHeThong quanLyHeThong = new QuanLyHeThong();
    private Stage window;

    @Override
    public void start(Stage primaryStage) {
        window = primaryStage;
        window.setTitle("Quản lý sinh viên");

        // Khởi tạo dữ liệu mẫu
        initData();

        // Hiển thị màn hình đăng nhập
        showLoginScreen();
    }

    private void initData() {
        // Thêm một số môn học
        quanLyHeThong.themMonHoc(new MonHoc("001", "Lập Trình C", 3));
        quanLyHeThong.themMonHoc(new MonHoc("002", "Cấu Trúc Dữ Liệu", 4));
        quanLyHeThong.themMonHoc(new MonHoc("003", "Giải Thuật", 3));
        quanLyHeThong.themMonHoc(new MonHoc("004", "Giải Tích", 3));
        quanLyHeThong.themMonHoc(new MonHoc("005", "Lập Trình Hướng Đối Tượng", 5));



        // Thêm một sinh viên mẫu
        SinhVien sv1 = new SinhVien("SV001", "Nguyễn Văn A", "Nam", "CNTT", "Hà Nội", "01/01/2000", "Lớp 12");
        quanLyHeThong.themSinhVien(sv1);
    }

    private void showLoginScreen() {
        Label titleLabel = new Label("Đăng Nhập Hệ Thống");
        titleLabel.setFont(new Font("Arial", 24));
        titleLabel.setTextFill(Color.DARKBLUE);

        Label userLabel = new Label("Tên đăng nhập:");
        TextField usernameInput = new TextField();
        usernameInput.setPromptText("Nhập tên đăng nhập");
        usernameInput.setMaxWidth(250);

        Label passwordLabel = new Label("Mật khẩu:");
        PasswordField passwordInput = new PasswordField();
        passwordInput.setPromptText("Nhập mật khẩu");
        passwordInput.setMaxWidth(250);

        Button loginButton = new Button("Đăng nhập");
        Label messageLabel = new Label();
        messageLabel.setTextFill(Color.RED);

        loginButton.setOnAction(e -> {
            String username = usernameInput.getText();
            String password = passwordInput.getText();
            if (username.equals("admin") && password.equals("1234")) {
                showMainScreen();
            } else {
                messageLabel.setText("Tên đăng nhập hoặc mật khẩu không đúng!");
            }
        });

        VBox loginLayout = new VBox(10);
        loginLayout.setAlignment(Pos.CENTER);
        loginLayout.setPadding(new Insets(20));
        loginLayout.getChildren().addAll(titleLabel, userLabel, usernameInput, passwordLabel, passwordInput, loginButton, messageLabel);

        Scene loginScene = new Scene(loginLayout, 400, 400);
        window.setScene(loginScene);
        window.show();
    }

    private void showMainScreen() {
        Label welcomeLabel = new Label("Chào mừng đến với hệ thống quản lý sinh viên");
        welcomeLabel.setFont(new Font("Arial", 20));

        Button btnInfo = new Button("Thông tin sinh viên");
        Button btnManageSubjects = new Button("Quản lý môn học");
        Button btnLogout = new Button("Đăng xuất");

        btnInfo.setOnAction(e -> showStudentInfo());
        btnManageSubjects.setOnAction(e -> showManageSubjects());
        btnLogout.setOnAction(e -> showLoginScreen());

        VBox mainLayout = new VBox(20);
        mainLayout.setAlignment(Pos.CENTER);
        mainLayout.setPadding(new Insets(20));
        mainLayout.getChildren().addAll(welcomeLabel, btnInfo, btnManageSubjects, btnLogout);

        Scene mainScene = new Scene(mainLayout, 400, 400);
        window.setScene(mainScene);
        window.show();
    }

    private void showStudentInfo() {
        SinhVien sv = quanLyHeThong.getSinhVien("SV001"); // Giả sử "SV001" là mã sinh viên

        VBox studentInfoLayout = new VBox(10);
        studentInfoLayout.setAlignment(Pos.CENTER);
        studentInfoLayout.setPadding(new Insets(20));
        studentInfoLayout.setStyle("-fx-background-color: #f0f8ff;");

        Label titleLabel = new Label("Thông tin sinh viên");
        titleLabel.setFont(new Font("Arial", 24));

        Label maSVLabel = new Label("Mã SV: " + sv.getMaSV());
        Label tenSVLabel = new Label("Tên: " + sv.getTenSV());
        Label gioiTinhLabel = new Label("Giới tính: " + sv.getGioiTinh());
        Label khoaLabel = new Label("Khóa học: " + sv.getKhoa());
        Label queQuanLabel = new Label("Quê quán: " + sv.getQueQuan());
        Label ngaySinhLabel = new Label("Ngày sinh: " + sv.getNgaySinh());
        Label lopLabel = new Label("Lớp: " + sv.getLop());

        Button backButton = new Button("Quay lại");
        backButton.setOnAction(e -> showMainScreen());

        studentInfoLayout.getChildren().addAll(titleLabel, maSVLabel, tenSVLabel, gioiTinhLabel, khoaLabel, queQuanLabel, ngaySinhLabel, lopLabel, backButton);
        Scene studentInfoScene = new Scene(studentInfoLayout, 400, 400);
        window.setScene(studentInfoScene);
        window.show();
    }

    private void showManageSubjects() {
        Label subjectLabel = new Label("Quản lý môn học");
        subjectLabel.setFont(new Font("Arial", 24));

        Button viewSubjectsButton = new Button("Xem môn học");
        Button registerButton = new Button("Đăng ký môn học");
        Button viewRegisteredButton = new Button("Xem môn đã đăng ký");
        Button unregisterButton = new Button("Hủy môn học");
        Button backButton = new Button("Quay lại");

        viewSubjectsButton.setOnAction(e -> showSubjects());
        registerButton.setOnAction(e -> showRegisterSubject());
        viewRegisteredButton.setOnAction(e -> showRegisteredSubjects());
        unregisterButton.setOnAction(e -> showUnregisterSubject());
        backButton.setOnAction(e -> showMainScreen());

        VBox manageLayout = new VBox(20);
        manageLayout.setAlignment(Pos.CENTER);
        manageLayout.setPadding(new Insets(20));
        manageLayout.getChildren().addAll(subjectLabel, viewSubjectsButton, registerButton, viewRegisteredButton, unregisterButton, backButton);

        Scene manageScene = new Scene(manageLayout, 400, 400);
        window.setScene(manageScene);
        window.show();
    }

    private void showSubjects() {
        StringBuilder subjects = new StringBuilder("Danh sách môn học:\n");
        for (MonHoc monHoc : quanLyHeThong.getMonHocs().values()) {
            subjects.append("Mã môn: ").append(monHoc.getMaMonHoc())
                    .append(", Tên môn: ").append(monHoc.getTenMonHoc())
                    .append(", Số tín chỉ: ").append(monHoc.getSoTinChi()).append("\n");
        }
        showAlert(subjects.toString());
    }

    private void showRegisterSubject() {
        Label registerLabel = new Label("Đăng ký môn học");
        registerLabel.setFont(new Font("Arial", 24));

        TextField subjectCodeInput = new TextField();
        subjectCodeInput.setPromptText("Nhập mã môn để đăng ký");

        Button confirmButton = new Button("Xác nhận");
        Button backButton = new Button("Quay lại");

        confirmButton.setOnAction(e -> {
            String maMon = subjectCodeInput.getText();
            if (quanLyHeThong.getMonHoc(maMon) == null) {
                showAlert("Mã môn không hợp lệ!");
            } else if (quanLyHeThong.isRegistered("SV001", maMon)) {
                showAlert("Bạn đã đăng ký môn này rồi!");
            } else {
                quanLyHeThong.dangKyMonHoc("SV001", maMon);
                showAlert("Đăng ký môn học thành công!");
            }
        });

        backButton.setOnAction(e -> showManageSubjects());

        VBox registerLayout = new VBox(20);
        registerLayout.setAlignment(Pos.CENTER);
        registerLayout.setPadding(new Insets(20));
        registerLayout.setStyle("-fx-background-color: #f0f8ff;");
        registerLayout.getChildren().addAll(registerLabel, subjectCodeInput, confirmButton, backButton);

        Scene registerScene = new Scene(registerLayout, 400, 400);
        window.setScene(registerScene);
        window.show();
    }

    private void showRegisteredSubjects() {
        StringBuilder registeredSubjects = new StringBuilder("Môn đã đăng ký:\n");
        List<MonHoc> registered = quanLyHeThong.getRegisteredSubjects("SV001");
        if (registered.isEmpty()) {
            registeredSubjects.append("Bạn chưa đăng ký môn nào.");
        } else {
            for (MonHoc monHoc : registered) {
                registeredSubjects.append("Mã môn: ").append(monHoc.getMaMonHoc())
                        .append(", Tên môn: ").append(monHoc.getTenMonHoc())
                        .append(", Số tín chỉ: ").append(monHoc.getSoTinChi()).append("\n");
            }
        }
        showAlert(registeredSubjects.toString());
    }

    private void showUnregisterSubject() {
        Label unregisterLabel = new Label("Hủy đăng ký môn học");
        unregisterLabel.setFont(new Font("Arial", 24));

        TextField subjectCodeInput = new TextField();
        subjectCodeInput.setPromptText("Nhập mã môn để hủy");

        Button confirmButton = new Button("Xác nhận");
        Button backButton = new Button("Quay lại");

        confirmButton.setOnAction(e -> {
            String maMon = subjectCodeInput.getText();
            if (!quanLyHeThong.isRegistered("SV001", maMon)) {
                showAlert("Bạn chưa đăng ký môn học này!");
            } else {
                quanLyHeThong.huyDangKyMonHoc("SV001", maMon);
                showAlert("Hủy đăng ký môn học thành công!");
            }
        });

        backButton.setOnAction(e -> showManageSubjects());

        VBox unregisterLayout = new VBox(20);
        unregisterLayout.setAlignment(Pos.CENTER);
        unregisterLayout.setPadding(new Insets(20));
        unregisterLayout.setStyle("-fx-background-color: #f0f8ff;");
        unregisterLayout.getChildren().addAll(unregisterLabel, subjectCodeInput, confirmButton, backButton);

        Scene unregisterScene = new Scene(unregisterLayout, 400, 400);
        window.setScene(unregisterScene);
        window.show();
    }

    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Thông báo");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
