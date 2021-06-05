package MonkeLogic.dto;

public class SaltAndKey {
    private final int salt;
    private final int key;

    public SaltAndKey(int salt, int key) {
        this.salt = salt;
        this.key = key;
    }

    public int getSalt() {
        return salt;
    }

    public int getKey() {
        return key;
    }
}
