package ru.Panina.SensorMeasurementsRestAPI.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
    private SensorDTO sensorDTO;

}
