/*
Implement the Union-Find data structure given in the text book (Page no : 223).

There are two operations defined:

1. Union(U, V) means you need to add V as a child of U, which means joining two subsets into one.

2. Find(U) : takes an item and tells us what set it's in.

So, Given check(U, V) will tests whether two elements are in the same block amounts to comparing their respective 
representatives.



Input:

The first line contains the number of vertices.
From the second line onwards, you have union / check methods.
The last line of the input contains the word "end" which indicates EOI (End of Input).

Output:

Print the subsets / partitions of each and every node separated by a comma if union data structure occurs. 
Print "There is a Cycle" exists, if both (U,V) are on the same partition.
In case of check data structure, print "Yes" if they belong to the same block otherwise "No".



Input #1:

6
Union(1,2)
Union(3,4)
Check(1,3)
Union(1,5)
Check(2,5)
Union(1,5)
end

Output #1:

(1,2),(3),(4),(5),(6)
(1,2),(3,4),(5),(6)
No
(1,2,5),(3,4),(6)
Yes
There is a Cycle
*/
import java.util.*;
class UnionFind {
	public static void main(String[] args) {
		int noOfValues;
		String[] unions;
		String inputCommand = "";
		Scanner inputScanner = new Scanner(System.in);
		noOfValues = Integer.parseInt(inputScanner.nextLine());
		unions = new String[noOfValues];
		for(int i = 0; i < noOfValues; i++)
			unions[i] = (i + 1) + "";
		while(!(inputCommand = inputScanner.nextLine()).equals("end")) {
			StringTokenizer tokens = new StringTokenizer(inputCommand, "(,)");
			String command = "";
			int val1;
			int val2;
			while(tokens.hasMoreTokens()) {
				command = tokens.nextToken();
				if(command.equals("Union")) {
					val1 = Integer.parseInt(tokens.nextToken());
					val2 = Integer.parseInt(tokens.nextToken());
					for(int i = 0; i < noOfValues; i++) {
						if(unions[i].contains(val1 + "")) {
							if(unions[i].contains(val2 + ""))  {
								System.out.println("There is a Cycle");
								break;
							}
							else {
								for(int j = 0; j < noOfValues; j++) {
									if(unions[j].contains(val2 + "")) {
										unions[i] = unions[i] + "," + unions[j];
										unions[j] = "";
										for(int tempCount = 0; tempCount < noOfValues; tempCount++) {
											if(!unions[tempCount].equals("")) {
												System.out.print("(" + unions[tempCount] + ")");
												if(tempCount != (noOfValues - 1))
													System.out.print(",");	
											}
										}
										System.out.println();
										break;
									}
								}
							}
						}
					}
				}

				else if(command.equals("Check")) {
					val1 = Integer.parseInt(tokens.nextToken());
					val2 = Integer.parseInt(tokens.nextToken());
					for(int i = 0; i < noOfValues; i++) {
						if(unions[i].contains(val1 + "")) {
							if(unions[i].contains(val2 + "")) {
								System.out.println("Yes");
							}
							else
								System.out.println("No");
							break;
						}
					}
				}
				else
					for(int i = 0; i < noOfValues; i++)
						System.out.println(unions[i]);
			}
		}


	}
}