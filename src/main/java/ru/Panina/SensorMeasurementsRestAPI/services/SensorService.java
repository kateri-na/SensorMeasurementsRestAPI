package ru.Panina.SensorMeasurementsRestAPI.services;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.Panina.SensorMeasurementsRestAPI.models.Sensor;
import ru.Panina.SensorMeasurementsRestAPI.repositories.SensorRepository;

import java.util.Optional;

@Service
@AllArgsConstructor
public class SensorService {
    @Autowired
    public final SensorRepository sensorRepository;

    @Transactional
    public void save(Sensor sensor){
        sensorRepository.save(sensor);
    }

    public Sensor findSensor(String name){
        return sensorRepository.findByName(name);
    }
}
