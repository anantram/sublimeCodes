import java.util.*;
import java.lang.*;
import java.text.*;

class Customer {
	Hashtable enrolledMerchants = new Hashtable();
	double totalAmount;
	Customer() {
		totalAmount = 0;
	}
	void addMerchant(Merchant newMerchant, String merchantName) {
		enrolledMerchants.put(merchantName, newMerchant);
	}
	boolean checkMerchant(String merchantName) {
		return enrolledMerchants.containsKey(merchantName);
	}

	void updateDetails(String merchantName, double amount,Date shoppingDate) {
		if(enrolledMerchants.containsKey(merchantName)) {
			Merchant temp = (Merchant)enrolledMerchants.get(merchantName);
			if(shoppingDate.after(temp.offerStart)) {
				if(shoppingDate.before(temp.offerEnd)) {
					temp.amount = temp.amount + amount;
					totalAmount = totalAmount + amount;
				}
			}
		}
		
		
	}

}

class Merchant {
	Date offerStart;
	Date offerEnd;
	double amount;
	String transactionType;
	Merchant(Date offerStart, Date offerEnd) {
		this.offerStart  = offerStart;
		this.offerEnd = offerEnd;
		amount = 0;
	}

}

class CustomerQuiz {
	public static void main(String[] args) {
		int noOfIterations = 0;
		String input = "";
		String tokenValue = "";
		String[] decoded = new String[6];
		String decodedChar = "";
		Hashtable customers = new Hashtable();
		Hashtable conversion = new Hashtable();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
		Enumeration names;

		conversion.put("6","0");
		conversion.put("8","1");
		conversion.put("9","2");
		conversion.put("1","3");
		conversion.put("0","4");
		conversion.put("2","5");
		conversion.put("4","6");
		conversion.put("3","7");
		conversion.put("5","8");
		conversion.put("7","9");
		Hashtable position = new Hashtable();
		position.put(3,0);
		position.put(4,1);
		position.put(1,2);
		position.put(5,3);
		position.put(0,4);
		position.put(2,5);


		Scanner inputScanner = new Scanner(System.in);
		StringTokenizer token;
		noOfIterations = Integer.parseInt(inputScanner.nextLine());
		for (int mainCount = 0; mainCount < noOfIterations; mainCount++) {
			input = inputScanner.nextLine();
			token = new StringTokenizer(input);
			tokenValue = token.nextToken();
			int newPositon = 0;
			for(int i = 0; i < 6; i++) {
				newPositon = (int)position.get(i);
				decodedChar = (String)conversion.get("" + tokenValue.charAt(i)); 
				decoded[newPositon] = decodedChar;
			}
			String decodedId = "";
			for(int i = 0; i < 6; i++)
				decodedId = decodedId + decoded[i];
			System.out.println(decodedId);
			
			//customer exists
			if(customers.containsKey(decodedId)) {
				Customer tempCustomer = (Customer)customers.get(decodedId);
				String newMerchantName = token.nextToken();
				String temp = token.nextToken();
				temp = token.nextToken();
				Date start = new Date();
				Date end = new Date();
				try { 
					 	start = dateFormat.parse(token.nextToken());
						end = dateFormat.parse(token.nextToken());
	      			} catch (ParseException e) { 
	     				System.out.println(e);
	     			}
	     		if(!tempCustomer.checkMerchant(newMerchantName)) {
	     			Merchant tempMerchant = new Merchant(start,end);
	     			tempCustomer.enrolledMerchants.put(newMerchantName, tempMerchant);
	     			names = tempCustomer.enrolledMerchants.keys();
      				while(names.hasMoreElements()) {
         				String str = (String) names.nextElement();
         				System.out.println(str);
      				}
	     		}
			}
			else {
				Customer newCustomer = new Customer();
				customers.put(decodedId,newCustomer);
				String newMerchantName = token.nextToken();
				String temp = token.nextToken();
				temp = token.nextToken();
				Date start = new Date();
				Date end = new Date();
				try { 
					 	start = dateFormat.parse(token.nextToken());
						end = dateFormat.parse(token.nextToken());
	      			} catch (ParseException e) { 
	     				System.out.println(e);
	     			}
	     		if(!newCustomer.checkMerchant(newMerchantName)) {
	     			Merchant tempMerchant = new Merchant(start,end);
	     			newCustomer.addMerchant(tempMerchant,newMerchantName);
	     		}
			}
		}
		noOfIterations = Integer.parseInt(inputScanner.nextLine());
		for (int mainCount = 0; mainCount < noOfIterations; mainCount++) {
			input = inputScanner.nextLine();
			token = new StringTokenizer(input);
			tokenValue = token.nextToken();
			Customer tempCustomer = new Customer();
			tempCustomer = (Customer)customers.get(tokenValue);
			String tempMerchant = token.nextToken();
			Date tempDate = new Date();
			try {
				tempDate = dateFormat.parse(token.nextToken());
			} catch(ParseException e) { 
	     				System.out.println(e);
	     	}
			
			double tempAmount = Double.parseDouble(token.nextToken());
			tempCustomer.updateDetails(tokenValue, tempAmount, tempDate);
		}
		names = customers.keys();
			while(names.hasMoreElements()) {
				Customer temp = new Customer();
				String str = (String) names.nextElement();
				temp = (Customer)customers.get(str);


				System.out.println(temp.totalAmount);
			}


	}
}