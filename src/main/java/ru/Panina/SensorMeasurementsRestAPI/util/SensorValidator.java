package ru.Panina.SensorMeasurementsRestAPI.util;


import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ru.Panina.SensorMeasurementsRestAPI.models.Sensor;
import ru.Panina.SensorMeasurementsRestAPI.services.SensorService;

@Component
@AllArgsConstructor
public class SensorValidator implements Validator {
    @Autowired
    private final SensorService sensorService;
    @Override
    public boolean supports(Class<?> clazz) {
        return Sensor.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Sensor sensor = (Sensor) target;
        if(sensorService.findSensor(sensor.getName())!=null){
            errors.rejectValue("name", "",
                    "Сенсор с таким названием уже существует в системе");
        }
    }
}
