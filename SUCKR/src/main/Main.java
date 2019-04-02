package main;

import controllers.ControllerRegistry;
import controllers.impl.MovementController;
import controllers.interfaces.IMovementController;
import entities.sensors.Gyro;
import lejos.*;
import lejos.hardware.Sound;
import lejos.hardware.motor.UnregulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3GyroSensor;
import lejos.hardware.sensor.EV3UltrasonicSensor;
import lejos.utility.Delay;
public class Main {
	
	public static void main(String[] args) {
		
		//movementTest();
		gyroTest();
	}
	
	public static void movementTest() {
		Sound.playTone(500, 800);

		MovementController mc = new MovementController();

		mc.frontCollectorOn();
		mc.driveCar(5000);

		//mc.turnRight(true);
		Delay.msDelay(2000);

		mc.frontCollectorOff();
		mc.stopCar();

		mc.openTrunk();
		mc.closeTrunk();
	}
	
	public static void gyroTest() {
		
		IMovementController mc = ControllerRegistry.getMovementController();
		
		mc.turnRight(180);		
		
	}
}
