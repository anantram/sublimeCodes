/*
Nikita has a line of NN tiles indexed from 00 to N−1N−1. She wants to paint them to match a color configuration, CC, which is comprised of 22 colors: Red(R)Red(R) and Blue(B)Blue(B).

In one stroke, Nikita can paint 11 or more adjacent tiles a single color. After she finishes painting, each tile ii should be painted color CiCi.

It should be noted that it is not allowed to apply more than 11 stroke on a tile.

Given the required color configuration, find and print the minimum number of strokes required for Nikita to paint all NN tiles.

Note: In a line of tiles, 22 tiles with the indices ii and jj are considered adjacent only if |j−i|=1|j−i|=1.

Input Format

The first line contains a single integer, NN, denoting the number of tiles to be painted. 
The second line contains a string, CC, denoting the desired color configuration.

For each character CiCi in CC:

If Ci="R"Ci="R", it means the ithith tile must be painted red.
If Ci="B"Ci="B", it means the ithith tile must be painted blue.
Constraints

1≤N≤10001≤N≤1000
Ci∈{"R", "B"}Ci∈{"R", "B"}
Output Format

Print the minimum number of strokes required to paint all NN tiles in the desired color configuration.

Sample Input 0

5  
RRRRR
Sample Output 0

1
Sample Input 1

5  
RRBRR
Sample Output 1

3
Sample Input 2

5  
BRBRB
Sample Output 2

5

B = true;
R = false;
*/
import java.util.*;
class PaintItRed {
	public static void main(String[] args) {
		Scanner inputScanner = new Scanner(System.in);
		int noOfTiles;
		int steps = 1;
		String input;
		noOfTiles = Integer.parseInt(inputScanner.nextLine());
		input = inputScanner.nextLine();
		char current = input.charAt(0);
		for(int i = 1; i < input.length(); i++) {
			if(input.charAt(i) != current) {
				steps++;
				current = input.charAt(i);
			}
		}
		System.out.println(steps);
	}
}
