package optic_fusion1.anna.feature.impl;

import java.util.List;
import optic_fusion1.anna.Anna;
import optic_fusion1.anna.feature.Feature;
import optic_fusion1.anna.util.encoding.Base32Encoding;

public class Base32Feature extends Feature {

  public Base32Feature(String name, Anna anna) {
    super(name, anna);
  }

  @Override
  public void run(List<String> args) {
    Base32Encoding base32 = new Base32Encoding();
    if (args.get(0).equalsIgnoreCase("encode")) {
      System.out.println(base32.encodeToString(args.get(1)));
    } else if (args.get(0).equalsIgnoreCase("decode")) {
      System.out.println(base32.decodeToString(args.get(1)));
    }
  }

}
