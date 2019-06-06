package Algorithm;
	
import java.util.*;
	
public class Node {
	
	private int number;
	private int x;
	private int y;
	private HashMap<Integer, Integer> distances;
	
	public Node() {
		distances = new HashMap<Integer, Integer>();
	}
	public Node(int number, int x, int y) {
		distances = new HashMap<Integer, Integer>();
		this.x = x;
		this.y = y;
		this.number = number;
		
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public HashMap<Integer, Integer> getDistances() {
		return distances;
	}
	public void setDistances(HashMap<Integer, Integer> distances) {
		this.distances = distances;
	}
	public void addDistance(int number, int distance) {
		distances.put(number, distance);
	}
	
}	
