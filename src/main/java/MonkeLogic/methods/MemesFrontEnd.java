package MonkeLogic.methods;

import MonkeLogic.controllers.SceneManager;

import java.io.File;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

public class MemesFrontEnd
{

    private SceneManager sceneManager;
    public void setSceneManager(SceneManager sceneManager){this.sceneManager = sceneManager;}

    private List<File> Files = new ArrayList<>();

   public void randomVideo() throws MalformedURLException {
        File mediaFile = new File("MonkeLogic/mp4/1.mp4");

        sceneManager.play(mediaFile);

    }


}
