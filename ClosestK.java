/*
You have been given an Array A of size N. The array contains integers . 
You have also been given a number K. You need to print the number with value closest to K . 
If there are multiple candidates, print the number with greater value.

Input Format:

The first line contains two integers N and K denoting the size of the array A and the number K. 
The next line contains N integers denoting the elements of array A.

Output Format:

You need to print the element with value closest to K. 
If there are multiple candidiates, print the number with greater value.

Constraints:

1<=N<=100

1<=| Ai |<=100

Sample Input
5 1
1 2 3 4 5
Sample Output
 1
*/


import java.util.*;
class ClosestK {
    public static void main(String args[] ) throws Exception {

	int arraySize = 0;
	int checkValue = 0;
	int lowerValue = 1;
	int higherValue = 101;
	boolean isExact = false;
	int[] inputArray;
	Scanner inputScanner = new Scanner(System.in);
	StringTokenizer token = new StringTokenizer(inputScanner.nextLine());
	try{
		arraySize = Integer.parseInt(token.nextToken());
		checkValue = Integer.parseInt(token.nextToken());
	}
	catch(NumberFormatException e) {
		System.out.println(e);
	}
	inputArray = new int[arraySize];
	token = new StringTokenizer(inputScanner.nextLine());
	int temp = 0;
	while(token.hasMoreTokens()) {
		try{
			inputArray[temp] = Integer.parseInt(token.nextToken());
		}
		catch(NumberFormatException e) {
			System.out.println(e);
		}
	temp++;
	}
	for (int mainCount = 0; mainCount < arraySize; mainCount++) {
		if(inputArray[mainCount] < checkValue) {
			if(inputArray[mainCount] > lowerValue)
				lowerValue = inputArray[mainCount];
		}
		else if(inputArray[mainCount] > checkValue) {
			if(inputArray[mainCount] < higherValue)
				higherValue = inputArray[mainCount];
		}
		else
			isExact = true;
	}
	if(!isExact) {
		if((higherValue - checkValue) < (checkValue - lowerValue))
			System.out.println(lowerValue);
		else
			System.out.println(higherValue);
	}
	else
		System.out.println(checkValue);
    }
}
