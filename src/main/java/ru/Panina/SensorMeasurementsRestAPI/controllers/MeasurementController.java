package ru.Panina.SensorMeasurementsRestAPI.controllers;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.Panina.SensorMeasurementsRestAPI.models.Measurement;
import ru.Panina.SensorMeasurementsRestAPI.services.MeasurementService;

import java.util.List;


@RestController
@RequestMapping("/measurements")
@AllArgsConstructor
public class MeasurementController {
    @Autowired
    private final MeasurementService measurementService;

    @PostMapping("/add")
    public void create(@Valid Measurement measurement){
        measurementService.save(measurement);
    }

    @GetMapping()
    public List<Measurement> getMeasurements(){
        return measurementService.findAll();
    }

    @GetMapping("/rainyDaysCount")
    public List<Measurement> getRainyMeasurements(){
        return measurementService.findRaining();
    }
}
