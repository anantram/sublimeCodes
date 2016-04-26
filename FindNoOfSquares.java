/*
Watson gives two integers (AA and BB) to Sherlock and asks if he can count the number of square integers between AA and BB (both inclusive).

Note: A square integer is an integer which is the square of any integer. For example, 1, 4, 9, and 16 are some of the square integers as they are squares of 1, 2, 3, and 4, respectively.

Input Format 
The first line contains TT, the number of test cases. TT test cases follow, each in a new line. 
Each test case contains two space-separated integers denoting AA and BB.

Output Format 
For each test case, print the required answer in a new line.

Constraints 
1≤T≤1001≤T≤100 
1≤A≤B≤1091≤A≤B≤109

Sample Input

2
3 9
17 24
Sample output

2
0
Explanation 
Test Case #00: In range [3,9][3,9], 44 and 99 are the two square numbers. 
Test Case #01: In range [17,24][17,24], there are no square numbers.


*/
import java.util.*;
class FindNoOfSquares {
	public static void main(String[] args) {
		Scanner inputScanner = new Scanner(System.in);
		String input;
		int count;
		int inputNumber;
		int start;
		int end;
		int sum;
		int temp = 0;
		int temp2 = 0;
		ArrayList <Integer> sumDigits = new ArrayList<Integer>();
		count = Integer.parseInt(inputScanner.nextLine());
		for(int i = 0; i < count; count++) {
			input = inputScanner.nextLine();
			StringTokenizer token = new StringTokenizer(input);
			start = Integer.parseInt(token.nextToken());
			end = Integer.parseInt(token.nextToken());
			for(int check = start; check <= end; check++) {

				if(check % 10 == 1 || check % 10 == 4 ||check % 10 == 5 ||check % 10 == 6 ||check % 10 == 9) {
					sum = 0;
					temp2 = check;
					while(check > 9) {
						sum = sum + check % 10;
						check = check / 10;
					}
					sum = sum + check;
					check = temp2;
					System.out.println("sum of " + check + " " + sum);
					do {
						sumDigits.clear();
						while(true) {
							if(sum < 10) {;
								sumDigits.add(sum);
								temp = temp + sum;
								System.out.println("inner loop single digit" + temp);
								break;
							}
							else {
								sumDigits.add(sum % 10);
								temp = sum % 10;
								sum = sum / 10;
								System.out.println("inner loop" + temp);
							}
						}
						sum = temp;
						System.out.println("loop" + sum);
						temp = 0;
						System.out.println("Size of array " + sumDigits.size());

					}while(sumDigits.size() > 1);

					System.out.println("exit loop" + check + " sum" + sum);
					if(sum == 1 || sum == 4 || sum == 5 || sum == 6 || sum == 7 || sum == 9)
						System.out.println(check);
				}
			}
		}
	}
}