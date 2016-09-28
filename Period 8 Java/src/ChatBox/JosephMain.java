package ChatBox;

import java.util.Scanner;

public class JosephMain {
	static Scanner input;
	static String user;
	static boolean inMainLoop;
	static String response;
	static ChatBot school;

	public static void main(String[] args) {
		// demonstateStringMethods();
		createFields();
		String s1 = ".";
		String s2 = "a";

		System.out.println(s1.compareTo(s2));
		createAScanner();
		promptName();
		talkForever();
	}

	public static void createAScanner() {
		input = new Scanner(System.in);
	}

	public static void promptName() {
		print("Hello human. I am a board. What is yur name?");
		user = input.nextLine();
		print("Hello " + user + ".");
	}

	public static void talkForever() {
		inMainLoop = true;
		while (inMainLoop) {
			print("Hi, " + user + " How are you?");
			response = promptInput();
			if (findKeyword(response, "good", 0) >= 0) {
				print("That's wonderful.");
			} else if (response.indexOf("school") >= 0) {
				print("Schools great! Tell me more.");
				// exit this while loop
				inMainLoop = false;
				// go to the schools talk method
				school.talk();
			} else {
				print("I don't understand");
			}
		}
	}

	public static int findKeyword(String searchString, String keyword, int StartPsn) {
		// delete White space
		searchString = searchString.trim();
		// make lowercase
		searchString = searchString.toLowerCase();
		keyword = keyword.toLowerCase();
		// find first position of key word
		int psn = searchString.indexOf(keyword);
		// keep searching until context keyword found
		while (psn >= 0) {
			// assume preceeded and followed by space
			String before = " ";
			String after = " ";
			// check character in front if it exists
			if (psn > 0) {
				before = searchString.substring(psn - 1, psn);
			}
			// check if there is a character after keyword
			if (psn + keyword.length() < searchString.length()) {
				after = searchString.substring(psn + keyword.length(), psn + keyword.length() + 1);
			}

			if (before.compareTo("a") < 0 && after.compareTo("a") < 0 && noNegations(searchString, psn)) {
				return psn;
			}
			
			else {
				// psn+1 is one space after our current
				// psn, so this finds the NEXT word.
				psn = searchString.indexOf(keyword, psn + 1);
			}
		}

		return -1;
	}

	//This is a helper method.  A helper method is a method designed for 
	//helping a larger method because of this helper methods are generally 
	//private because they are only used by the methods they are helping.  
	//Also when you do your project, I expect to see helper methods because 
	//they also make the code more readable.
	//return true id there is no negation words in front of position/psn
	private static boolean noNegations(String searchString, int psn) {
		//check to see if the word no is in front of psn
		//check to see if there are 3 spaces in front then check to see if "no" is there
		if(psn -3 >= 0 && searchString.substring(psn-3,psn).equals("no ")){
			return false;
		}
		//check for not
		if(psn -4 >= 0 && searchString.substring(psn-4,psn).equals("not ")){
			return false;
		}
		//check for never
		if(psn -6 >= 0 && searchString.substring(psn-6,psn).equals("never ")){
			return false;
		}
		//check for n't
		if(psn -4 >= 0 && searchString.substring(psn-4,psn).equals("n't ")){
			return false;
		}
		return true;
	}

	public static String promptInput() {
		String userInput = input.nextLine();
		return userInput;
	}

	public static void createFields() {
		input = new Scanner(System.in);
	}

	public static void print(String s) {
		String printString = "";
		int cutoff = 35;
		// check for words to add
		// IOW s has a length > 0
		while (s.length() > 0) {
			String cut = " ";
			String nextWord = "";
			// check to see if the next word will fit on the line AND there must
			// still be words to add
			while (cut.length() + nextWord.length() < cutoff && s.length() > 0) {
				// add the next word to the line
				cut += nextWord;

				s = s.substring(nextWord.length());

				// identify the following word without the space
				int endOfWord = s.indexOf(" ");
				// if there are no more spaces, this is the last word, so add
				// the whole thing
				if (endOfWord == -1) {
					endOfWord = s.length() - 1;// -1 for index
				}

				nextWord = s.substring(0, endOfWord + 1);
			}

			printString += cut + "\n";
		}
		System.out.println(printString);
	}
	
	public boolean isTriggered(String userInput) {
		return false;
	}
}
