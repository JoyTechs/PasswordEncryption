package MonkeLogic.methods;

import MonkeLogic.controllers.SceneManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class CreateAccountFrontEnd {

    @FXML
    private Label label1;
    @FXML
    private Label label2;
    @FXML
    private Label label3;
    @FXML
    private Label label4;
    @FXML
    private Button button1;
    @FXML
    private Button button2;
    @FXML
    private TextField textfield1;
    @FXML
    private TextField textField2;
    @FXML
    private CheckBox checkBox1;
    @FXML
    private PasswordField passwordField1;

    private SceneManager sceneManager;



    public void setSceneManager(SceneManager sceneManager) {
        this.sceneManager = sceneManager;
    }



    public void saveAccInfo(ActionEvent event) {
        Connection c = null;
        Statement stmt = null;
        String website = textfield1.getText();
        String username = textField2.getText();
        String password = passwordField1.getText();

        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:MonkeLogic.db");
            c.setAutoCommit(false);
            System.out.println("Opened database successfully");

            stmt = c.createStatement();
            String sql = "INSERT INTO ACCOUNT (WEBSITE, USERNAME, PASSWORD) " +
                    "VALUES ('"+website+"', '"+username+"', '"+password+"');";
            stmt.executeUpdate(sql);

            stmt.close();
            c.commit();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Records created successfully");
    }

}