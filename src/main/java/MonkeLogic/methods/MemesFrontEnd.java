package MonkeLogic.methods;

import MonkeLogic.controllers.SceneManager;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.media.MediaView;

import java.io.File;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MemesFrontEnd {

    @FXML
    private MediaView mediaView;
    @FXML
    private Label label;


    private final SceneManager sceneManager;
    private static final List<String> files = new ArrayList<>();

    public MemesFrontEnd() {
        sceneManager = SceneManager.getInstance();
        File directoryPath = new File("\\src\\main\\java\\MonkeLogic\\mp4");
        File[] filesList = directoryPath.listFiles();
        for (File file : filesList) {
            files.add(file.getAbsolutePath());
        }
    }

    public File getMemed() throws MalformedURLException {
        Random rng = new Random();
        int maxFileNr = files.size();

        int rngMeme = rng.nextInt(maxFileNr);

        String pathDirectory = files.get(rngMeme);

        File mediaFile = new File(pathDirectory);

        return mediaFile;
    }
}
