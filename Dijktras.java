/*
Given a Graph G = (V, E) contains a set of vertices and set of edges connecting the pair of vertices. 
Find the shortest distance from a source vertex to all other vertices using Single Source Shortest Path - Dijktra's Algorithm.

Input:

The first line of the input contains the number of vertices

The second line of the input contains the source vertex

The third line of the input contains the set of vertices separated by commas.

From the fourth line of the input, contains the adjacency matrix.

Output:

Print the shortest distances from the source vertex to all other vertices. While printing follow the order defined in the third line of the input.
If there is no path from source vertex to v1, print its distance from source to v1 in the format as s->v1:99999, otherwise print its path from source to v1 and its distance.
example : s->a->b->e:6 (path:distance)

Example:

Input:

7
s

(s,a,b,c,d,e,f)

0,2,0,0,10,0,0
0,0,3,0,0,0,0
0,0,0,2,0,1,0
0,0,0,0,0,0,0
4,0,5,0,0,0,0
0,0,9,8,1,0,0
0,0,0,0,0,7,0

Output:

s:0

s->a:2

s->a->b:5

s->a->b->c:7

s->a->b->e->d:7

s->a->b->e:6

s->f:99999
*/

import java.util.*;

class Node {
	String nodeName;
	int nodeDistance;
	int position;
	String shortestPath;
	boolean visited;

	Node(String nodeName, int position) {
		nodeDistance = 9999;
		this.nodeName = nodeName;
		shortestPath = "";
		//visited = false;
		this.position = position;
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

		System.out.println(numberOfNodes);
		startingNode = inputScanner.nextLine();
		nodeNames = inputScanner.nextLine();
		StringTokenizer tokens = new StringTokenizer(nodeNames,",()");
		tempCounter = 0;
		while(tokens.hasMoreTokens()) {
			Node node = new Node(tokens.nextToken(),tempCounter);
			nodeList[tempCounter] = node;
			if(nodeList[tempCounter].nodeName.equals(startingNode)) {
				nodeList[tempCounter].nodeDistance = 0;
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
					pathArray[i][tempCounter] = 9999;
				tempCounter++;
			}
		}

			
		// Taking inputs done
		// Alogrithm starts
		Node temp = new Node("temp",0);
		while (!nodeQueue.isEmpty()) {
			temp = (Node) nodeQueue.poll();
			//System.out.println(temp.nodeName + " : " + temp.nodeDistance);
			//temp.visited = true;
			//System.out.println(temp.nodeName);
			for(int i = 0; i < numberOfNodes; i++) {
				if (pathArray[i][temp.position] != 0 && !nodeList[i].visited) {
					if((temp.nodeDistance + pathArray[temp.position][i]) < nodeList[i].nodeDistance){
						nodeList[i].nodeDistance = (temp.nodeDistance + pathArray[temp.position][i]);
						nodeQueue.add(nodeList[i]);
					}		
				}
				System.out.println("loop ");
			}

		}
		for(int i = 0; i < 7; i++)
			System.out.println(nodeList[i].nodeName + " : " + nodeList[i].nodeDistance);
	}

	// Difining the comparator
	public static Comparator<Node> valueComparator = new Comparator<Node>() {
		
		@Override
		public int compare(Node n1, Node n2) {
            return n1.nodeDistance - n2.nodeDistance;
        }
	};
}