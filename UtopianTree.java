/*
The Utopian Tree goes through 2 cycles of growth every year. Each spring, it doubles in height.
Each summer, its height increases by 1 meter.

Laura plants a Utopian Tree sapling with a height of 1 meter at the onset of spring. 
How tall will her tree be after NN growth cycles?

Input Format

The first line contains an integer, TT, the number of test cases. 
TT subsequent lines each contain an integer, NN, denoting the number of cycles for that test case.

Constraints 
1≤T≤101≤T≤10 
0≤N≤600≤N≤60

Output Format

For each test case, print the height of the Utopian Tree after NN cycles. Each height must be printed on a new line.

Sample Input

3
0
1
4
Sample Output

1
2
7

*/

import java.io.*;
import java.util.*;

public class UtopianTree {

    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);
        int loops;
        int height;
        int cycleLength;
        int currentCycle;
        loops = Integer.parseInt(inputScanner.nextLine());
        for(int i = 0; i < loops; i++) {
        	height = 1;
        	cycleLength = Integer.parseInt(inputScanner.nextLine());
            currentCycle = 0;
            if(cycleLength != 0) {
              while(true) {
                currentCycle++;
                height = height * 2;
                if(currentCycle >= cycleLength)
                    break;
                currentCycle++;
                height = height + 1;
                if(currentCycle >= cycleLength)
                    break;
                }  
            }
            System.out.println(height);
        }  
    }
}