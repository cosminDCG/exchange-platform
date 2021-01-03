package com.platform.exchange.service.impl;

import com.platform.exchange.exception.ErrorMessage;
import com.platform.exchange.exception.feature.FeatureNotFoundException;
import com.platform.exchange.model.Feature;
import com.platform.exchange.repository.FeatureRepository;
import com.platform.exchange.service.FeatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.UUID;

@Service
public class FeatureServiceImpl implements FeatureService {

    @Autowired
    private FeatureRepository featureRepository;

    @Override
    @Transactional
    public Feature saveFeature(Feature feature) {
        feature.setId(UUID.randomUUID());
        return featureRepository.save(feature);
    }

    @Override
    @Transactional
    public void deleteFeature(String uuid) {
        Feature feature = featureRepository.findById(UUID.fromString(uuid))
                                           .orElseThrow(() -> new FeatureNotFoundException(ErrorMessage.FEATURE_NOT_FOUND));
        featureRepository.delete(feature);
    }

    @Override
    @Transactional
    public Feature updateFeature(Feature feature) {
        featureRepository.findById(feature.getId())
                         .orElseThrow(() -> new FeatureNotFoundException(ErrorMessage.FEATURE_NOT_FOUND));
        return featureRepository.save(feature);
    }
}
