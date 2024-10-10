package ru.Panina.SensorMeasurementsRestAPI.util;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SensorErrorResponse {
    private String message;
    private long timestamp;
}
