package com.platform.exchange.service;

import com.platform.exchange.model.Feature;

public interface FeatureService {

    Feature saveFeature(Feature feature);

    void deleteFeature(String uuid);

    Feature updateFeature(Feature feature);
}
