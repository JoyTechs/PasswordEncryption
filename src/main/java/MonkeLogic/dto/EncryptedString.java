package MonkeLogic.dto;

import MonkeLogic.controllers.SessionManager;

public class EncryptedString {

    //TODO: Use This for Encryption/Decryption
    //region Variables
    private String encryptedString;
    private int secretKey;
    private int salt;
    //endregion

    public EncryptedString(String encryptedString, int secretKey, int salt) {
        this.encryptedString = encryptedString;
        this.secretKey = secretKey;
        this.salt = salt;
    }

    public EncryptedString(int secretKey, int salt) {
        this.secretKey = secretKey;
        this.salt = salt;
    }

    //TODO: Se över denna
    public EncryptedString() {
        SessionManager.getActiveUser().getUserID();
    }

    //region Setters
    public void setEncryptedString(String encryptedString) {
        this.encryptedString = encryptedString;
    }

    public void setSecretKey(int secretKey) {
        this.secretKey = secretKey;
    }

    public void setSalt(int salt) {
        this.salt = salt;
    }
    //endregion

    //region Getters
    public String getEncryptedString() {
        return encryptedString;
    }

    public int getSecretKey() {
        return secretKey;
    }

    public int getSalt() {
        return salt;
    }
    //endregion
}
