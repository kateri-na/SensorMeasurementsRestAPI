package ru.Panina.SensorMeasurementsRestAPI.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class SensorDTO {
    @NotEmpty(message = "Имя сенсора обязательно")
    @Size(min = 3, max = 30, message = "Имя сенсора должно содержать как минимум 3 символа, как максимум - 30")
    private String name;
}
