package ru.Panina.SensorMeasurementsRestAPI.services;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.Panina.SensorMeasurementsRestAPI.models.Sensor;
import ru.Panina.SensorMeasurementsRestAPI.repositories.SensorRepository;

@Service
public class SensorService {
    public final SensorRepository sensorRepository;

    @Autowired
    public SensorService(SensorRepository sensorRepository) {
        this.sensorRepository = sensorRepository;
    }

    @Transactional
    public void save(Sensor sensor){
        sensorRepository.save(sensor);
    }
}
