package org.avgrlv.domain;

public abstract class Stage {
    private String name;
    private int distance;
    private int maxCapacity;

    public Stage(String name, int distance) {
        this.name = name;
        this.distance = distance;
        this.maxCapacity = 1;
    }

    public Stage(String name, int distance, int maxCapacity) {
        this.name = name;
        this.distance = distance;
        this.maxCapacity = maxCapacity;
    }

    @Override
    public String toString() {
        return "этап = " + name + " протяженность = " + distance;
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }
}
