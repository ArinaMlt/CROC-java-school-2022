package ru.croc.task16;

public class Client {
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

    public String getClassKomfort() {
        return classKomfort;
    }

    public String getAdditions() {
        return additions;
    }

    public Client(String classKomfort, String additions, double latitude, double longitude) {
        this.classKomfort = classKomfort;
        this.additions = additions;
        this.latitude = latitude;
        this.longitude = longitude;
    }

}
