package optic_fusion1.anna;

import java.util.Scanner;
import optic_fusion1.anna.features.FeatureManager;
import optic_fusion1.anna.logging.CustomLogger;

public class Anna extends Thread {

  private static final Scanner SCANNER = new Scanner(System.in);
  private static final CustomLogger LOGGER = new CustomLogger("anna");
  private static final FeatureManager FEATURE_MANAGER = new FeatureManager();
  private boolean running;

  @Override
  public void run() {
    init();
  }

  private void init() {
    registerFeatures();
    running = true;
  }

  private void registerFeatures() {
  }

  public CustomLogger getLogger() {
    return LOGGER;
  }

  public boolean isRunning() {
    return running;
  }

  public Scanner getScanner() {
    return SCANNER;
  }

  public FeatureManager getFeatureManager() {
    return FEATURE_MANAGER;
  }

}
