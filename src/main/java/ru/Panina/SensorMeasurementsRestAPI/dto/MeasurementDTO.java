package ru.Panina.SensorMeasurementsRestAPI.dto;

import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.Panina.SensorMeasurementsRestAPI.models.Sensor;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MeasurementDTO {
    @NotNull
    @Min(value = -100, message = "Температура воздуха не может быть ниже -100")
    @Max(value = 100, message = "Температура воздуха не может быть выше 100")
    private double value;

    @NotNull
    private boolean raining;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "sensor_id", referencedColumnName = "id")
    private Sensor sensor;
}
