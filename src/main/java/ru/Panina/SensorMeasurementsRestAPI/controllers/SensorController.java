package ru.Panina.SensorMeasurementsRestAPI.controllers;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import ru.Panina.SensorMeasurementsRestAPI.dto.SensorDTO;
import ru.Panina.SensorMeasurementsRestAPI.models.Sensor;
import ru.Panina.SensorMeasurementsRestAPI.services.SensorService;
import ru.Panina.SensorMeasurementsRestAPI.util.SensorNotCreatedException;
import ru.Panina.SensorMeasurementsRestAPI.util.ErrorResponse;

import java.util.List;

@RestController
@RequestMapping("/sensors")
@AllArgsConstructor
public class SensorController {
    @Autowired
    private final SensorService sensorService;

    @PostMapping("/registration")
    public ResponseEntity<HttpStatus> create(@RequestBody @Valid SensorDTO sensorDTO,
                                             BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            StringBuilder errorMessage = new StringBuilder();
            List<FieldError> errors = bindingResult.getFieldErrors();
            for(FieldError error:errors){
                errorMessage.append(error.getField()).append("-").
                        append(error.getDefaultMessage()).append(";");
            }
            throw new SensorNotCreatedException(errorMessage.toString());
        }
        sensorService.save(convertToSensor(sensorDTO));
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @ExceptionHandler
    private ResponseEntity<ErrorResponse> handleException(SensorNotCreatedException e){
        ErrorResponse response = new ErrorResponse(e.getMessage(),
                System.currentTimeMillis());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST); //404 status
    }

    private Sensor convertToSensor(SensorDTO sensorDTO){
        Sensor sensor = new Sensor();
        sensor.setName(sensorDTO.getName());
        return sensor;
    }
}
