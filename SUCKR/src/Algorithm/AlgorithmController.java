package Algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Stack;

public class AlgorithmController {

	static public ArrayList<Integer> order;

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
	public static ArrayList<Node> convertToMST(ArrayList<Node> graph, Node start){
		HashMap<Integer,Node> mst = new HashMap<Integer,Node>();

		mst.put(start.getNumber(), new Node(start.getNumber(), start.getX(), start.getY()));
		ArrayList<Integer> visited = new ArrayList<Integer>();
		visited.add(start.getNumber());

		for(int i = 0; i < graph.size()-1; i++) {
			int curShortest = Integer.MAX_VALUE;
			Node curShortestNode = null;
			Node curShortestNodeFrom = null;
			for(Node node : graph) {
				if(visited.contains(node.getNumber())) {
					for(Entry<Integer, Integer> entry: node.getDistances().entrySet()) {
						if(!visited.contains(entry.getKey()) && entry.getValue() < curShortest) {
							curShortest = entry.getValue();
							curShortestNode = graph.get(entry.getKey());
							curShortestNodeFrom = mst.get(node.getNumber());
						}
					}
				}
			}

			Node newNode = new Node(curShortestNode.getNumber(), curShortestNode.getX(), curShortestNode.getY());
			int distance = calculateDistance(newNode, curShortestNodeFrom);
			newNode.addDistance(curShortestNodeFrom.getNumber(), distance);
			curShortestNodeFrom.addDistance(newNode.getNumber(), distance);
			mst.put(newNode.getNumber(), newNode);
			visited.add(newNode.getNumber());
		}

		ArrayList<Node> mstFinal = new ArrayList<Node>();
		for(Entry<Integer, Node> node : mst.entrySet()) {
			mstFinal.add(node.getValue());
		}

		return mstFinal;
	}

	//Performs a DFS and returns a list holding the order in which the nodes were visited
	public static ArrayList<Integer> performDFS(ArrayList<Node> graph, Node node){
		if(order == null) {
			order = new ArrayList<Integer>();
		}
		
		order.add(node.getNumber());
		HashMap<Integer, Integer> distances = node.getDistances();
		for(Entry<Integer, Integer> entry : distances.entrySet()) {
			if(!order.contains(entry.getKey())) {
				performDFS(graph, graph.get(entry.getKey()));
			}
		}
		order.add(node.getNumber());

			/*
			stackSizeWhenWeGotToThatNode.put(cur.getNumber(), stack.size());
			HashMap<Integer, Integer> distances = cur.getDistances();
			for(Entry<Integer, Integer> entry : distances.entrySet()) {
				if(!order.contains(entry.getKey())) {
					stack.add(graph.get(entry.getKey()));
				}
			}
			 */
		



		return order;
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
