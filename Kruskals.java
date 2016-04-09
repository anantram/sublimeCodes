/*
Implement the Minimum Spanning Tree using Kruskals Algorithm for a given graph G = (V, E) 
set of vertices and set of edges.

Input:

The first line of the input contains the number of vertices.

The second line contains the set (Names) of vertices.

The third line on wards contains the adjacency matrix.

Output:

Print the set of edges in the order that you have visited. While visiting the edges, 
if two edges have the same weights, visit them in the lexicographic order. 
ex: if ((V, Z) and (X, Y) have the same weights, then choose (V, Z). 
In the last line of the output, print the total edge cost.

Input #1:

7
(A,B,C,D,E,F,G)
0 2 0 3 3 0 0
2 0 3 0 4 0 0
0 3 0 0 1 8 0
3 0 0 0 0 7 0
3 4 1 0 0 6 0
0 0 8 7 6 6 9
0 0 0 0 0 9 0

Output #1:

(C,E)
(A,B)
(A,D)
(A,E)
(E,F)
(F,G)

24
*/


import java.util.*;

class Node {
	String nodeName;
	int nodeDistance;
	int position;
	String shortestPath;
	String parent;

	Node(String nodeName, int position) {
		nodeDistance = 99999;
		this.nodeName = nodeName;
		shortestPath = "";
		this.position = position;
		parent = "";
	}
}

class Edge {
	String head;
	String tail;
	int distance;

	Edge(String head, String tail, int distance) {
		
	}
}

class Dijktras {
	public static void main(String[] args) {
		Scanner inputScanner = new Scanner(System.in);
		int numberOfNodes;
		int tempCounter;
		String startingNode;
		String nodeNames;
		Node[] nodeList;
		int[][] pathArray;

		
		numberOfNodes = Integer.parseInt(inputScanner.nextLine());
		PriorityQueue nodeQueue = new PriorityQueue(numberOfNodes,valueComparator);
		nodeList = new Node[numberOfNodes];
		pathArray = new int[numberOfNodes][numberOfNodes];
		startingNode = inputScanner.nextLine();
		nodeNames = inputScanner.nextLine();
		StringTokenizer tokens = new StringTokenizer(nodeNames,",()");
		tempCounter = 0;
		while(tokens.hasMoreTokens()) {
			Node node = new Node(tokens.nextToken(),tempCounter);
			nodeList[tempCounter] = node;
			if(nodeList[tempCounter].nodeName.equals(startingNode)) {
				nodeList[tempCounter].nodeDistance = 0;
				nodeList[tempCounter].parent = startingNode;
				nodeQueue.add(node);
			}
			tempCounter++;
		}

		for (int i = 0; i < numberOfNodes; i++) {
			tokens = new StringTokenizer(inputScanner.nextLine(), ",");
			tempCounter = 0;
			while(tokens.hasMoreTokens()) {
				pathArray[i][tempCounter] = Integer.parseInt(tokens.nextToken());
				if(pathArray[i][tempCounter] == 0)
					pathArray[i][tempCounter] = 99999;
				tempCounter++;
			}
		}
