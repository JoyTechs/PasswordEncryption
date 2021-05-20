package MonkeLogic.controllers;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

public class FileManager {

    public static ArrayList<File> files = new ArrayList<>();

    public static void init() {
        ArrayList<String> documents = new ArrayList<>(4);
        documents.addAll(Arrays.asList("Users.csv", "Accounts.csv", "Log.csv", "SecQuest.csv"));

        try {
            for (int i = 0; i < documents.size(); i++) {

                File document = new File(documents.get(i));

                if (document.exists()) {
                    System.out.println("A File With That Name Already Exists.");
                } else {
                    document.createNewFile();
                    System.out.println("File Has Been Created.");
                }

                files.add(document);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}