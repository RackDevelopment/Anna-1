package optic_fusion1.anna.util.encryption;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import static optic_fusion1.anna.Anna.LOGGER;

public class AESEncryption {

  private static SecretKeySpec secretKey;
  private static byte[] key;

  private static String decryptedString;
  private static String encryptedString;

  public void setKey(String myKey) {
    MessageDigest sha = null;
    try {
      key = myKey.getBytes("UTF-8");
      sha = MessageDigest.getInstance("SHA-1");
      key = sha.digest(key);
      key = Arrays.copyOf(key, 16); // use only first 128 bit
      secretKey = new SecretKeySpec(key, "AES");
    } catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
      e.printStackTrace();
    }
  }

  public String getDecryptedString() {
    return decryptedString;
  }

  public void setDecryptedString(String decryptedString) {
    AESEncryption.decryptedString = decryptedString;
  }

  public String getEncryptedString() {
    return encryptedString;
  }

  public void setEncryptedString(String encryptedString) {
    AESEncryption.encryptedString = encryptedString;
  }

  public String encrypt(String strToEncrypt) {
    try {
      Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
      cipher.init(Cipher.ENCRYPT_MODE, secretKey);
      setEncryptedString(Base64.getEncoder().encodeToString(cipher.doFinal(strToEncrypt.getBytes("UTF-8"))));
    } catch (UnsupportedEncodingException | InvalidKeyException | NoSuchAlgorithmException | BadPaddingException | IllegalBlockSizeException | NoSuchPaddingException e) {
      LOGGER.exception(e);
    }
    return null;
  }

  public String decrypt(String strToDecrypt) {
    try {
      Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");
      cipher.init(Cipher.DECRYPT_MODE, secretKey);
      setDecryptedString(new String(cipher.doFinal(Base64.getDecoder().decode(strToDecrypt))));
    } catch (InvalidKeyException | NoSuchAlgorithmException | NoSuchPaddingException | IllegalBlockSizeException | BadPaddingException e) {
      LOGGER.exception(e);
    }
    return null;
  }

}
