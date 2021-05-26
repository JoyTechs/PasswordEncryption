package MonkeLogic.services;

public class WritesToDB
{

    private int secretKey;
    private int salt;
    public void setKeyandSalt (int secretKey, int salt)
    {
        this.secretKey = secretKey;
        this.salt = salt;
    }

}
