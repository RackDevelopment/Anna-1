package optic_fusion1.anna.feature;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;

public class FeatureManager {

  private static final HashMap<String, Feature> FEATURES = new HashMap<>();

  public Collection<Feature> getFeatures() {
    return Collections.unmodifiableCollection(FEATURES.values());
  }

  public Feature getFeature(String name) {
    return FEATURES.get(name);
  }

  public void addFeature(Feature feature) {
    FEATURES.putIfAbsent(feature.getName(), feature);
  }

}
