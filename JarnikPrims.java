/*
Implement the Minimum Spanning Tree using Jarnik Prims Algorithm for a given graph G = (V, E) set of vertices and set of edges.

Input:

The first line of the input contains the number of vertices.
The second line contains the set (Names) of vertices.
The third line contains the source/starting vertex.
The fourth line onwards contains the adjacency matrix.



Output:

The first line of the output contains the parent array. Prints the parent vertex of each of the vertex in the graph.
Consider the parent vertex of the starting vertex is itself. Assume that if a particular vertex has two parents,
consider them in the order that they have entered into the Queue. 
ex: First (W, V) is enqueued into the Queue and then (U, V) is enqueued into the Queue which are of same weights, 
then consider W as the parent vertex of V.

The second line of the output contains the set of vertices in the order that you have visited. 
While visiting the vertices, if two edges have the same weights, visit them in the lexicographic order. 
ex. (u,v) and (w,y) has same weights, then visit (u,v)

The last line of the output, print the total edge cost.

Input #1:

7
(A,B,C,D,E,F,G)
A
0 2 0 3 3 0 0
2 0 3 0 4 0 0
0 3 0 0 1 8 0
3 0 0 0 0 7 0
3 4 1 0 0 6 0
0 0 8 7 6 0 9
0 0 0 0 0 9 0

Output #1:

(A,A,E,A,A,E,F)
(A,B,D,E,C,F,G)
24
*/
import java.util.*;

class Node {
	String nodeName;
	int location;
	boolean isVisited;

	Node(String nodeName, int location) {
		this.nodeName = nodeName;
		this.location = location;
		isVisited = false;
	}

}

class JarnikPrims {
	public static void main(String[] args) {
		Scanner inputScanner = new Scanner(System.in);
		int numberOfNodes;
		int tempCounter;
		String startingNode;
		String nodeNames;
		Node[] nodeList;
		int[][] pathArray;

	
		numberOfNodes = Integer.parseInt(inputScanner.nextLine());
		nodeList = new Node[numberOfNodes];
		pathArray = new int[numberOfNodes][numberOfNodes];
		
		nodeNames = inputScanner.nextLine();
		StringTokenizer tokens = new StringTokenizer(nodeNames,",()");
		tempCounter = 0;
		while(tokens.hasMoreTokens()) {
			Node node = new Node(tokens.nextToken(),tempCounter);
			nodeList[tempCounter] = node;
			tempCounter++;
		}

		startingNode = inputScanner.nextLine();
		for (int i = 0; i < numberOfNodes; i++) {
			tokens = new StringTokenizer(inputScanner.nextLine());
			tempCounter = 0;
			while(tokens.hasMoreTokens()) {
				pathArray[i][tempCounter] = Integer.parseInt(tokens.nextToken());
				if(pathArray[i][tempCounter] == 0)
					pathArray[i][tempCounter] = 9999;
				tempCounter++;
			}
		}
		for(int i = 0; i < numberOfNodes; i++)
			if(nodeList[i].nodeName.equals(startingNode))
				nodeList[i].isVisited = true;

		// Taking of inputs completes
		int visitedNode = 1;
		int min = 9999;
		int nextNode = 0;
		int parent = 0;
		int pathLength = 0;
		String output = "(" + startingNode;
		while(visitedNode < numberOfNodes) {
			min = 9999;
			nextNode = 0;
			parent = 0;

			for(int mainCounter = 0; mainCounter < numberOfNodes; mainCounter++) {
				if(nodeList[mainCounter].isVisited) {
					for(int colScan = 0; colScan < numberOfNodes; colScan++) {
						if(!nodeList[colScan].isVisited) {
							if(pathArray[mainCounter][colScan] < min) {
								min = pathArray[mainCounter][colScan];
								nextNode = colScan;
								parent = mainCounter;
							}
						}
					}
				}
			}
			if(!(visitedNode == numberOfNodes -1))
				output = output + "," + nodeList[nextNode].nodeName;
			else
				output = output + "," + nodeList[nextNode].nodeName + ")";
			nodeList[nextNode].isVisited = true;
			System.out.println("path " + nodeList[parent].nodeName + nodeList[nextNode].nodeName);
			pathLength = pathLength + pathArray[parent][nextNode];
			visitedNode++;
		}	
		System.out.println(output);
		System.out.println(pathLength);
	}
}