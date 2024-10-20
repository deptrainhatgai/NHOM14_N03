package com.example.oopcki;

import java.util.Optional;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

public class MainApp extends Application {
    private QuanLyHeThong quanLyHeThong = new QuanLyHeThong();
    private Stage window;
    private SinhVien sinhVien;

    @Override
    public void start(Stage primaryStage) {
        window = primaryStage;
        window.setTitle("Quản lý môn học");

        showLoginScreen();
    }

    private void showLoginScreen() {
        Label titleLabel = new Label("Đăng Nhập Hệ Thống");
        titleLabel.setFont(new Font("Arial", 24));
        titleLabel.setTextFill(Color.DARKBLUE);

        Label userLabel = new Label("Tên đăng nhập:");
        userLabel.setFont(new Font("Arial", 14));
        TextField usernameInput = new TextField();
        usernameInput.setPromptText("Nhập tên đăng nhập");
        usernameInput.setMaxWidth(250);

        Label passwordLabel = new Label("Mật khẩu:");
        passwordLabel.setFont(new Font("Arial", 14));
        PasswordField passwordInput = new PasswordField();
        passwordInput.setPromptText("Nhập mật khẩu");
        passwordInput.setMaxWidth(250);

        Button loginButton = new Button("Đăng nhập");
        loginButton.setFont(new Font("Arial", 16));
        loginButton.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white;");
        loginButton.setMaxWidth(250);

        Label messageLabel = new Label();
        messageLabel.setTextFill(Color.RED);

        loginButton.setOnAction(e -> {
            String username = usernameInput.getText();
            String password = passwordInput.getText();

            if (username.equals("admin") && password.equals("1234")) {
                sinhVien = new SinhVien("123456", "Nguyen Van A", "Nam", "2020-2024", "Ha Noi", "01/01/2000", "Khoa CNTT", "0123456789", "nguyenvana@example.com");
                showMainScreen();
            } else {
                messageLabel.setText("Tên đăng nhập hoặc mật khẩu không đúng!");
            }
        });

        VBox loginLayout = new VBox(10);
        loginLayout.setAlignment(Pos.CENTER);
        loginLayout.setPadding(new Insets(20));
        loginLayout.setStyle("-fx-background-color: #f0f8ff; -fx-border-radius: 10; -fx-background-radius: 10;");
        loginLayout.getChildren().addAll(titleLabel, userLabel, usernameInput, passwordLabel, passwordInput, loginButton, messageLabel);

        Scene loginScene = new Scene(loginLayout, 400, 400);
        window.setScene(loginScene);
        window.show();
    }


    private void showMainScreen() {
        Label welcomeLabel = new Label("Quản lý đăng kí môn học cho sinh viên");
        welcomeLabel.setFont(Font.font("Arial", FontWeight.BOLD, 25)); 

        Button studentButton = new Button("Sinh viên");
        studentButton.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        studentButton.setPrefWidth(200); 
        studentButton.setOnAction(e -> showStudentInfoTable()); 

        VBox vbox = new VBox(10, welcomeLabel, studentButton); 
        vbox.setAlignment(Pos.CENTER);
        vbox.setPadding(new Insets(20));

        // Tạo các nút
        Button btnViewCourses = new Button("Xem môn học");
        btnViewCourses.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        Button btnRegisterCourse = new Button("Đăng ký môn học");
        btnRegisterCourse.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        Button btnCancelCourse = new Button("Hủy đăng ký môn học");
        btnCancelCourse.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        Button btnLogout = new Button("Đăng xuất");
        btnLogout.setFont(Font.font("Arial", FontWeight.BOLD, 14));

        double buttonWidth = 200;
        btnViewCourses.setPrefWidth(buttonWidth);
        btnRegisterCourse.setPrefWidth(buttonWidth);
        btnCancelCourse.setPrefWidth(buttonWidth);
        btnLogout.setPrefWidth(buttonWidth);

        vbox.getChildren().addAll(btnViewCourses, btnRegisterCourse, btnCancelCourse, btnLogout);

        btnLogout.setOnAction(e -> showLogoutConfirmation());
        btnViewCourses.setOnAction(e -> viewCourses());
        btnRegisterCourse.setOnAction(e -> registerToCourse());
        btnCancelCourse.setOnAction(e -> cancelCourse());

        Scene mainScene = new Scene(vbox, 800, 600);
        window.setScene(mainScene);
        window.show();
    }

    private void showLogoutConfirmation() {
        Alert alert = new Alert(Alert.AlertType.NONE);
        alert.setTitle("Xác nhận đăng xuất");

        VBox dialogPaneContent = new VBox();
        dialogPaneContent.setAlignment(Pos.CENTER);
        dialogPaneContent.setSpacing(10);

        Label headerLabel = new Label("Bạn có chắc muốn đăng xuất không?");
        headerLabel.setFont(Font.font("Arial", FontWeight.BOLD, 14)); 
        dialogPaneContent.getChildren().add(headerLabel);
        alert.getDialogPane().setContent(dialogPaneContent);

        ButtonType yesButton = new ButtonType("Có");
        ButtonType noButton = new ButtonType("Không");
        alert.getButtonTypes().setAll(yesButton, noButton);

        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == yesButton) {
            showLoginScreen(); 
        }
    }


    private void showStudentInfoTable() {
        TableView<SinhVien> tableView = new TableView<>();

        TableColumn<SinhVien, String> maSVColumn = new TableColumn<>("Mã SV");
        maSVColumn.setCellValueFactory(new PropertyValueFactory<>("maSV"));

        TableColumn<SinhVien, String> tenSVColumn = new TableColumn<>("Tên SV");
        tenSVColumn.setCellValueFactory(new PropertyValueFactory<>("tenSV"));

        TableColumn<SinhVien, String> gioiTinhColumn = new TableColumn<>("Giới tính");
        gioiTinhColumn.setCellValueFactory(new PropertyValueFactory<>("gioiTinh"));

        TableColumn<SinhVien, String> khoaHocColumn = new TableColumn<>("Khóa học");
        khoaHocColumn.setCellValueFactory(new PropertyValueFactory<>("khoaHoc"));

        TableColumn<SinhVien, String> queQuanColumn = new TableColumn<>("Quê quán");
        queQuanColumn.setCellValueFactory(new PropertyValueFactory<>("queQuan"));

        TableColumn<SinhVien, String> ngaySinhColumn = new TableColumn<>("Ngày sinh");
        ngaySinhColumn.setCellValueFactory(new PropertyValueFactory<>("ngaySinh"));

        TableColumn<SinhVien, String> lopColumn = new TableColumn<>("Lớp");
        lopColumn.setCellValueFactory(new PropertyValueFactory<>("lop"));

        TableColumn<SinhVien, String> sdtColumn = new TableColumn<>("SĐT");
        sdtColumn.setCellValueFactory(new PropertyValueFactory<>("sdt"));

        TableColumn<SinhVien, String> emailColumn = new TableColumn<>("Email");
        emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));

        tableView.getColumns().addAll(maSVColumn, tenSVColumn, gioiTinhColumn, khoaHocColumn, queQuanColumn, ngaySinhColumn, lopColumn, sdtColumn, emailColumn);

        for (SinhVien sv : quanLyHeThong.getDanhSachSinhVien()) {
            tableView.getItems().add(sv);
        }
        Label studentLabel = new Label("Sinh viên");
        studentLabel.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        studentLabel.setPadding(new Insets(10, 0, 10, 0));
        studentLabel.setAlignment(Pos.CENTER);

        Button btnAddStudent = new Button("Thêm sinh viên");
        Button btnDeleteStudent = new Button("Xóa sinh viên");

        btnAddStudent.setOnAction(e -> showAddStudentDialog(tableView));
        btnDeleteStudent.setOnAction(e -> {
            SinhVien selectedStudent = tableView.getSelectionModel().getSelectedItem();
            if (selectedStudent != null) {
                quanLyHeThong.xoaSinhVien(selectedStudent.getMaSV());
                tableView.getItems().remove(selectedStudent);
            } else {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Cảnh báo");
                alert.setHeaderText(null);
                alert.setContentText("Vui lòng chọn một sinh viên để xóa!");
                alert.showAndWait();
            }
        });

        Button backButton = new Button("Quay lại");
        backButton.setFont(new Font("Arial", 16));
        backButton.setStyle("-fx-background-color: #f44336; -fx-text-fill: white;");
        backButton.setOnAction(e -> showMainScreen());

        HBox buttonLayout = new HBox(10, btnAddStudent, btnDeleteStudent, backButton);
        buttonLayout.setAlignment(Pos.CENTER);

        VBox vbox = new VBox(10, studentLabel,tableView, buttonLayout);
        vbox.setAlignment(Pos.CENTER);
        vbox.setPadding(new Insets(20));
        
        
        Scene scene = new Scene(vbox, 800, 600);
        window.setScene(scene);
        window.show();
    }
    private void viewCourses() {
        TableView<MonHoc> courseTable = new TableView<>();

        TableColumn<MonHoc, String> maMHColumn = new TableColumn<>("Mã môn học");
        maMHColumn.setCellValueFactory(new PropertyValueFactory<>("maMH"));
        maMHColumn.setPrefWidth(120); 

        TableColumn<MonHoc, String> tenMHColumn = new TableColumn<>("Tên môn học");
        tenMHColumn.setCellValueFactory(new PropertyValueFactory<>("tenMH"));
        tenMHColumn.setPrefWidth(200); 

        TableColumn<MonHoc, String> giangVienColumn = new TableColumn<>("Tên giảng viên");
        giangVienColumn.setCellValueFactory(new PropertyValueFactory<>("tenGiangVien"));
        giangVienColumn.setPrefWidth(150); 

        TableColumn<MonHoc, String> tenLopColumn = new TableColumn<>("Tên lớp");
        tenLopColumn.setCellValueFactory(new PropertyValueFactory<>("tenLop"));
        tenLopColumn.setPrefWidth(150); 

        TableColumn<MonHoc, Integer> soTinChiColumn = new TableColumn<>("Số tín chỉ");
        soTinChiColumn.setCellValueFactory(new PropertyValueFactory<>("soTinChi"));
        soTinChiColumn.setPrefWidth(100); 

        TableColumn<MonHoc, Double> soTienColumn = new TableColumn<>("Giá tiền");
        soTienColumn.setCellValueFactory(new PropertyValueFactory<>("soTien"));
        soTienColumn.setPrefWidth(100); 

        courseTable.getColumns().addAll(maMHColumn, tenMHColumn, giangVienColumn, tenLopColumn, soTinChiColumn, soTienColumn);
        courseTable.setItems(FXCollections.observableArrayList(quanLyHeThong.getDanhSachMonHoc()));

        Label titleLabel = new Label("Môn Học");
        titleLabel.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        titleLabel.setPadding(new Insets(10, 0, 10, 0));
        titleLabel.setAlignment(Pos.CENTER);

        Button btnAddCourse = new Button("Thêm môn học");
        btnAddCourse.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        Button btnDeleteCourse = new Button("Xóa môn học");
        btnDeleteCourse.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        Button btnBackButton = new Button("Quay lại");
        btnBackButton.setFont(Font.font("Arial", FontWeight.BOLD, 14));

        btnAddCourse.setOnAction(e -> showAddCourseDialog(courseTable));
        btnDeleteCourse.setOnAction(e -> {
            MonHoc selectedCourse = courseTable.getSelectionModel().getSelectedItem();
            if (selectedCourse != null) {
                Alert confirmationAlert = new Alert(Alert.AlertType.CONFIRMATION, "Bạn có chắc chắn muốn xóa môn học này?");
                confirmationAlert.setHeaderText(null); 
                confirmationAlert.setGraphic(null); 

                Optional<ButtonType> result = confirmationAlert.showAndWait();
                if (result.isPresent() && result.get() == ButtonType.OK) {
                    courseTable.getItems().remove(selectedCourse);
                }
            } else {
                Alert alert = new Alert(Alert.AlertType.WARNING, "Vui lòng chọn một môn học để xóa.");
                alert.setHeaderText(null); 
                alert.setGraphic(null); 
                alert.showAndWait();
            }
        });



        btnBackButton.setOnAction(e -> showMainScreen());

        HBox buttonLayout = new HBox(10, btnAddCourse, btnDeleteCourse, btnBackButton);
        buttonLayout.setAlignment(Pos.CENTER);

        VBox vbox = new VBox(10, titleLabel,courseTable, buttonLayout);
        vbox.setAlignment(Pos.CENTER);
        vbox.setPadding(new Insets(20));

        Scene scene = new Scene(vbox, 800, 600);
        window.setScene(scene);
        window.show();
    }

    

    private void showAddStudentDialog(TableView<SinhVien> tableView) {
        Stage dialog = new Stage();
        dialog.setTitle("Thêm sinh viên mới");

        TextField maSVInput = new TextField();
        maSVInput.setPromptText("Mã SV");

        TextField tenSVInput = new TextField();
        tenSVInput.setPromptText("Tên SV");

        TextField gioiTinhInput = new TextField();
        gioiTinhInput.setPromptText("Giới tính");

        TextField khoaHocInput = new TextField();
        khoaHocInput.setPromptText("Khóa học");

        TextField queQuanInput = new TextField();
        queQuanInput.setPromptText("Quê quán");

        TextField ngaySinhInput = new TextField();
        ngaySinhInput.setPromptText("Ngày sinh");

        TextField lopInput = new TextField();
        lopInput.setPromptText("Lớp");

        TextField sdtInput = new TextField();
        sdtInput.setPromptText("Số điện thoại");

        TextField emailInput = new TextField();
        emailInput.setPromptText("Email");

        Button saveButton = new Button("Lưu");

        saveButton.setOnAction(e -> {
            String maSV = maSVInput.getText();
            String tenSV = tenSVInput.getText();
            String gioiTinh = gioiTinhInput.getText();
            String khoaHoc = khoaHocInput.getText();
            String queQuan = queQuanInput.getText();
            String ngaySinh = ngaySinhInput.getText();
            String lop = lopInput.getText();
            String sdt = sdtInput.getText();
            String email = emailInput.getText();

            if (!maSV.isEmpty() && !tenSV.isEmpty()) {
                SinhVien newStudent = new SinhVien(maSV, tenSV, gioiTinh, khoaHoc, queQuan, ngaySinh, lop, sdt, email);
                quanLyHeThong.themSinhVien(newStudent);
                tableView.getItems().add(newStudent);
                dialog.close();  
            }
        });

        VBox dialogLayout = new VBox(10, maSVInput, tenSVInput, gioiTinhInput, khoaHocInput, queQuanInput, ngaySinhInput, lopInput, sdtInput, emailInput, saveButton);
        dialogLayout.setAlignment(Pos.CENTER);
        dialogLayout.setPadding(new Insets(20));

        Scene dialogScene = new Scene(dialogLayout, 400, 500);
        dialog.setScene(dialogScene);
        dialog.show();
    }

    private void showAddCourseDialog(TableView<MonHoc> courseTable) {
        Stage dialog = new Stage();
        dialog.setTitle("Thêm môn học mới");

        TextField maMHInput = new TextField();
        maMHInput.setPromptText("Mã môn học");
        maMHInput.setFont(Font.font("Arial", FontWeight.BOLD, 12));

        TextField tenMHInput = new TextField();
        tenMHInput.setPromptText("Tên môn học");

        TextField tenGiangVienInput = new TextField();
        tenGiangVienInput.setPromptText("Tên giảng viên");

        TextField tenLopInput = new TextField();
        tenLopInput.setPromptText("Tên lớp");

        TextField soTinChiInput = new TextField();
        soTinChiInput.setPromptText("Số tín chỉ");

        TextField maxSoSinhVienInput = new TextField();
        maxSoSinhVienInput.setPromptText("Max số sinh viên");

        TextField soTienInput = new TextField();
        soTienInput.setPromptText("Giá tiền");

        Button saveButton = new Button("Lưu");

        saveButton.setOnAction(e -> {
            String maMH = maMHInput.getText();
            String tenMH = tenMHInput.getText();
            String tenGiangVien = tenGiangVienInput.getText();
            String tenLop = tenLopInput.getText();

            if (maMH.isEmpty() || tenMH.isEmpty() || tenGiangVien.isEmpty() || tenLop.isEmpty() ||
                    soTinChiInput.getText().isEmpty() || maxSoSinhVienInput.getText().isEmpty() || soTienInput.getText().isEmpty()) {
                showAlert("Lỗi", "Vui lòng điền đầy đủ thông tin môn học!");
                return; 
            }

            try {
                int soTinChi = Integer.parseInt(soTinChiInput.getText());
                int maxSoSinhVien = Integer.parseInt(maxSoSinhVienInput.getText());
                double soTien = Double.parseDouble(soTienInput.getText());

                MonHoc newCourse = new MonHoc(maMH, tenMH, tenGiangVien, tenLop, soTinChi, maxSoSinhVien, soTien);
                quanLyHeThong.themMonHoc(newCourse);
                courseTable.getItems().add(newCourse);
                dialog.close(); 

            } catch (NumberFormatException ex) {
                showAlert("Lỗi", "Số tín chỉ, Max số sinh viên và Giá tiền phải là một số hợp lệ!");
            }
        });

        VBox dialogLayout = new VBox(10, maMHInput, tenMHInput, tenGiangVienInput, tenLopInput, soTinChiInput, maxSoSinhVienInput, soTienInput, saveButton);
        dialogLayout.setAlignment(Pos.CENTER);
        dialogLayout.setPadding(new Insets(20));

        Scene dialogScene = new Scene(dialogLayout, 400, 500);
        dialog.setScene(dialogScene);
        dialog.show();
    }


    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private void registerToCourse() {
        Stage dialog = new Stage();
        dialog.setTitle("Đăng ký môn học");
        
        VBox mainLayout = new VBox(10);
        mainLayout.setPadding(new Insets(20));
        mainLayout.setAlignment(Pos.CENTER);
        
        Label titleLabel = new Label("Chọn các môn học để đăng ký:");
        titleLabel.setFont(new Font("Arial", 18));
        mainLayout.getChildren().add(titleLabel);
        
        TilePane layout = new TilePane();
        layout.setPadding(new Insets(10));
        layout.setAlignment(Pos.CENTER);
        layout.setHgap(10);
        layout.setVgap(10);
        layout.setPrefColumns(3);
    
        for (MonHoc monHoc : quanLyHeThong.getDanhSachMonHoc()) {
            VBox vbox = new VBox();
            vbox.setStyle("-fx-border-color: gray; -fx-border-width: 1; -fx-padding: 10; -fx-pref-width: 200; -fx-pref-height: 150;");
            
            
            CheckBox checkBox = new CheckBox(monHoc.getTenMH());
            checkBox.setUserData(monHoc);
            checkBox.setFont(Font.font("Arial", FontWeight.BOLD, 14));
            
            Label tinChiLabel = new Label("Số tín chỉ: " + monHoc.getSoTinChi());
            Label soTienLabel = new Label("Số tiền: " + monHoc.getSoTien() + " VNĐ");
            Label tenLopLabel = new Label("Tên lớp: " + monHoc.getTenLop());
            Label soLuongLabel = new Label("Số lượng: " + monHoc.getSoLuongSV() + "/" + monHoc.getMaxSoSinhVien());
            
            vbox.getChildren().addAll(checkBox, tinChiLabel, soTienLabel, tenLopLabel,soLuongLabel);
            layout.getChildren().add(vbox);
            
        }
    
        ScrollPane scrollPane = new ScrollPane(layout);
        scrollPane.setFitToWidth(true); 
        scrollPane.setPrefHeight(300); 
    
    mainLayout.getChildren().add(scrollPane);
        
        Button registerButton = new Button("Xác nhận đăng ký");
        registerButton.setFont(Font.font("Arial", FontWeight.BOLD, 14)); 
        registerButton.setOnAction(e -> {
            boolean isRegistered = false;
    
            for (javafx.scene.Node node : layout.getChildren()) {
                if (node instanceof VBox) {
                    VBox vbox = (VBox) node;
                    CheckBox checkBox = (CheckBox) vbox.getChildren().get(0);
                    if (checkBox.isSelected()) {
                        MonHoc selectedMonHoc = (MonHoc) checkBox.getUserData();
                        
                        if (sinhVien.getDanhSachMonHocDaDangKy().contains(selectedMonHoc.getMaMH())) {
                            showAlert("Thông báo", "Bạn đã đăng ký môn " + selectedMonHoc.getTenMH() + " rồi!");
                            return; 
                        }

                        if (selectedMonHoc.getSoLuongSV() < selectedMonHoc.getMaxSoSinhVien()) {
                            quanLyHeThong.dangKyMonHoc(sinhVien.getMaSV(), selectedMonHoc.getMaMH());
                            sinhVien.themMonHoc(selectedMonHoc.getMaMH()); 
                            selectedMonHoc.setSoLuongSV(selectedMonHoc.getSoLuongSV() + 1); 
                            isRegistered = true;
                        } else {
                            showAlert("Thông báo", "Không thể đăng ký môn " + selectedMonHoc.getTenMH() + " vì đã đủ số lượng sinh viên!");
                        }
                    }
                }
            }
    
            if (isRegistered) {
                showAlert("Thành công", "Đăng ký môn học thành công!");
            } else {
                showAlert("Thông báo", "Vui lòng chọn ít nhất một môn học để đăng ký!");
            }
    
            dialog.close();
        });
      
        Button backButton = new Button("Quay lại");
        backButton.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        backButton.setOnAction(e -> dialog.close()); 

        HBox buttonLayout = new HBox(10, registerButton, backButton);
        buttonLayout.setAlignment(Pos.CENTER); 
        mainLayout.getChildren().add(buttonLayout); 

        Scene scene = new Scene(mainLayout, 600, 400);
        dialog.setScene(scene);
        dialog.show();
    }
    
    
    private void cancelCourse() {
        Stage dialog = new Stage();
        dialog.setTitle("Hủy đăng ký môn học");
    
        VBox mainLayout = new VBox(10);
        mainLayout.setPadding(new Insets(20));
        mainLayout.setAlignment(Pos.CENTER);
    
       
        Label titleLabel = new Label("Chọn các môn học để hủy đăng ký:");
        titleLabel.setFont(new Font("Arial", 18));
        mainLayout.getChildren().add(titleLabel); 
    
        TilePane layout = new TilePane();
        layout.setPadding(new Insets(10));
        layout.setAlignment(Pos.CENTER);
        layout.setHgap(10); 
        layout.setVgap(10);
        layout.setPrefColumns(3); 
    
        for (String maMH : sinhVien.getDanhSachMonHocDaDangKy()) {
            MonHoc monHoc = quanLyHeThong.getMonHoc(maMH); 
            if (monHoc != null) {
                VBox vbox = new VBox();
                vbox.setStyle("-fx-border-color: gray; -fx-border-width: 1; -fx-padding: 10; -fx-pref-width: 200; -fx-pref-height: 150;"); // Thêm kiểu dáng cho khung
    
                CheckBox checkBox = new CheckBox(monHoc.getTenMH());
                checkBox.setUserData(monHoc);  
               
                checkBox.setUserData(monHoc);
                checkBox.setFont(Font.font("Arial", FontWeight.BOLD, 14));
    
                Label tinChiLabel = new Label("Số tín chỉ: " + monHoc.getSoTinChi());
                Label soTienLabel = new Label("Số tiền: " + monHoc.getSoTien() + " VNĐ");
                Label tenLopLabel = new Label("Tên lớp: " + monHoc.getTenLop());
                Label soLuongLabel = new Label("Số lượng: " + monHoc.getSoLuongSV() + "/" + monHoc.getMaxSoSinhVien());
    
                vbox.getChildren().addAll(checkBox, tinChiLabel, soTienLabel, tenLopLabel, soLuongLabel);
                layout.getChildren().add(vbox); 
            }
        }
    
        ScrollPane scrollPane = new ScrollPane(layout);
        scrollPane.setFitToWidth(true); 
        scrollPane.setPrefHeight(300); 
        mainLayout.getChildren().add(scrollPane); 
    
        Button cancelButton = new Button("Xác nhận hủy đăng ký");
        cancelButton.setFont(Font.font("Arial", FontWeight.BOLD, 14)); 
        cancelButton.setOnAction(e -> {
            boolean isCanceled = false; 
    
            for (javafx.scene.Node node : layout.getChildren()) {
                if (node instanceof VBox) {
                    VBox vbox = (VBox) node;
                    CheckBox checkBox = (CheckBox) vbox.getChildren().get(0);
                    if (checkBox.isSelected()) {
                        MonHoc selectedMonHoc = (MonHoc) checkBox.getUserData();
                        quanLyHeThong.huyDangKyMonHoc(sinhVien.getMaSV(), selectedMonHoc.getMaMH()); 
                        sinhVien.huyMonHoc(selectedMonHoc.getMaMH()); 
                        isCanceled = true; 
                    }
                }
            }
    
            if (isCanceled) {
                showAlert("Thông báo", "Hủy đăng ký môn học thành công!");
            } else {
                showAlert("Thông báo", "Vui lòng chọn ít nhất một môn học để hủy!");
            }
    
            dialog.close();  
        });
        
        Button backButton = new Button("Quay lại");
        backButton.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        backButton.setOnAction(e -> dialog.close()); 
    
        HBox buttonLayout = new HBox(10, cancelButton, backButton);
        buttonLayout.setAlignment(Pos.CENTER); 
        mainLayout.getChildren().add(buttonLayout); 

        Scene scene = new Scene(mainLayout, 600, 400); 
        dialog.setScene(scene);
        dialog.show();
    }
    
    
    

    public static void main(String[] args) {
        launch(args);
    }
}
