/*
The best example for lossless compression is Huffman coding. 
Implement the Huffman coding algorithm using greedy method.

Refer to the program given in the following link.
https://en.wikipedia.org/wiki/Huffman_coding

Input:

The first line contains the number of characters.

From the second line onwards there will be a character along with the frequency.
They are separated by spaces.

Output:

Output of each line should contains the character along with the codes.
(Sort the codes based on the length, if tie, follow the lexicographic order for characters)
The last line of the output contains the total number of bits required.

Sample Input:

6
a 12
b 2
c 7
d 13
e 14
f 85

Sample Output:

f: 1
a: 001
d: 010
e: 011
b: 0000
c: 0001
238
*/
import java.util.*;
import java.lang.*;

class Node {
	String character;
	ArrayList<Boolean> path;
	boolean isleft;
	int frequency;
	Node leftSmall;
	Node rightlarge;
	Node parent;

	Node(String character, int frequency) {
		this.character = character;
		this.frequency = frequency;
		path = new ArrayList<Boolean>();
		leftSmall = null;
		rightlarge = null;
		parent = null;
		isleft = false;
	}
}

class Huffman2 {

	public static Comparator<Node> valueComparator = new Comparator<Node>() {
		
		@Override
		public int compare(Node t1, Node t2) {
            return t1.frequency - t2.frequency;
		}
	};

	static int noOfNodes = 2;
	static ArrayList<Node> nodeList = new ArrayList();
	static PriorityQueue queue = new PriorityQueue(noOfNodes, valueComparator);

	public static void main(String[] args) {
		inputReading();
		while(queue.size() != 1)
			mergeNode();
		Node tempRoot = new Node("",0);
		tempRoot = (Node)queue.poll();
		traverse(tempRoot);
	}

	public static void inputReading() {
		Scanner inputScanner = new Scanner(System.in);
		StringTokenizer token;
		noOfNodes = Integer.parseInt(inputScanner.nextLine());
		for(int i = 0; i < noOfNodes; i++) {
			token = new StringTokenizer(inputScanner.nextLine());
			String nodeName = token.nextToken();
			Node newNode = new Node(nodeName, Integer.parseInt(token.nextToken()));
			queue.add(newNode);
			nodeList.add(newNode);
		}
	}

	public static void mergeNode() {
		Node tempsmall = (Node)queue.poll();
		Node templarge = (Node)queue.poll();
		Node sumNode = new Node("",tempsmall.frequency + templarge.frequency);
		sumNode.leftSmall = tempsmall;
		tempsmall.isleft = false;
		tempsmall.parent = sumNode;
		sumNode.rightlarge = templarge;
		templarge.isleft = true;
		templarge.parent = sumNode;
		nodeList.add(sumNode);
		queue.add(sumNode);
		
	}

	public static void traverse(Node root) {
		Stack traverse = new Stack();
		ArrayList<Boolean> traversedPath = new ArrayList<Boolean>();
		traverse.push(root.rightlarge);
		traverse.push(root.leftSmall);
		do {
			Node temp = new Node("",0);
			temp = (Node)traverse.pop();
			traversedPath.add(temp.isleft);
			if(temp.leftSmall != null) {
				traverse.push(temp.rightlarge);
				traverse.push(temp.leftSmall);
			}
			else {

				System.out.print(temp.character + " ");
				for(int k = 0; k < traversedPath.size(); k++)
					if(traversedPath.get(k))
						System.out.print("1");
					else
						System.out.print("0");
				System.out.println();
				if(temp.isleft) {
					while(temp.isleft) {
						if(traversedPath.size() >= 1) {
							traversedPath.remove((traversedPath.size() - 1));
							if(temp.parent != null)
								temp = temp.parent;
						}
						else {
							break;
						}
					}
					if(traversedPath.size() >= 1)
						traversedPath.remove((traversedPath.size() - 1));
				}
				else
					traversedPath.remove((traversedPath.size() - 1));	
			}
		}while(!traverse.isEmpty());
	}
}
