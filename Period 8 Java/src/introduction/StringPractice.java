package introduction;

import java.util.Scanner;

public class StringPractice {
	
	static Scanner input;
	static String user;
	static int lineCount;

	public static void main(String[] args) {
		createAScanner();
		
		lineCount = 0;
		
		promptName();
		talkForever();
	}	

	public static void createAScanner() {
		input = new Scanner(System.in);
	}

	public static void promptName() {
		print("Hello human. I am a board. What is your name?");
		user = input.nextLine();
		print("Hello " + user + ".");
	}

	public static void talkForever() {
		while(true) promptInput();
	}

	public static void promptInput() {
		print("Try inputting a string. " + user);
		String userInput = input.nextLine();
		
		print("You typed: " + userInput);
	}


	public static void print(String s) {
		String printString = "";
		int cutoff = 35;
		//check for words to add
		//IOW s has a length > 0
		while(s.length() > 0){
			String cut = " ";
			String nextWord = "";
			//check to see if the next word will fit on the line AND there must still be words to add
			while(cut.length() + nextWord.length() < cutoff && s.length() > 0){
				//add the next word to the line
				cut += nextWord;
				
				s = s.substring(nextWord.length());
				
				//identify the following word without the space
				int endOfWord = s.indexOf(" ");
				//if there are no more spaces, this is the last word, so add the whole thing
				if(endOfWord == -1){
					endOfWord = s.length() - 1;//-1 for index
				}
				
				nextWord = s.substring(0,  endOfWord + 1);
			}
			
			printString += cut + "\n";
		}
		System.out.println(printString);
		}
}
