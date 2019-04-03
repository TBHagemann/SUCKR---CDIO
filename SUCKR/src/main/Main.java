package main;

import controllers.ControllerRegistry;
import controllers.impl.MovementController;
import controllers.interfaces.IMovementController;
import controllers.interfaces.ISensorController;
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
		
<<<<<<< HEAD
		//movementTest();
		//gyroTest();
		runTest();
	}
	
	public static void movementTest() {
		Sound.playTone(500, 800);

		MovementController mc = new MovementController();

		mc.frontCollectorOn();
		mc.driveCar(5000,100);

		//mc.turnRight(true);
		Delay.msDelay(2000);

		mc.frontCollectorOff();
		mc.stopCar();

		mc.openTrunk();
		mc.closeTrunk();
=======
		movementTest();
		//gyroTest();
	}
	
	public static void movementTest() {
		IMovementController mc = new MovementController();
		
		for(int i = 0; i < 4; i++) {
			mc.driveCarUntillCloseToWall((float) 0.2);
			mc.turnLeft(90);
		}
>>>>>>> 35ffa7cd1b80362433fc6d23f1671273de78e022
	}
	
	public static void gyroTest() {
		IMovementController mc = ControllerRegistry.getMovementController();
		mc.turnRight(180);				
	}
	
	public static void runTest() {
		
		int driving = 0;
		boolean isDriving = true;
	
		IMovementController mc = ControllerRegistry.getMovementController();
		ISensorController sc = ControllerRegistry.getSensorController();

		mc.driveCar(0,100);
		
		while(isDriving) {
		if(sc.getDistance() < 0.2) {
			mc.turnRight(90); 
			driving++;
		}
		
		if(driving == 4) {
			mc.stopCar();
			isDriving = false;
		}
		mc.driveCar(0,100);
		}
	}
}
