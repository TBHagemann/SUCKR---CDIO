package controllers.impl;

import controllers.interfaces.ISensorController;
import entities.sensors.Gyro;
import entities.sensors.Ultrasonic;
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3GyroSensor;
import lejos.hardware.sensor.EV3UltrasonicSensor;

public class SensorController implements ISensorController{
	
	Gyro gyro;
	Ultrasonic ultrasonic; 
	
	public SensorController() {
		
		EV3GyroSensor gs = new EV3GyroSensor(SensorPort.S2);
		gyro = new Gyro(gs.getAngleMode());
		
		EV3UltrasonicSensor us = new EV3UltrasonicSensor(SensorPort.S3);
		ultrasonic = new Ultrasonic(us.getMode("Distance"));
		
	}
	
	public int getGyroAngle(){
		return gyro.angle();
	}

	public float getDistance() {
		return ultrasonic.distance();
		
	}
	
}
