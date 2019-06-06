package Algorithm;

import java.util.*;
import java.util.Map.Entry;

public class Algotester {
	
	public static void main(String[] args) {
		int[][] testArray = new int[1920][1080];
		Random r = new Random();
		
		for(int i = 0; i < testArray.length; i++) {
			for(int j = 0; j < testArray[i].length; j++) {
				testArray[i][j] = 0;
				if(r.nextInt(200000) == 1) {
					testArray[i][j] = 1;
					System.out.println("Ball placed at:");
					System.out.println("x: " + j);
					System.out.println("y: " + i);
				}
			}
		}
		ArrayList<Node> nodeList = AlgorithmController.ConvertToGraph(testArray);
		/*
		for(Node node : nodeList) {
			System.out.println(node.getNumber());
			System.out.println("x: " + node.getX());
			System.out.println("y: " + node.getY());
			System.out.println("Distances");
			HashMap<Integer, Integer> distances = node.getDistances();
			for(Entry<Integer, Integer> entry : distances.entrySet()) {
				System.out.println(entry.getKey());
				System.out.println(entry.getValue());
				System.out.println();
			}
		}
		*/
		ArrayList<Node> mst = AlgorithmController.convertToMST(nodeList, nodeList.get(0));
		
		for(Node node : mst) {
			System.out.println(node.getNumber());
			//System.out.println("x: " + node.getX());
			//System.out.println("y: " + node.getY());
			System.out.println("Neighbors");
			//System.out.println(node.getDistances().size());
			//System.out.println();
			//System.out.println();
			//System.out.println("Distances");
			HashMap<Integer, Integer> distances = node.getDistances();
			
			for(Entry<Integer, Integer> entry : distances.entrySet()) {
				System.out.println(entry.getKey());
				//System.out.println(entry.getValue());
				System.out.println();
			}
			System.out.println();
		}
	}
}
