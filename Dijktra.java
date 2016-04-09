/*
Modify the Dijktras Algorithm to find the shortest path for a given source (S) and destination (D) vertices. 
During the iterations of the Dijktras Algorithms if the destination (D) vertex has been dequeued from the queue, 
terminate the algorithm and print the paths from S to D and the subset of the paths in between S and D. 
So that you don't need to find the shortest paths to all other vertices. This is called Goal-Directed Search.

Note: While traversing the edges, if you have two vertices with the same tentative distances
 or if you have two outgoing vertices from a particular vertex, then follow in a lexicographic order.

Input:

The first line of the input contains the number of vertices.
The second line of the input contains the set of vertices.
The third line of the input contains the Source (S) and Destination (D) vertices that are separated by comma.
From the fourth line on wards the input contains the adjacency matrix.

Output:

Print all the paths from S to D with their distances.

Example: If the path for given source (A) and Destination (F) is : A -> B -> D -> F : 10 then you need to print as follows:

A -> A : 0

A -> B : 2

A -> B -> D : 7

A -> B -> D -> F : 10

Sample Test Case:

Input

8
(s,a,b,c,d,e,f,g)
s,g
9999,1,9999,3,2,9999,9999,9999
9999,9999,2,9999,9999,9999,9999,9999
9999,1,9999,9999,9999,3,1,9999
9999,9999,9999,9999,9999,9999,9999,9999
9999,5,9999,9999,9999,4,9999,9999
9999,9999,9999,9999,9999,9999,3,6
9999,9999,9999,9999,9999,9999,9999,2
9999,9999,9999,9999,9999,9999,9999,9999

Output

s->s : 0
s->a : 1
s->a->b : 3
s->a->b->f : 4
s->a->b->f->g : 6

*/
import java.util.*;

class Node {
	String nodeName;
	int nodeDistance;
	int position;
	String shortestPath;
	String parent;

	Node(String nodeName, int position) {
		nodeDistance = 9999;
		this.nodeName = nodeName;
		shortestPath = "";
		this.position = position;
		parent = "";
	}
}

class Dijktra {
	public static void main(String[] args) {
		Scanner inputScanner = new Scanner(System.in);
		int numberOfNodes;
		int tempCounter;
		String startingNode;
		String endNode;
		String nodeNames;
		Node[] nodeList;
		int[][] pathArray;

		
		numberOfNodes = Integer.parseInt(inputScanner.nextLine());
		PriorityQueue nodeQueue = new PriorityQueue(numberOfNodes,valueComparator);
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
		String startAndEnd = inputScanner.nextLine();
		StringTokenizer token = new StringTokenizer(startAndEnd,",");

		startingNode = token.nextToken();
		endNode = token.nextToken();
		for(tempCounter = 0; tempCounter < numberOfNodes; tempCounter++) {
			if(nodeList[tempCounter].nodeName.equals(startingNode)) {
				nodeList[tempCounter].nodeDistance = 0;
				nodeList[tempCounter].parent = startingNode;
				nodeQueue.add(nodeList[tempCounter]);
			}
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
			for(int i = 0; i < numberOfNodes; i++) {
				if((temp.nodeDistance + pathArray[temp.position][i]) < nodeList[i].nodeDistance){
					nodeList[i].nodeDistance = (temp.nodeDistance + pathArray[temp.position][i]);
					nodeList[i].parent = temp.nodeName;
					nodeList[i].shortestPath = nodeList[i].nodeName;
					nodeQueue.add(nodeList[i]);
					
					String end = nodeList[i].nodeName;
					
					//updating the shortest path
					while(!end.equals(startingNode)) {
						for(int j = 0; j < numberOfNodes; j++) {
							if(nodeList[j].nodeName.equals(end)){
								end = nodeList[j].parent;
								nodeList[i].shortestPath = end + "->" + nodeList[i].shortestPath;
								break;
							}
						}
					}
				}
			}
		}
		// printing the output
		for(int i = 0; i < numberOfNodes; i++)
			if(nodeList[i].nodeDistance == 0)
				System.out.println(startingNode + ":0 ");
			else if(nodeList[i].nodeDistance == 9999)
				System.out.println(startingNode + "->" + nodeList[i].nodeName + ":9999");
			else
				System.out.println(nodeList[i].shortestPath + ":" + nodeList[i].nodeDistance);
	}

	// Defining the comparator
	public static Comparator<Node> valueComparator = new Comparator<Node>() {
		
		@Override
		public int compare(Node n1, Node n2) {
            return n2.nodeName.compareTo(n1.nodeName);
        }
	};
}