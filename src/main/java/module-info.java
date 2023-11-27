module com.conorshipsey.colourtableca3 {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.conorshipsey.colourtableca3 to javafx.fxml;
    exports com.conorshipsey.colourtableca3;
}
