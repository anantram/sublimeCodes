/*
Given a graph G=(V, E) consisting of set of vertices and non-empty set of edges, 
Implement the All-Pairs Shortest Path Algorithm.

Input :

The first line of the input contains the number of vertices.
The second line contains the set of vertices (names) separated by commas (,).
The third line on wards contains the Adjacency Matrix.

Output :

Print the shortest distances between every pair of vertices in the graph in the form of a matrix. 
If you are not able to find the distances between every pair of vertices, 
Print "Graph contains a negative weight cycles. 
Can't able to find the shortest path distances between every pair of vertices for the given graph."



Note : Infinity is represented as 999. If there is no direct edge between (u, v), then the edge is represented as infinity.
For an edge between (u, u), consider the distance as 0.



Input #1:

4
1,2,3,4
0,8,999,1
999,0,1,999
4,999,0,999
999,2,9,0

Output #1:

0,3,4,1
5,0,1,6
4,7,0,5
7,2,3,0

*/

import java.util.*;

class Vertex {
	String vertexName;
	int position;
	int parent;
	int distance;

	Vertex(String vertexName, int position) {
		this.vertexName = vertexName;
		this.position = position;
		parent = 0;
		distance = 999;
	}
}

class AllPair {
	public static void main(String[] args) {
		Scanner inputReader = new Scanner(System.in);
		int inputNumber = 0;
		int numberOfVertices;
		Vertex[] vertexArray;
		while(inputReader.hasNextLine()) {
			if(inputReader.nextLine() == "")
				break;
			else {
				if(inputNumber == 0) {
					numberOfVertices = Integer.parseInt(inputReader.nextLine());
					vertexArray = new Vertex[numberOfVertices + 1];
				} 
	
				else if(inputNumber == 1) {
					String temp = inputReader.nextLine();
					StringTokenizer vertices = new StringTokenizer(temp, ",");
					int veritexLocation = 0;
					while (vertices.hasMoreTokens()) {
						Vertex newVertex = new Vertex(vertices.nextToken(), veritexLocation);
						vertexArray[veritexLocation] = newVertex;
					}
				}
				else {
					
				}
			}
		}
	}
}