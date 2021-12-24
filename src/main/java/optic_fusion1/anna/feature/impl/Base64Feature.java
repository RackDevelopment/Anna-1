package optic_fusion1.anna.feature.impl;

import java.util.Base64;
import java.util.List;
import optic_fusion1.anna.Anna;
import optic_fusion1.anna.feature.Feature;

public class Base64Feature extends Feature {

  public Base64Feature(String name, Anna anna) {
    super(name, anna);
  }

  @Override
  public void run(List<String> args) {
    if (args.get(0).equalsIgnoreCase("decode")) {
      System.out.println(new String(Base64.getDecoder().decode(args.get(1))));
      return;
    }
    if (args.get(0).equalsIgnoreCase("encode")) {
      System.out.println(new String(Base64.getEncoder().encode(args.get(1).getBytes())));
    }
  }

}
