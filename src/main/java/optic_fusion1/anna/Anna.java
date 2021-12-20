package optic_fusion1.anna;

import optic_fusion1.anna.logging.CustomLogger;

public class Anna extends Thread {

  private static final CustomLogger LOGGER = new CustomLogger("anna");

  @Override
  public void run() {
  }

  public CustomLogger getLogger() {
    return LOGGER;
  }

}
