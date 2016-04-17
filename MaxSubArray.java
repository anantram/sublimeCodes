/*
Write a program to find the maximum sum of contiguous subarray for a given one dimensional array of elements.

Input:

The first line contains the elements that are separated by commas

Output:

First line contains the maximum sum of contiguous subarray.
Second line contains the subarray elements.



If the maximum sum is <0, then print "0" in the first line and "Maximum sum is less than 0." 
in the second line without double quotes.

Sample Input:

1,2,3,4,5

Sample Output:

15
1,2,3,4,5

*/


import java.util.*;

class MaxSubArray {
	public static void main(String[] args) {
		ArrayList<Integer> subArray  = new ArrayList<Integer>();
		ArrayList<Integer> maxSubArray  = new ArrayList<Integer>();
		Hashtable mainArray = new Hashtable();
		PriorityQueue minFind = new PriorityQueue();
		Scanner inputScanner = new Scanner(System.in);
		int temp = 0;
		int sum = 0;
		int maxSum = 0;
		String input = inputScanner.nextLine();
		StringTokenizer token = new StringTokenizer(input, ",");
		while(token.hasMoreTokens()) {
			temp = Integer.parseInt(token.nextToken());
			mainArray.put(temp, "");
			minFind.add(temp);
		}

		while(!minFind.isEmpty()) {
			int currentmin = (int)minFind.poll();
			subArray.clear();
			subArray.add(currentmin);
			int next = currentmin + 1;
			sum = currentmin;
			while(true) {
				if(mainArray.containsKey(next)) {
					sum = sum + next;
					subArray.add(next);
					next = next + 1;
				}
				else
					break;
			}
			if(sum > maxSum) {
				maxSubArray.clear();
				for(int i = 0; i < subArray.size(); i++)
					maxSubArray.add(subArray.get(i));
				maxSum = sum;
			}
		}
		System.out.println(maxSum);
		for(int i = 0; i < maxSubArray.size(); i++)
			if(i != maxSubArray.size() - 1)
				System.out.print(maxSubArray.get(i) + ",");
			else
				System.out.print(maxSubArray.get(i));
	}
}