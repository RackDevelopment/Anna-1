package optic_fusion1.anna.feature.impl;

import java.util.List;
import optic_fusion1.anna.Anna;
import optic_fusion1.anna.feature.Feature;
import org.apache.commons.lang3.StringUtils;

public class CaesarCipherFeature extends Feature {

  public CaesarCipherFeature(Anna anna) {
    super("CaesarCipher", anna);
  }

  @Override
  public void run(List<String> args) {
    System.out.println(encode(StringUtils.join(args, " ", 1, args.size()), Integer.valueOf(args.get(0))));
  }

  public String encode(String enc, int offset) {
    offset = offset % 26 + 26;
    StringBuilder encoded = new StringBuilder();
    for (char i : enc.toCharArray()) {
      if (Character.isLetter(i)) {
        if (Character.isUpperCase(i)) {
          encoded.append((char) ('A' + (i - 'A' + offset) % 26));
        } else {
          encoded.append((char) ('a' + (i - 'a' + offset) % 26));
        }
      } else {
        encoded.append(i);
      }
    }
    return encoded.toString();
  }

}
