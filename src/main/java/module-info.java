module org.example {
    requires javafx.controls;
    requires javafx.fxml;

    opens org.example to javafx.fxml;
    exports org.example;
    exports MonkeLogic;
    opens MonkeLogic to javafx.fxml;
    exports MonkeLogic.methods;
    opens MonkeLogic.methods to javafx.fxml;
}