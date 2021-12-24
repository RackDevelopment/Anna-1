package optic_fusion1.anna.feature.impl;

import java.math.BigInteger;
import java.util.List;
import optic_fusion1.anna.Anna;
import optic_fusion1.anna.feature.Feature;
import org.apache.commons.lang3.StringUtils;

public class RSAFeature extends Feature {

  public RSAFeature(String name, Anna anna) {
    super(name, anna);
  }

  @Override
  public void run(List<String> args) {
    BigInteger n = new BigInteger("9516311845790656153499716760847001433441357");
    BigInteger e = new BigInteger("65537");
    String msg = StringUtils.join(args, " ");
    byte[] bytes = msg.getBytes();
    BigInteger plainNum = new BigInteger(bytes);
    BigInteger Bytes = new BigInteger(bytes);

    if (Bytes.compareTo(n) == 1) {
      System.out.println(msg + " is too long");
      return;
    }

    BigInteger enc = plainNum.modPow(e, n);
    System.out.println(enc);
  }

}
