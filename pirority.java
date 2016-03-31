/*
testing of pirority Queue
*/

import java.util.*;

class pirority {
	public static void main(String[] args) {
		PriorityQueue pq = new PriorityQueue(4,valueComparator);
		testnode testnode1 = new testnode(4);
		testnode testnode2 = new testnode(3);
		pq.add(testnode1);
		System.out.println(pq.peek());
		pq.add(testnode2);
		System.out.println(pq.peek());
		pq.add(testnode1);
		System.out.println(pq.peek());
		System.out.println(pq);
	}
	// providing an example for comparision
	public static Comparator<testnode> valueComparator = new Comparator<testnode>() {
		
		@Override
		public int compare(testnode t1, testnode t2) {
            return t1.value - t2.value;
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