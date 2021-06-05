package MonkeLogic.controllers;

import MonkeLogic.databasemethods.ReadFromDB;
import MonkeLogic.dto.SaltAndKey;
import MonkeLogic.dto.UserEncryption;
import MonkeLogic.encryption.AdvancedDecrypter;
import MonkeLogic.encryption.AdvancedEncrypter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CryptKeeper {
    //region Lists Containing the Keys and Salts for Crypto
    private static final List<String> secretKeys = new ArrayList<>();
    private static final List<String> salts = new ArrayList<>();
    private static int usedKey;
    private static int usedSalt;

    //endregion

    //region Singleton
    private static CryptKeeper cryptKeeper;

    private CryptKeeper() {
        init();
    }

    public static CryptKeeper getInstance() {
        if (cryptKeeper == null) {
            cryptKeeper = new CryptKeeper();
        }
        return cryptKeeper;
    }
    //endregion

    //region This Adds Keys and Salts to the above Lists
    private static void init() {
        secretKeys.add("9gLHTonoaDF");
        secretKeys.add("BdhF58CX2bS");
        secretKeys.add("5gJrIC0DrcK");
        salts.add("l4SQCfIvvnv");
        salts.add("3coHDPEj9RK");
        salts.add("p8VD9gDmXM7");
    }
    //endregion

    //region This Paragraph randomizes Key and Salt for the Encryption
    public static String initEncrypt(String strToEncrypt) {
        Random rng = new Random();
        int keyMax = secretKeys.size();
        int saltsMax = salts.size();

        int rngKey = rng.nextInt(keyMax);
        int rngSalt = rng.nextInt(saltsMax);

        String secretKey = secretKeys.get(rngKey);
        String salt = salts.get(rngSalt);

        UserEncryption.getInstance().setSecretKey(rngKey);
        UserEncryption.getInstance().setSalt(rngSalt);

        return AdvancedEncrypter.encrypt(strToEncrypt, secretKey, salt);
    }
    //endregion

    //region This Paragraph fetches the Key and Salt used for the encrypted String
    public static String deCrypt(String strToDecrypt, int userID) {

        SaltAndKey saltAndKey = ReadFromDB.getSaltsAndKeys(userID);

        String secretKey = secretKeys.get(saltAndKey.getKey());
        String salt = salts.get(saltAndKey.getSalt());

        return AdvancedDecrypter.decrypt(strToDecrypt, secretKey, salt);

    }
    //endregion

    public static String enCrypt(String strToEncrypt, int userID) {

        SaltAndKey saltAndKey = ReadFromDB.getSaltsAndKeys(userID);

        String secretKey = secretKeys.get(saltAndKey.getKey());
        String salt = secretKeys.get(saltAndKey.getSalt());
        return AdvancedEncrypter.encrypt(strToEncrypt, secretKey, salt);
    }

}