package MonkeLogic.backEnd;

import MonkeLogic.controllers.SceneManager;

import java.io.File;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

public class MemesBackEnd {

    private final SceneManager sceneManager;
    private static final List<File> files = new ArrayList<>();
    public MemesBackEnd() {
        sceneManager = SceneManager.getInstance();
    }


    public File randomVideo() throws MalformedURLException {
        File mediaFile = new File("src/main/java/MonkeLogic/mp4/1.mp4");

        return mediaFile;

    }

}
