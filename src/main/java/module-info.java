module org.example {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires sqlite.jdbc;
    requires javafx.media;

    opens org.example to javafx.fxml;
    exports org.example;
    exports MonkeLogic;
    opens MonkeLogic to javafx.fxml;
    exports MonkeLogic.methods;
    opens MonkeLogic.methods to javafx.fxml;
    exports MonkeLogic.backEnd;
    opens MonkeLogic.backEnd to javafx.fxml;
    exports MonkeLogic.dbo;
    opens MonkeLogic.dbo to javafx.fxml;
}