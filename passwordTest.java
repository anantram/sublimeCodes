import java.util.*;
import java.io.*;
class passwordTest {
	public static void main(String[] args) {
		Console c = System.console();
		String temp = "";
		printArray(c.readPassword());
	}
	static void printArray(char[] inArray) {
		for(int i = 0; i < inArray.length; i++)
			System.out.println(inArray[i]);
	}
}