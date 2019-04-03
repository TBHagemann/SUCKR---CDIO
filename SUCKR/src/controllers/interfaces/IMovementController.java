package controllers.interfaces;

public interface IMovementController {
	
<<<<<<< HEAD
	public void driveCar(int time, int power);
=======
	public void driveCar(int time);
	public void driveCarUntillCloseToWall(float distance);
>>>>>>> 35ffa7cd1b80362433fc6d23f1671273de78e022
	public void stopCar();
	public void motorOn(String motor);
	public void motorOff(String motor);
	public void frontCollectorOn();
	public void frontCollectorOff();
	public void openTrunk();
	public void closeTrunk();
	public void turnRight(int degrees);
	public void turnLeft(int degrees);
	public boolean isDriving();

}
