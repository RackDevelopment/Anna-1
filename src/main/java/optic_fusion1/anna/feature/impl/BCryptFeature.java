package optic_fusion1.anna.feature.impl;

import java.util.List;
import optic_fusion1.anna.Anna;
import optic_fusion1.anna.feature.Feature;
import optic_fusion1.anna.util.hash.BCrypt;

public class BCryptFeature extends Feature {

  public BCryptFeature(String name, Anna anna) {
    super(name, anna);
  }

  @Override
  public void run(List<String> args) {
    String input = args.get(0);
    if (input.equalsIgnoreCase("check")) {
      System.out.println(BCrypt.checkpw(args.get(1), args.get(2)));
    } else if (input.equalsIgnoreCase("hash")) {
      String salt = BCrypt.gensalt();
      System.out.println("Salt: " + salt);
      System.out.println("Hashed String: " + BCrypt.hashpw(args.get(0), salt));
    }
  }

}
