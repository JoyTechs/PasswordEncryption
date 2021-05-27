package MonkeLogic.methods;

import MonkeLogic.controllers.SceneManager;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.media.MediaView;

import java.io.File;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

public class MemesFrontEnd {

    @FXML
    private MediaView mediaView;
    @FXML
    private Label label;


    private final SceneManager sceneManager;

    public MemesFrontEnd() {
        sceneManager = SceneManager.getInstance();
    }

    private final List<File> Files = new ArrayList<>();

    public File getMemed() throws MalformedURLException {
        File mediaFile = new File("src/main/java/MonkeLogic/mp4/1.mp4");

        return mediaFile;
    }


}
