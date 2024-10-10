package ru.Panina.SensorMeasurementsRestAPI.services;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.Panina.SensorMeasurementsRestAPI.models.Measurement;
import ru.Panina.SensorMeasurementsRestAPI.repositories.MeasurementRepository;

import java.util.List;

@Service
@Transactional(readOnly = true)
@AllArgsConstructor
public class MeasurementService {
    @Autowired
    public final MeasurementRepository measurementRepository;

    @Transactional
    public void save(Measurement measurement){
        measurementRepository.save(measurement);
    }

    public List<Measurement> findAll(){
        return measurementRepository.findAll();
    }

    public List<Measurement> findRaining(){
        return measurementRepository.findByRaining(true);
    }
}
