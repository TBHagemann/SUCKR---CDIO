package controllers.impl;

import controllers.ControllerRegistry;
import controllers.interfaces.IMovementController;
import controllers.interfaces.ISensorController;
import entities.sensors.Gyro;
import entities.sensors.Ultrasonic;
import lejos.*;
import lejos.hardware.motor.UnregulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3GyroSensor;
import lejos.hardware.sensor.EV3UltrasonicSensor;
import lejos.utility.Delay;

public class MovementController implements IMovementController{
	
	
	UnregulatedMotor wheel1, wheel2, trunk, collector;	
	ISensorController sc;

	public MovementController(){
		wheel1 = new UnregulatedMotor(MotorPort.B);
		wheel2 = new UnregulatedMotor(MotorPort.C);
		
		trunk = new UnregulatedMotor(MotorPort.A);
		collector = new UnregulatedMotor(MotorPort.D);
		
		sc = ControllerRegistry.getSensorController();
		
		/*
		usensor = new EV3UltrasonicSensor(SensorPort.S3);
		ultrasonic = new Ultrasonic(usensor.getMode("Distance"));
		
		gsensor = new EV3GyroSensor(SensorPort.S2);
		gyro = new Gyro(gsensor.getMode("Angle"));
		*/
		

	}
	
	public void driveCar(int time, int power) {
		wheel1.setPower(power);
		wheel2.setPower(power);
		
		motorOn("left");
		motorOn("right");
		
		if(time != 0) {
			Delay.msDelay(time);
		}
		
	}
	
	public void driveCarUntillCloseToWall(float distance) {
		wheel1.setPower(100);
		wheel2.setPower(100);
		motorOn("left");
		motorOn("right");
		
		while(getDistance() > distance) {
			
		}
		
	}
	
	public void stopCar() {
		motorOff("left");
		motorOff("right");
	}
	
	public void motorOn(String motor) {
		
		motor.toLowerCase();
		
		switch(motor) {
		case "left": 
			wheel1.backward();
			break;
		case "right":
			wheel2.backward();
			break;
		}
	}
	
	public void motorOff(String motor) {
		motor.toLowerCase();
		
		switch(motor) {
		case "left": 
			wheel1.stop();
			break;
			
		case "right":
			wheel2.stop();
			break;
		}
	}
	
	public void frontCollectorOn() {
		collector.setPower(100);
		collector.backward();
	}
	
	public void frontCollectorOff() {
		collector.stop();
	}
	
	public void openTrunk() {
		trunk.setPower(100);
		trunk.backward();
		Delay.msDelay(1000);	
	}
	
	public void closeTrunk() {
		trunk.forward();
		Delay.msDelay(1000);
	}
	
	public void turnRight(int degrees) {
		wheel2.stop();
		wheel1.stop();
		
		
		int startAngle = sc.getGyroAngle();
		int endAngle = startAngle;
		while(Math.abs(startAngle - endAngle) < degrees) {
			wheel2.setPower(100);
			wheel2.backward();
			
			endAngle = sc.getGyroAngle();		
		}
		
		wheel2.stop();
	}
	
	public void turnLeft(int degrees) {
		wheel2.stop();
		wheel1.stop();
		
		wheel1.setPower(100);
		wheel2.setPower(100);
		
		
		int startAngle = sc.getGyroAngle();
		int endAngle = startAngle;
		while(Math.abs(startAngle - endAngle) < degrees) {
			
			wheel1.backward();
			wheel2.forward();
			
			endAngle = sc.getGyroAngle();		
		}
		
		wheel1.stop();
	}
	
	public float getDistance() {
		return sc.getDistance();
	}
	
	public boolean isDriving() {
		return true;
	}
}
