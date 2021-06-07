package MonkeLogic.controllers;

import MonkeLogic.encryption.AdvancedDecrypter;
import MonkeLogic.encryption.AdvancedEncrypter;

public class CryptKeeper {

    //region Lists Containing the Keys and Salts for Crypto
    private static final String secretKey = "9gLHTonoaDF";
    private static final String salt = "l4SQCfIvvnv";
    //endregion

    //region Singleton
    private static CryptKeeper instance;

    private CryptKeeper() {

    }

    public static CryptKeeper getInstance() {
        if (instance == null) {
            instance = new CryptKeeper();
        }
        return instance;
    }

    public static void setInstance() {
        instance = null;
    }
    //endregion


    //region This Paragraph fetches the Key and Salt used for the encrypted String
    public static String deCrypt(String strToDecrypt) {

        return AdvancedDecrypter.decrypt(strToDecrypt, secretKey, salt);

    }
    //endregion

    public static String enCrypt(String strToEncrypt) {

        return AdvancedEncrypter.encrypt(strToEncrypt, secretKey, salt);
    }


}