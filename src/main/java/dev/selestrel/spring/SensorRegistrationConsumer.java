package dev.selestrel.spring;

import dev.selestrel.spring.models.Sensor;
import org.springframework.web.client.RestTemplate;

public class SensorRegistrationConsumer {
    public static void main(String[] args) {
        RestTemplate restTemplate = new RestTemplate();

        String sensorAddUrl = "http://localhost:8080/sensors/registration";

        Sensor sensor = new Sensor("test_consumer");

        System.out.println(restTemplate.postForObject(sensorAddUrl, sensor, String.class));
    }
}
