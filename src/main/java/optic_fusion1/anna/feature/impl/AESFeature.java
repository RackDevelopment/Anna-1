package optic_fusion1.anna.feature.impl;

import java.util.List;
import optic_fusion1.anna.Anna;
import optic_fusion1.anna.feature.Feature;
import optic_fusion1.anna.util.encryption.AESEncryption;

public class AESFeature extends Feature {

  public AESFeature(Anna anna) {
    super("AES", anna);
  }

  @Override
  public void run(List<String> args) {
    AESEncryption aes = new AESEncryption();
    aes.setKey(args.get(1));
    if (args.get(0).equalsIgnoreCase("encrypt")) {
      System.out.println(aes.encrypt(args.get(2)));
    } else if (args.get(0).equalsIgnoreCase("decrypt")) {
      System.out.println(aes.decrypt(args.get(2)));
    }
  }

}
