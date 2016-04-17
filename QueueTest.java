/*
Testcode to test wether the nodes present in a queue can be change externally.
*/

import java.util.*;
class QueueTest {
	public static void main(String[] args) {
		TestNode[] nodeList = new TestNode[4];
		PriorityQueue testQueue = new PriorityQueue(4, comparator);
		for(int i = 0; i < 4; i++) {
			TestNode node = new TestNode("" + i, i);
			nodeList[i] = node;
			testQueue.add(node);
		}
		nodeList[2].value = 6;
		while(!testQueue.isEmpty()) {
			TestNode abc = (TestNode)testQueue.poll();
			System.out.println(abc.value);
		}

	}

	public static Comparator<TestNode> comparator = new Comparator<TestNode>() {
		
		@Override
		public int compare(TestNode t1, TestNode t2) {
            if(t1.value != t2.value)
            	return t1.value - t2.value;
        	else
        		return t2.name.compareTo(t1.name);
		}
	};
}

class TestNode {
	String name;
	int value;

	TestNode(String name, int value) {
		this.name = name;
		this.value = value;
	}
}
