package io.github.zd4y.encicladisponibilidad.models;

public class Station {
    private int id;
    private String name;
    private int capacity;
    private int bikes;

    public Station(int id, String name, int capacity, int bikes) {
        this.id = id;
        this.name = name;
        this.capacity = capacity;
        this.bikes = bikes;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getBikes() {
        return bikes;
    }

    public void setBikes(int bikes) {
        this.bikes = bikes;
    }
}
