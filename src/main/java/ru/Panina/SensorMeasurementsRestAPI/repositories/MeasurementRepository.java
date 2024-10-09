package ru.Panina.SensorMeasurementsRestAPI.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.Panina.SensorMeasurementsRestAPI.models.Measurement;

import java.util.List;

@Repository
public interface MeasurementRepository extends JpaRepository<Measurement, Integer> {
    public List<Measurement> findByRaining(boolean identifier);
}
