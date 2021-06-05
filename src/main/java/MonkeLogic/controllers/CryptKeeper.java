package MonkeLogic.controllers;

import MonkeLogic.databasemethods.DBInsert;
import MonkeLogic.dto.EncryptedString;
import MonkeLogic.encryption.AdvancedDecrypter;
import MonkeLogic.encryption.AdvancedEncrypter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CryptKeeper {
    //region Lists Containing the Keys and Salts for Crypto
    private static final List<String> secretKeys = new ArrayList<>();
    private static final List<String> salts = new ArrayList<>();
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

        DBInsert.initEncrypt(new EncryptedString(rngKey, rngSalt));
        return AdvancedEncrypter.encrypt(strToEncrypt, secretKey, salt);
    }
    //endregion

    //region This Paragraph fetches the Key and Salt used for the encrypted String
    public static String deCrypt(String strToDecrypt, int usedKey, int usedSalt) {
        String secretKey = secretKeys.get(usedKey);
        String salt = salts.get(usedSalt);

        return AdvancedDecrypter.decrypt(strToDecrypt, secretKey, salt);

    }
    //endregion

    public static String enCrypt (){
        return null;
    }

}