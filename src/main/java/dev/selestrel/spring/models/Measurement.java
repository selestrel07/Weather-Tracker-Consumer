package dev.selestrel.spring.models;

import java.util.Random;

public class Measurement {
    private final Random random = new Random();
    private Double value;
    private Boolean raining;
    private Sensor sensor;

    public Measurement() {
    }

    public Measurement(Sensor sensor) {
        this.sensor = sensor;
        this.raining = random.nextBoolean();
        double num = random.nextDouble(25) * (random.nextInt(50) < 25 ? -1 : 1);
        this.value = (double) Math.round(num * 10) / 10;
    }

    public Measurement(Double value, Boolean raining, Sensor sensor) {
        this.value = value;
        this.raining = raining;
        this.sensor = sensor;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public Boolean getRaining() {
        return raining;
    }

    public void setRaining(Boolean raining) {
        this.raining = raining;
    }

    public Sensor getSensor() {
        return sensor;
    }

    public void setSensor(Sensor sensor) {
        this.sensor = sensor;
    }

    @Override
    public String toString() {
        return "Measurement{" +
                "value=" + value +
                ", raining=" + raining +
                ", sensor=" + sensor.getName() +
                '}';
    }
}
