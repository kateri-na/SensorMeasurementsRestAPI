package ru.Panina.SensorMeasurementsRestAPI.controllers;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import ru.Panina.SensorMeasurementsRestAPI.dto.MeasurementDTO;
import ru.Panina.SensorMeasurementsRestAPI.models.Measurement;
import ru.Panina.SensorMeasurementsRestAPI.services.MeasurementService;
import ru.Panina.SensorMeasurementsRestAPI.services.SensorService;
import ru.Panina.SensorMeasurementsRestAPI.util.ErrorResponse;
import ru.Panina.SensorMeasurementsRestAPI.util.MeasurementNotCreatedException;

import java.util.List;


@RestController
@RequestMapping("/measurements")
@AllArgsConstructor
public class MeasurementController {
    @Autowired
    private final MeasurementService measurementService;
    @Autowired
    private final SensorService sensorService;

    @PostMapping("/add")
    public ResponseEntity<HttpStatus> create(@RequestBody @Valid MeasurementDTO measurementDTO,
                                             BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            StringBuilder errorMessage = new StringBuilder();
            List<FieldError> errors = bindingResult.getFieldErrors();
            for(FieldError error:errors){
                errorMessage.append(error.getField()).append("-").
                        append(error.getDefaultMessage()).append(";");
            }
            throw new MeasurementNotCreatedException(errorMessage.toString());
        }
        measurementService.save(convertToMeasurement(measurementDTO));
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping()
    public List<Measurement> getMeasurements(){
        return measurementService.findAll();
    }

    @GetMapping("/rainyDaysCount")
    public List<Measurement> getRainyMeasurements(){
        return measurementService.findRaining();
    }

    @ExceptionHandler
    private ResponseEntity<ErrorResponse> handleException(MeasurementNotCreatedException e){
        ErrorResponse response = new ErrorResponse(e.getMessage(), System.currentTimeMillis());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    private Measurement convertToMeasurement(MeasurementDTO measurementDTO){
        Measurement measurement = new Measurement();
        measurement.setValue(measurementDTO.getValue());
        measurement.setRaining(measurementDTO.isRaining());
        if(sensorService.findSensor(measurementDTO.getSensor().getName())!=null)
            measurement.setSensor(measurementDTO.getSensor());
        else
            throw new MeasurementNotCreatedException("Сенсор с таким именем не зарегистрирован в системе");
        return measurement;
    }
}
