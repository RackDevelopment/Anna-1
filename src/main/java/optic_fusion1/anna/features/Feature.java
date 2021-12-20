package optic_fusion1.anna.features;

import java.util.List;
import optic_fusion1.anna.Anna;

public abstract class Feature {

  private String name;
  private Anna anna;

  public Feature(String name, Anna anna) {
    this.name = name;
    this.anna = anna;
  }

  public abstract void run(List<String> args);

  public String getName() {
    return name;
  }

  public Anna getAnna() {
    return anna;
  }

}
