/*
A small code to show all the functionalites for a user authentication system
*/
import java.util.*;
class UserDetails {
	private String userName;
	private String userPass;
	private String userQue;
	private String userAnser;
	private boolean locked;
	UserDetails(String userName, String userPass, String userQue, String userAnser) {
		this.userName = userName;
		this.userPass = userPass;
		this.userQue = userQue;
		this.userAnser = userAnser;
		locked = false;
	}
	void lockUser() {
		locked = true;
	}
	boolean checkStatus() {
		return locked;
	}

	String getUser() {
		return userName;
	}
	boolean checkAuthentication(String pass) {
		if(!locked) {
			if(pass.equals(userPass))
				return true;
			else
				return false;
		}
		else {
			System.out.println("The account is locked");
			return false;
		}
	}

	void forgetPass() {
		System.out.println("question is " + userQue);
		Scanner s1 = new Scanner(System.in);
		if(userAnser.equals(s1.nextLine())) {
			System.out.println("enter new password");
			userPass = s1.nextLine();
			locked = false;
		}
		else
			System.out.println("worng answer");
	}
}

class Authentication {
	public static void main(String[] args) {
		ArrayList<UserDetails> users = new ArrayList<UserDetails>();
		Scanner inputScanner = new Scanner(System.in);
		int inputSelection = 0;
		while(true) {
			System.out.println();
			System.out.println("***********************************");
			System.out.println("Welcome to user authentication system");
			System.out.println("1. New Registration");
			System.out.println("2. Login");
			System.out.println("3. Exit");
			try {
				inputSelection = Integer.parseInt(inputScanner.nextLine());
			}
			catch(NumberFormatException e) {
				System.out.println("Please enter valid input");
			}
			if(inputSelection == 3)
				break;

			else if(inputSelection == 1) {
				String nameInput, passInput, quesInput, ansInput,temp2 = "";
				do{ System.out.print("Enter new user name: ");
					nameInput = inputScanner.nextLine();
				}while (!nameInput.equals(""));

				do{	System.out.print("Enter password: ");
					passInput = inputScanner.nextLine();
					if(!passInput.equals("")) {
						System.out.print("Again enter password: ");
						temp2 = inputScanner.nextLine();
						System.out.println();
						if(!temp2.equals(passInput))
							System.out.println("Password mismatched");
					}
					else {
						System.out.println("Blank Input");
						passInput = "!";
					}
				}while(!temp2.equals(passInput));
				
				do {
					System.out.print("Enter your security question: ");
					quesInput = inputScanner.nextLine();
				}while(!quesInput.equals(""));
				
				do {
					System.out.print("Enter your security answer: ");
					ansInput = inputScanner.nextLine();
				}while(!ansInput.equals(""));
				UserDetails newUser = new UserDetails(nameInput,passInput,quesInput,ansInput);
				users.add(newUser);
				System.out.println("New User Created");
			}

			else if(inputSelection == 2) {
				String temp = "";
				System.out.print("Enter user name: ");
				temp = inputScanner.nextLine();
				boolean found = false;
				int position = 0;
				for(position = 0; position < users.size(); position++) {
					if(users.get(position).getUser().equals(temp)) {
						found = true;
						break;
					}
				}
				if(found) {
					if(!users.get(position).checkStatus()) {
						found = false;
						System.out.println("Enter Password: ");
						if(users.get(position).checkAuthentication(inputScanner.nextLine())) {
							System.out.println("Welcome");
						}
						else {
							for(int trails = 0; trails < 2; trails++) {
								System.out.println("Re enter password");
								if(users.get(position).checkAuthentication(inputScanner.nextLine())) {
									System.out.println("Welcome");
									System.out.println();
									found = true;
									break;
								}
							}
							if(!found)
							users.get(position).lockUser();
						}	
					}
					else {
						System.out.println("The account is locked");
						System.out.println("1. Unlock");
						System.out.println("2. Exit");
						if(inputScanner.nextLine().equals("1"))
							users.get(position).forgetPass();
					}
				}
				else
					System.out.println("user not present");
			}
			else {
				System.out.println("Enter correct option");
			}
		}
	}
}
