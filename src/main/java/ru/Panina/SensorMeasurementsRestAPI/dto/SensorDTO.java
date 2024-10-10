package ru.Panina.SensorMeasurementsRestAPI.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
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
    @Min(value = 3, message = "Имя сенсора должно содержать как минимум 3 символа")
    @Max(value = 30, message = "Имя сенсора может содержать максимум 30 символов")
    private String name;
}
