module com.example.oopcki {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.oopcki to javafx.fxml;
    exports com.example.oopcki;
}