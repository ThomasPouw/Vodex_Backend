package abibliophobia.vodex.Encrypt;

import com.sun.mail.iap.ByteArray;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PasswordEncrypt {
    public String PasswordEncrypt(String Origin) throws NoSuchAlgorithmException {
        try{
            final MessageDigest digest = MessageDigest.getInstance("SHA3-256");
            ByteArray originalString;
            final byte[] hashbytes = digest.digest(
                    Origin.getBytes(StandardCharsets.UTF_8));
            return bytesToHex(hashbytes);
        }
        catch(NoSuchAlgorithmException No){
            System.out.println(No.getMessage());
        }
        return null;
    }
    private static String bytesToHex(byte[] hash) {
        StringBuilder hexString = new StringBuilder(2 * hash.length);
        for (int i = 0; i < hash.length; i++) {
            String hex = Integer.toHexString(0xff & hash[i]);
            if(hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }
}
