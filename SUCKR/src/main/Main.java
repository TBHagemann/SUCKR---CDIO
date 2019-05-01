package main;

import controllers.ControllerRegistry;
import controllers.impl.MovementController;
import controllers.interfaces.IMovementController;
import controllers.interfaces.ISensorController;
public class Main {

	public static void main(String[] args) {

		movementTest();

	}

	public static void movementTest() {
		IMovementController mc = new MovementController();
				
		mc.playSound();
		for(int i = 0; i < 4; i++) {
			mc.driveCarUntillCloseToWall(0.2f);
			mc.turnLeft(90);
		}
		 
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

		mc.driveCar(0, 100);

		while(isDriving) {
			if(sc.getDistance() < 0.2) {
				mc.turnRight(90); 
				driving++;
			}
			if(driving == 4) {
				mc.stopCar();
				isDriving = false;
			}
			mc.driveCar(0, 100);
		}
	}
}