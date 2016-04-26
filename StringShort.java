import java.io.*;
import java.util.*;

public class StringShort {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner inputScanner = new Scanner(System.in);
        ArrayList<String> inputArray = new ArrayList<String>();
        String current;
        String input = inputScanner.nextLine();
        for(int i = 0; i < input.length(); i++)
        	inputArray.add("" + input.charAt(i));

        String outputString = "";
        int repeat = 0;
       boolean uniqueFound = false;
        while(true) {
        	current = inputArray.get(0);
        	repeat = 0;
        	uniqueFound = true;
        	for(int i = 1; i < inputArray.size(); i++) {
        		if(inputArray.get(i).equals(current)) {
        			uniqueFound = false;
        			inputArray.remove(i);
        			repeat++;
        			if(repeat == 1)
        				if(inputArray.size() > 0)
        					inputArray.remove(i - 1);
        		}
        		else {
        			current = inputArray.get(i);
        			repeat = 0;
        		}
        	}
        	if(uniqueFound)
        		break;
        	if(inputArray.size() == 0)
        		break;
        }
        if(inputArray.size() != 0)
        	for(int i = 0; i < inputArray.size(); i++)
        	System.out.print(inputArray.get(i));
        else
        	System.out.println("Empty String");
    }
}