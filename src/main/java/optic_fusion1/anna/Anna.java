package optic_fusion1.anna;

import java.util.Scanner;
import optic_fusion1.anna.feature.Feature;
import optic_fusion1.anna.feature.FeatureManager;
import optic_fusion1.anna.feature.impl.AESFeature;
import optic_fusion1.anna.logging.CustomLogger;

public class Anna extends Thread {

  private static final Scanner SCANNER = new Scanner(System.in);
  public static final CustomLogger LOGGER = new CustomLogger("anna");
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
    registerFeature(new AESFeature(this));
  }

  private void registerFeature(Feature feature) {
    FEATURE_MANAGER.addFeature(feature);
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
