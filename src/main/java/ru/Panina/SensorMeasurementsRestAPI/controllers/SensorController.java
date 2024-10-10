package ru.Panina.SensorMeasurementsRestAPI.controllers;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.Panina.SensorMeasurementsRestAPI.models.Sensor;
import ru.Panina.SensorMeasurementsRestAPI.services.SensorService;
import ru.Panina.SensorMeasurementsRestAPI.util.SensorAlreadyExistsException;
import ru.Panina.SensorMeasurementsRestAPI.util.SensorErrorResponse;

@RestController
@RequestMapping("/sensors")
@AllArgsConstructor
public class SensorController {
    @Autowired
    private final SensorService sensorService;

    @PostMapping("/registration")
    public ResponseEntity<HttpStatus> create(@RequestBody @Valid Sensor sensor,
                                             BindingResult bindingResult){
        if(bindingResult.hasErrors()){

        }
        sensorService.save(sensor);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @ExceptionHandler
    private ResponseEntity<SensorErrorResponse> handleException(SensorAlreadyExistsException e){
        SensorErrorResponse response = new SensorErrorResponse("В системе уже сущесвует датчик с таким именем",
                System.currentTimeMillis());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND); //404 status
    }
}
