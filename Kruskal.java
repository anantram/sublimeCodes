import java.util.*;
class Edge {
	String head;
	String tail;
	boolean visited;
	int edgeLength;

	Edge(String head, String tail, int edgeLength) {
		this.head = head;
		this.tail = tail;
		visited = false;
		this.edgeLength = edgeLength;
	}
}

class Kruskal {
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		//reading input
		String input = "";
		String[] nodes;
		boolean[][] visitStatus;
		int mainCounter = 0;
		int distance = 0;
		int numberOfEdges = 0;
		ArrayList <String> trees = new ArrayList<String>();
		Edge[] edges;
		Scanner inputScanner = new Scanner(System.in);
		StringTokenizer token;
		numberOfEdges = Integer.parseInt(inputScanner.nextLine());
		visitStatus = new boolean[numberOfEdges][numberOfEdges];
		nodes = new String[numberOfEdges];
		edges = new Edge[numberOfEdges * numberOfEdges];
		PriorityQueue mainQueue = new PriorityQueue(numberOfEdges, valueComparator);

		input = inputScanner.nextLine();
		token = new StringTokenizer(input,"(,)");
		while (token.hasMoreTokens()) {
			nodes[mainCounter] = token.nextToken();
			mainCounter++;
		}
		mainCounter = 0;
		//Creation of Edges
		for(int rowScan = 0; rowScan < numberOfEdges; rowScan++) {
			input = inputScanner.nextLine();
			token = new StringTokenizer(input);
			mainCounter = 0;  
			while(token.hasMoreTokens()) {
				
				if(rowScan != mainCounter) {
					Edge newEdge = new Edge(nodes[rowScan], nodes[mainCounter], Integer.parseInt(token.nextToken()));
					if(newEdge.edgeLength != 0)
						if(!visitStatus[rowScan][mainCounter]) {
							visitStatus[rowScan][mainCounter] = true;
							visitStatus[mainCounter][rowScan] = true;
							mainQueue.add(newEdge);
							
						}
				}
				else {
					int temp1 = Integer.parseInt(token.nextToken());
					
				mainCounter++;
				}
			}
		}
		boolean found = false;
		boolean tailFound = false;
		while(!mainQueue.isEmpty()) {
			Edge temp = (Edge)mainQueue.poll();
			for(int i = 0; i < trees.size(); i++) {
				if (trees.get(i).contains(temp.head)) {
					if(trees.get(i).contains(temp.tail)) {

					}
					else {
						tailFound = false;
						for (int tailSearch = 0; tailSearch < trees.size(); tailSearch++) {
							if(trees.get(tailSearch).contains(temp.tail)) {
								trees.set(i, trees.get(i) + " " + trees.get(tailSearch));
								trees.remove(tailSearch);
								System.out.println("(" + temp.head + "," + temp.tail + ")");
								distance = distance + temp.edgeLength;
								tailFound = true;
							}
						}
						if(!tailFound) {
							trees.set(i, trees.get(i) + " " + temp.tail);
							System.out.println("(" + temp.head + "," + temp.tail + ")");
							distance = distance + temp.edgeLength;
						}
					}
					found = true;
					break;
				}	
			}
			if(!found) {
				trees.add(temp.head + " " + temp.tail);
				System.out.println("(" + temp.head + "," + temp.tail + ")");
				distance = distance + temp.edgeLength;
			}
		}
		System.out.println(distance);

	}

	public static Comparator<Edge> valueComparator = new Comparator<Edge>() {
		
		@Override
		public int compare(Edge t1, Edge t2) {
            if(t1.edgeLength != t2.edgeLength)
            	return t1.edgeLength - t2.edgeLength;
        	else {
        		if(t1.head.equals(t2.head))
        			return t2.tail.compareTo(t1.tail);
        		else
        			return t2.head.compareTo(t1.head);
        	}
		}
	};
}