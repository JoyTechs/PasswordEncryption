package MonkeLogic.controllers;

import MonkeLogic.services.AdvancedDecrypter;
import MonkeLogic.services.AdvancedEncrypter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CryptKeeper
{
    private static List<String> secretKeys = new ArrayList<>();
    private static List<String> salts = new ArrayList<>();

    public static void init()
    {
        secretKeys.add("9gLHTonoaDF");
        secretKeys.add("BdhF58CX2bS");
        secretKeys.add("5gJrIC0DrcK");

        salts.add("l4SQCfIvvnv");
        salts.add("3coHDPEj9RK");
        salts.add("p8VD9gDmXM7");
    }

    public static String enCrypt(String strToEncrypt)
    {
        Random rng = new Random();
        int keyMax = secretKeys.size();
        int saltsMax = salts.size();

        int rngKey = rng.nextInt(keyMax);
        int rngSalt = rng.nextInt(saltsMax);

        String secretKey = secretKeys.get(rngKey);
        String salt = salts.get(rngSalt);


        return AdvancedEncrypter.encrypt(strToEncrypt, secretKey, salt);
    }

    public static String deCrypt(String strToDecrypt, int usedKey, int usedSalt)
    {
        String secretKey = secretKeys.get(usedKey);
        String salt = salts.get(usedSalt);

        return AdvancedDecrypter.decrypt(strToDecrypt, secretKey, salt);

    }





}