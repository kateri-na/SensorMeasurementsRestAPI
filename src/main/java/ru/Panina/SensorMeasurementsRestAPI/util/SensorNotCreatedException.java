package ru.Panina.SensorMeasurementsRestAPI.util;

public class SensorNotCreatedException extends RuntimeException{
    public SensorNotCreatedException(String message){
        super(message);
    }
}
