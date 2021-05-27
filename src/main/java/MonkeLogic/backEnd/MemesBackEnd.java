package MonkeLogic.backEnd;

import MonkeLogic.controllers.SceneManager;

import java.io.File;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

public class MemesBackEnd {

    private final SceneManager sceneManager;

    public MemesBackEnd() {
        sceneManager = SceneManager.getInstance();
    }

    private final List<File> Files = new ArrayList<>();

    public File randomVideo() throws MalformedURLException {
        File mediaFile = new File("src/main/java/MonkeLogic/mp4/1.mp4");

        return mediaFile;

    }

}
