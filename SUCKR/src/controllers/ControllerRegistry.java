package controllers;

import controllers.impl.MovementController;
import controllers.impl.SensorController;
import controllers.impl.SocketController;
import controllers.interfaces.IMovementController;
import controllers.interfaces.ISensorController;
import controllers.interfaces.ISocketController;

public class ControllerRegistry {

	private static IMovementController movementController;
	private static ISensorController sensorController;
	private static ISocketController socketController;
	
	protected ControllerRegistry() {
		// Needs to be here to prevent instantiation.
	}	
	
	public static synchronized IMovementController getMovementController() {
		if (movementController == null) movementController = new MovementController();
		return movementController;
	}
	
	public static synchronized ISensorController getSensorController() {
		if (sensorController == null) sensorController = new SensorController();
		return sensorController;
	}
	
	public static synchronized ISocketController getSocketController() {
		if (socketController == null) socketController = new SocketController();
		return socketController;
	}
	
}
