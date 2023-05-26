package com.barrista.spring.quickstart.legacy.model;

public class Car {
  private double tank;
  private double weight;
  private double acceleration;
  private double maxSpeed;

  public Car(double tank, double weight, double acceleration, double maxSpeed) {
    this.tank = tank;
    this.weight = weight;
    this.acceleration = acceleration;
    this.maxSpeed = maxSpeed;
  }

  public double getTank() {
    return tank;
  }

  public void setTank(double tank) {
    this.tank = tank;
  }

  public double getWeight() {
    return weight;
  }

  public void setWeight(double weight) {
    this.weight = weight;
  }

  public double getAcceleration() {
    return acceleration;
  }

  public void setAcceleration(double acceleration) {
    this.acceleration = acceleration;
  }

  public double getMaxSpeed() {
    return maxSpeed;
  }

  public void setMaxSpeed(double maxSpeed) {
    this.maxSpeed = maxSpeed;
  }

  @Override
  public String toString() {
    return "Car{" +
        "tank=" + tank +
        ", weight=" + weight +
        ", acceleration=" + acceleration +
        ", maxSpeed=" + maxSpeed +
        '}';
  }
}
