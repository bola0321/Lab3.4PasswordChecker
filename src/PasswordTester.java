import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PasswordTester {

	static ArrayList<String> passwordList = new ArrayList<>();

	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);

		System.out.print("Please enter a password with the following parameters: " + "\n");

		String userInput = scnr.nextLine();

		System.out.println(addPassword(userInput));

	}

	public static boolean addPassword(String password) {
		// create char array and char list to use later
		char[] passwordChar = password.toCharArray();
		List<Character> passwordCharList = new ArrayList<>();
		for (char character : passwordChar) {
			passwordCharList.add(character);
		}

		// check if list already contains password
		if (passwordList.contains(password)) {
			return false;
		}
		// check if password is admin or mod. those are fine. add to password list and
		// exit the method
		if (password.equals("admin") || password.equals("mod")) {
			passwordList.add(password);
			return true;
		}

		// check password length is between 7-12 chars
		if (password.length() < 6 || password.length() > 12) {
			
			return false;

			// check if char list contains ' '.
		}
		if (passwordCharList.contains(' ')) {
			return false;
		}

		// check if char list contains 6
		if (passwordCharList.contains('6')) {
			return false;
		}

		// create list with wanted numbers and check to see if password has one of them

		List<Character> numsList = List.of('1', '2', '3', '4', '5', '7', '8', '9', '0');
		boolean foundNum = false;
		for (int i = 0; i <= password.length() - 1; i++) {
			if (numsList.contains(password.charAt(i))) {
				foundNum = true;
				break;
			}
		}
		if (foundNum == false) {
			System.out.println("foundNum == false");
			return false;
		}

		// check to see if capital vowels. when one is encountered, increase tally
		// variable.
		int vowelTally = 0;
		List<Character> capVow = List.of('A', 'E', 'I', 'O', 'U', 'Y');
		for (int i = 0; i <= password.length() - 1; i++) {
			if (capVow.contains(password.charAt(i))) {
				vowelTally += 1;
			}
		}

		if (vowelTally < 2) {
			return false;

		}

		passwordList.add(password);
		return true;
	}

}
