package controllers.interfaces;

public interface IMovementController {
	
	public void driveCar(int time);
	public void stopCar();
	public void motorOn(String motor);
	public void motorOff(String motor);
	public void frontCollectorOn();
	public void frontCollectorOff();
	public void openTrunk();
	public void closeTrunk();
	public void turnRight(int degrees);
	public void turnLeft(int degrees);

}
