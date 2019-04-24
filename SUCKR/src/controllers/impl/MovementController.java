package controllers.impl;

import java.io.File;

import controllers.ControllerRegistry;
import controllers.interfaces.IMovementController;
import controllers.interfaces.ISensorController;
import entities.sensors.Gyro;
import entities.sensors.Ultrasonic;
import lejos.*;
import lejos.hardware.Sound;
import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.motor.EV3MediumRegulatedMotor;
import lejos.hardware.motor.UnregulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3GyroSensor;
import lejos.hardware.sensor.EV3UltrasonicSensor;
import lejos.robotics.MirrorMotor;
import lejos.utility.Delay;

public class MovementController implements IMovementController{
	
	
	private EV3LargeRegulatedMotor wheel1, wheel2;
	private EV3MediumRegulatedMotor trunk, collector;	
	private ISensorController sc;
	
	private File PKMON = new File("sjovtklip.wav");

	public MovementController(){
		wheel1 = new EV3LargeRegulatedMotor(MotorPort.B);
		wheel2 = new EV3LargeRegulatedMotor(MotorPort.C);
		
		MirrorMotor.invertMotor(wheel1);
		MirrorMotor.invertMotor(wheel2);
		
		trunk = new EV3MediumRegulatedMotor(MotorPort.A);
		collector = new EV3MediumRegulatedMotor(MotorPort.D);
		
		sc = ControllerRegistry.getSensorController();
	
	}
	
	public void driveCar(int time) {
		
		motorOn("left");
		motorOn("right");
		
		if(time != 0) {
			Delay.msDelay(time);
		}
		
	}
	
	public void driveCarUntillCloseToWall(float distance) {
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
		
		motor = motor.toLowerCase();
		
		switch(motor) {
		case "left": 
			wheel1.forward();
			break;
		case "right":
			wheel2.forward();
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
		collector.backward();
	}
	
	public void frontCollectorOff() {
		collector.stop();
	}
	
	public void openTrunk() {
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
			
			wheel1.backward();
			wheel2.forward();
			
			endAngle = sc.getGyroAngle();		
		}
		
		wheel1.stop();
		wheel2.stop();
	}
	
	public void turnLeft(int degrees) {
		wheel2.stop();
		wheel1.stop();
		
		int startAngle = sc.getGyroAngle();
		int endAngle = startAngle;
		while(Math.abs(startAngle - endAngle) < degrees) {
			
			wheel1.forward();
			wheel2.backward();
			
			endAngle = sc.getGyroAngle();		
		}
		
		wheel1.stop();
		wheel2.stop();
	}
	
	public float getDistance() {
		return sc.getDistance();
	}
	
	public boolean isDriving() {
		return true;
	}
	
	public void zigZag(int degrees) {
		wheel2.stop();
		wheel1.stop();
		wheel2.forward();
		wheel1.forward();
		wheel2.stop();
		wheel1.stop();
		wheel2.stop();
		wheel1.stop();
		wheel2.forward();
		wheel1.forward();
		wheel2.stop();
		wheel1.stop();
		wheel2.forward();
		wheel1.forward();
		
	}
	/*
	public void driveBackwards(int time) {
		wheel2.forward();
		wheel1.forward();
	}
	*/
	
	
	public void driveBackwards(int time) {

		wheel1.backward();
		wheel2.backward();
		
		if(time != 0) {
			Delay.msDelay(time);
		}
	}
	
	
	public void parallelPark() {
		wheel2.stop();
		wheel1.stop();
		driveCar(500);
		turnLeft(180);
		driveBackwards(500);
		openTrunk();
	}
	
	public void playSound() {
		Sound.playSample(PKMON);
	}
	
	
	public void twerk() {
		for(int i = 1; i < 40; i++) {
			if((i % 2) == 0) {
				driveBackwards(150);
			} else {
				driveCar(120);
			}
		}
	}
} 


