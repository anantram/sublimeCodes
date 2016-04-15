/*
testing of pirority Queue
*/

import java.util.*;
class NewNode {
	String name;
	int value;
	NewNode(String name, int value) {
		this.name = name;
		this.value = value;
	}
}

class pirority {
	public static void main(String[] args) {
		PriorityQueue pq = new PriorityQueue(4,valueComparator);
		NewNode node1 = new NewNode("AB", 2);
		NewNode node2 = new NewNode("AB", 1);
		NewNode node3 = new NewNode("AA", 2);

		// testnode testnode1 = new testnode(4);
		// testnode testnode2 = new testnode(3);
		pq.add(node1);
		NewNode temp = new NewNode("da",2);
		temp = (NewNode)pq.peek();
		System.out.println(temp.name);
		pq.add(node2);
		temp = (NewNode)pq.peek();
		System.out.println(temp.name);
		pq.add(node3);
		temp = (NewNode)pq.peek();
		System.out.println(temp.name);
		for(int i =0; i < 3; i++) {

			temp = (NewNode)pq.poll();
			System.out.println(temp.name + " ; " + temp.value);
		}
		
	}
	// providing an example for comparision
	public static Comparator<NewNode> valueComparator = new Comparator<NewNode>() {
		
		@Override
		public int compare(NewNode t1, NewNode t2) {
            if(t1.value != t2.value)
            	return t1.value - t2.value;
        	else
        		return t2.name.compareTo(t1.name);
		}
	};
}

class testnode {
	String name;
	int value;
	testnode(int value) {
		name = "a";
		this.value = value;
	}
}