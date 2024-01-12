package dev.selestrel.spring;

import com.fasterxml.jackson.databind.ObjectMapper;
import dev.selestrel.spring.models.Measurement;
import dev.selestrel.spring.models.Sensor;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MeasurementsConsumer {
    public static void main(String[] args) {

        RestTemplate restTemplate = new RestTemplate();

        Sensor sensor = new Sensor("test_consumer");

        String measurementsBaseUrl = "http://localhost:8080/measurements";

        String addNewMeasurementUrl = measurementsBaseUrl + "/add";
        String retrieveRainyDaysUrl = measurementsBaseUrl + "/rainyDaysCount";

//        for (int i = 0; i < 1000; i++) {
//            Measurement measurement = new Measurement(sensor);
//            restTemplate.postForObject(addNewMeasurementUrl, measurement, String.class);
//        }

        List<Measurement> measurements = new ArrayList<>(
                List.of(Objects.requireNonNull(
                        restTemplate.getForObject(measurementsBaseUrl, Measurement[].class))));

        System.out.printf("Raining days count: %d", restTemplate.getForObject(retrieveRainyDaysUrl, Integer.class));


    }
}