package ru.Panina.SensorMeasurementsRestAPI.util;

public class MeasurementNotCreatedException extends RuntimeException{
    public MeasurementNotCreatedException(String message){
        super(message);
    }
}
