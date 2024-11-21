package org.avgrlv.domain;

public class Road extends Stage {
    @Override
    public String toString() {
        return "Дорога " + super.getName() + "  кол-во полос: " + super.getMaxCapacity();
    }

    public Road(String name, int distance, int maxCapacity) {
        super(name, distance, maxCapacity);
    }
}
