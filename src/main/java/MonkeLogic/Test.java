package MonkeLogic;

import MonkeLogic.encryption.Encrypter;

public class Test
{
    public static void main(String[] args)
    {
        final String secretKey = "Baguette";

        String originalString = "Shit";
        String encryptedString = Encrypter.encrypt(originalString, secretKey) ;
        String decryptedString = Encrypter.decrypt(encryptedString, secretKey) ;

        System.out.println(originalString);
        System.out.println(encryptedString);
        System.out.println(decryptedString);
    }
}