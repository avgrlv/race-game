package org.avgrlv.domain;

public class Ferry extends Stage {
    @Override
    public String toString() {
        return "Паром " + super.getName() + "  максимальное кол-во машин: " + super.getMaxCapacity();
    }

    private int ferrySpeed;

    public Ferry(String name, int distance) {
        super(name, distance);
        this.ferrySpeed = 220;
    }
}
