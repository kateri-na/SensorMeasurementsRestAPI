package ru.Panina.SensorMeasurementsRestAPI.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.Panina.SensorMeasurementsRestAPI.controllers.SensorController;
import ru.Panina.SensorMeasurementsRestAPI.models.Sensor;

@Repository
public interface SensorRepository extends JpaRepository<Sensor, Integer> {
}
