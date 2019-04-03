package main;

import controllers.ControllerRegistry;
import controllers.impl.MovementController;
import controllers.interfaces.IMovementController;
public class Main {

	public static void main(String[] args) {

		movementTest();
		//gyroTest();
	}

	public static void movementTest() {
		IMovementController mc = new MovementController();
		for(int i = 0; i < 4; i++) {
			mc.driveCarUntillCloseToWall((float) 0.2);
			mc.turnLeft(90);
		}
	}

	public static void gyroTest() {
		IMovementController mc = ControllerRegistry.getMovementController();
		mc.turnRight(180);				
	}
}
