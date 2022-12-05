package ru.croc.task16;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DriverSearch {
    private List<Driver> drivers;
    private Client client;
    private Set<Driver> resultsSearching = new HashSet<>();

    public DriverSearch(List<Driver> drivers, Client client) {
        this.drivers = drivers;
        this.client = client;
    }

    // search for the nearest driver according to the given parameters
    public Driver search() {
        drivers.forEach(driver -> {
            if (driver.getClassKomfort() == client.getClassKomfort())
                resultsSearching.add(driver);
        });

        String assitions = client.getAdditions();
        List<Driver> resultsAdditions = new ArrayList<>();
        if (assitions != null) {
            resultsSearching.forEach(result -> {
                if ((result.getAdditions() != null) && result.getAdditions().equals(client.getAdditions()))
                    resultsAdditions.add(result);
            });
        } else {
            resultsAdditions.addAll(resultsSearching);
        }

        if (resultsAdditions.size() > 0) {
            Driver result = resultsAdditions.get(0);
            double dist = distance(result.getLatitude(), result.getLongitude(), client.getLatitude(),
                    client.getLongitude());
            double driverDist = 0;

            for (Driver driver : resultsAdditions) {
                driverDist = distance(driver.getLatitude(), driver.getLongitude(), client.getLatitude(),
                        client.getLongitude());
                if (driverDist < dist) {
                    result = driver;
                    dist = driverDist;
                }
            }

            return result;
        } else
            return null;

    }

    // the method calculates the distance between the driver and the client
    private double distance(double latitudeDriver, double longitudeDriver,
            double latitudeClient, double longitudeClient) {
        return Math.sqrt(
                (Math.pow((latitudeDriver - latitudeClient), 2)) + (Math.pow((longitudeDriver - longitudeClient), 2)));
    }

}
