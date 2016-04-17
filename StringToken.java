/*
Given a string, find number of words in that string. 
For this problem a word is defined by a string of one or more english alphabets.

There are multiple ways to tokenize a string in java, learn how to tokenize a string in java and demonstrate your skill by solving this problem!

Input Format
A string not more than 400000 characters long. The string can be defined by following regular expression:

[A-Za-z !,?.\_'@]+
That means the string will only contain english alphabets, blank spaces and this characters: "!,?._'@".

Output Format
In the first line, print number of words nn in the string. The words don't need to be unique. In the next nn lines, print all the words you found in the order they appeared in the input.

Sample Input

He is a very very good boy, isn't he?
Sample Output

10
He
is
a
very
very
good
boy
isn
t
he
*/

import java.util.*;

class StringToken {
	public static void main(String[] args) {
		Scanner inputScanner = new Scanner(System.in);
		ArrayList<String> inputWords = new ArrayList<String>();
		String input = inputScanner.nextLine();
		StringTokenizer token = new StringTokenizer(input, "!,?._'@ ");
		while(token.hasMoreTokens()) {
			inputWords.add(token.nextToken());
		}
		System.out.println(inputWords.size());
		for(int i = 0; i < inputWords.size(); i++)
			System.out.println(inputWords.get(i));
	}
}