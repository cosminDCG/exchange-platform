package com.platform.exchange.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.errors.ApiException;
import com.google.maps.model.GeocodingResult;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class PlacesUtils {

    public static final String PLACES_API_KEY = "PLACES_API_KEY";

    public Coordinates getAddressCoordinate(String address) throws InterruptedException, ApiException, IOException {
        GeoApiContext context = new GeoApiContext.Builder()
                .apiKey(getPlacesApiKey())
                .build();
        GeocodingResult[] results =  GeocodingApi.geocode(context,
                address).await();

        return new Coordinates(results[0].geometry.location.lat, results[0].geometry.location.lat);
    }

    private String getPlacesApiKey() {
        return System.getenv(PLACES_API_KEY);
    }
}
