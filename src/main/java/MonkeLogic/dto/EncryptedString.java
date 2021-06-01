package MonkeLogic.dto;

public class EncryptedString {
    //region Variables
    private String encryptedString;
    private int secretKey;
    private int salt;
    //endregion

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
