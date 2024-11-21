package org.avgrlv.domain;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Car implements Runnable {
    private String model;
    private int currentSpeed;
    private int maxSpeed;
    private long startTime = 0;
    private Stage currentStage;
    private Queue<Stage> stageQueue = new ConcurrentLinkedQueue<>();

    public String getModel() {
        return model;
    }

    public int getCurrentSpeed() {
        return currentSpeed;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public Car(String model, int maxSpeed) {
        this.model = model;
        this.maxSpeed = maxSpeed;
    }

    private void moveOnStage() {
        this.currentStage = stageQueue.poll();
        System.out.println("Машина " + model + " перешла на ЭТАП " + currentStage);
    }


    public void setRaceStages(LinkedList<Stage> stages) {
        this.stageQueue.addAll(stages);
    }

    @Override
    public void run() {
        startTime = System.currentTimeMillis() / 100;
        moveOnStage();
        if (this.currentSpeed <= this.maxSpeed)
            this.currentSpeed += (int) (5 * Math.random());
    }

    @Override
    public String toString() {
        return model;
    }
}
