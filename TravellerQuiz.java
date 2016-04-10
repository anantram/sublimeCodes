/*
Problem

WizzAir, a travel company which pioneers in low cost air travel, wishes to identify the travel behavior of its customers before running a marketing campaign. 
Since WizzAir has a limited view of its customers, they approach Best Cards Company, a credit card company,
 who also specializes in providing critical insights out of a large volume of data. As a consultant of Best Cards 
 Company, you have to calculate the number of trips each customer has made in the past, 
 using the data for each transaction made on the credit card by the customer.

The word ‘trip’ indicates the travel of a person from his hometown to another town (or multiple towns), and back to his hometown. 
The data provided has information of only those transactions that were made using Best Card Company cards.

The data contains online and offline transactions. Online transaction is a payment method that is made on a website or a mobile device. 
For online transactions, it is not necessary that the customer is physically present in the mentioned city.

Considering the above factors, you have to develop logic to correctly identify the number of trips for each customer based on the data available.

Assumption
You have been provided with two datasets:

1) A travel dataset which contains the transaction level information for customer travel. 
The mode of travel can be air, cruise, bus or train.
The variables are in the following order, separated by a space:

Customer ID(Data Type - char), Travel Date(Date), Hometown(Char), Origin(Char), Destination(Char), Mode of travel(Char)

An example for a travel record is as follows:

0032610 17-Oct-15 HARRENHAL WALL LANNISPORT AIR

2) A transaction level dataset which includes all the transactions apart from travel. 
Merchant city is the city in which the transaction takes place. 
The online flag denotes whether a transaction was an online transaction. 
If the value of this variable is ‘Y’, then the transaction is an online transaction. 
Merchant description denotes the industry of the merchant – e.g. lodging, restaurants, etc.
The variables are in the following order, separated by a space:

Customer ID(Data Type - char), Transaction Date(Date), Hometown(Char), Merchant City(Char), Online Flag(Char), Merchant Description(Char)

e.g. 0087972 4-Aug-15 MYR MYR Y FURNISHINGS

Assumptions
If a customer has two transactions on the same day in different cities, then we consider the transactions as a part of one single trip.

Every transaction (travel or otherwise) is made by the customer for his own use. 
For example, if a customer has a movie transaction in his hometown (as shown in Example 1 below), the customer is the one who would be watching the movie.

Round trips are to be considered as one single trip only if the travel dates are separated by less than 30 days (as shown in Example 2 below).

In scenarios where there is information about only one (or multiple) leg(s) of the trip, but not the entire trip, consider such cases as a trip (or part of a trip). 
For example, it may be possible that a customer has used his Best Cards card to book a flight from his hometown to a city A. However, the customer might have used some other credit / debit card / cash to book his return flight from city A to his hometown. 
The same rule applies when a customer has no travel record in the data, but if there is any offline transaction from the customer in a city away from his hometown. Such a scenario should be considered as a trip (or part of a trip).

*/
import java.util.*;
import java.lang.*;
import java.text.*;

class Traveller{
	Date lastTravel;
	String homeTown;
	String source;
	String destination;
	String currentPlace;
	String mode;
	int trips;
	boolean isTripOver

	Traveller(Date lastTravel) {
		this.lastTravel = lastTravel;
		homeTown = "";
		source = "";
		currentPlace = "";
		trips = 1;
		mode = "";
		destination = "";
		isTripOver = false;

	}
	Traveller() {

	}

}
class TravellerQuiz {
	public static void main(String[] args) {
	//Taking inputs
		int noOfTransations = 0;
		String inputTransaction = "";
		Date tempDate = new Date();
		Hashtable travellers = new Hashtable();
		Traveller temp = new Traveller();
		Scanner input = new Scanner(System.in);
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");

		noOfTransations = Integer.parseInt(input.nextLine());
		for (int counter = 0; counter < noOfTransations; counter++) {
			StringTokenizer token = new StringTokenizer(input.nextLine());
			String user = token.nextToken();
			if(travellers.containsKey(user)) {
				temp = (Traveller)travellers.get(user);
				try { 
				 	temp.lastTravel = dateFormat.parse(token.nextToken());
      			} catch (ParseException e) { 
     				System.out.println(e);
     			}


			}
			else {
				//itial date added
				try { 
				 	tempDate = dateFormat.parse(token.nextToken());
      			} catch (ParseException e) { 
     				System.out.println(e);
     			}
				Traveller newTraveller = new Traveller(tempDate);
				//new traveller created
				newTraveller.homeTown = token.nextToken();
				//home location updated
				newTraveller.source = token.nextToken();
				//1st trip source added
				newTraveller.destination = token.nextToken();
				//1st trip destination added
				newTraveller.mode = token.nextToken();
				//1st trip mode added
				travellers.put(user, newTraveller);
				//new traveller added to list
			}
		}
	}
}
