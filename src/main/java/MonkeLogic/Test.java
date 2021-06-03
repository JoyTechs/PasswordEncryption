package MonkeLogic;

public class Test {
    public static void main(String[] args) {
        final String secretKey = "Baguette";

        String originalString = "Newton";
        String encryptedString = Encrypter.encrypt(originalString, secretKey);
        String decryptedString = Encrypter.decrypt(encryptedString, secretKey);

        System.out.println(originalString);
        System.out.println(encryptedString);
        System.out.println(decryptedString);
    }
}