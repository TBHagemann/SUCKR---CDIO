package Algorithm;

import java.util.ArrayList;
import java.util.HashMap;

public class AlgorithmController {

	public static ArrayList<Node> ConvertToGraph(int[][] matrix) {

		int number = 0;
		ArrayList<Node> nodes = new ArrayList<Node>();
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix[i].length; j++) {
				if(matrix[i][j] == 1) {
					nodes.add(new Node(number, j, i));
					number++;
				}
			}
		}

		for(int i = 0; i < nodes.size(); i++) {
			Node from = nodes.get(i);
			for(int j = i+1; j < nodes.size(); j++) {
				Node to = nodes.get(j);
				int dist = calculateDistance(from, to);
				to.addDistance(from.getNumber(), dist);
				from.addDistance(to.getNumber(), dist);
			}
		}
		return nodes;
	}
	
	//Make a minimum spanning tree using Prim's Algorithm
	private static ArrayList<Integer> convertToMST(ArrayList<Integer> graph){
		
		return null;
	}

	//Calculates total distance (in matrix coordinates) using Pythagoras
	private static int calculateDistance(Node from, Node to){
		int a = Math.abs(from.getX() - to.getX());
		int b = Math.abs(from.getY() - to.getY());

		return (int) Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));
	}
	
	
	//Solve the travelling salemans problem in constant time
	public static ArrayList<Integer> solveTravelingSalesmanProblemInConstantTime() {
		
		return null;
	}

}
