package org.avgrlv.domain;

import java.util.LinkedList;
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

    private void moveOnStage() throws InterruptedException {
        while ((this.currentStage = stageQueue.poll()) != null) {
            System.out.println("Машина " + model + " перешла на ЭТАП " + currentStage);
            this.currentStage.go(this);
        }
    }


    public void setRaceStages(LinkedList<Stage> stages) {
        this.stageQueue.addAll(stages);
    }

    @Override
    public void run() {
        startTime = System.currentTimeMillis() / 100;
        try {
            moveOnStage();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        if (this.currentSpeed <= this.maxSpeed)
            this.currentSpeed += (int) (5 * Math.random());
    }

    @Override
    public String toString() {
        return model;
    }
}
