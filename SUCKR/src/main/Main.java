package main;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import controllers.ControllerRegistry;
import controllers.impl.DataOutputStream;
import controllers.impl.MovementController;
import controllers.interfaces.IMovementController;
import controllers.interfaces.ISensorController;
import controllers.interfaces.ISocketController;
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

		InputStream in = null;
		//movementTest();

	}

	public static void movementTest() {
		IMovementController mc = new MovementController();
		mc.playSound();
//		for(int i = 0; i < 4; i++) {
//			mc.driveCarUntillCloseToWall((float) 0.2);
//			mc.turnLeft(90);
//		}
//		
		//mc.turnLeft(100000);
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
	
	public static void SocketTest() {
		ISocketController isc = ControllerRegistry.getSocketController();
		isc.sendData("127.0.0.1", 3000);
	}
	
	public static void sendData(int b) {
		OutputStream out = null;
		DataOutputStream op = new DataOutputStream(out);
		
		try {
			op.write(b);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static int receiveData() {
		int received = 0;
		InputStream in = null;
		DataInputStream ip = new DataInputStream(in);
		
		try {
			received = ip.read();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return received;
	}
}
