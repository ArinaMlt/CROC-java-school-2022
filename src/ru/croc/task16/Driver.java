package ru.croc.task16;

public class Driver {
    private String id;
    // private double[] coordinates = new double[2];
    private double latitude; // широта
    private double longitude; // долгота
    private String classKomfort;
    private String additions;

    public double getLongitude() {
        return longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public String getId() {
        return id;
    }

    public String getClassKomfort() {
        return classKomfort;
    }

    public String getAdditions() {
        return additions;
    }

    public Driver(String id, String classKomfort, String additions, double latitude, double longitude) {
        this.id = id;
        this.classKomfort = classKomfort;
        this.additions = additions;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    @Override
    public String toString() {
        return id;
    }

}
