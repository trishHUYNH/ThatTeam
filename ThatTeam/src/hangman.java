import java.util.*;
import java.io.*;

public class hangman{
	int captive = 0;
	boolean people[] = {true, true, true, true, true};

	public static void main(String[] args)throws FileNotFoundException{
	String[] wordarray = hangmanArray();
	boolean wanttoplay = true;
	int numberOfGames = 0;
	int numberOfGamesWon = 0;
	double percentageWon = 0.0;
	System.out.println("Guess the name of That Team's member hanging! (Capitalization matters!)");
	while (wanttoplay){
		numberOfGames++;
		
		boolean success = gamelogistics(wordarray);
		if (success){
		numberOfGamesWon++;
		System.out.println("YOU ARE THE BEST!!!!");
		}else {
		System.out.println("You have failed!");
		//people[captive] = false;
		}
		wanttoplay = playAgain();
		}
		System.out.println("total games = " + numberOfGames);
		System.out.println("total wins = " + numberOfGamesWon);
		percentageWon = (((double) numberOfGamesWon)/((double)numberOfGames)*100);
		System.out.printf("winning percentage = %.0f%%\n", percentageWon);
		
	}
	
	
	public static boolean gamelogistics(String[] wordarray)throws FileNotFoundException {
	
	Scanner console = new Scanner(System.in);
	boolean success = false;
	boolean failed = false;
	
	int numberOfGuesses = 0;
	Random rand = new Random();
	int randomnumber = rand.nextInt(wordarray.length);	
	String gameword = wordarray[randomnumber];
	String guessedletters = "";
	String gletter = "";
	char letter = ' ';
	
	while (!success && !failed){
	
	
	guessedletters(gameword,guessedletters);
	drawing(numberOfGuesses);
	System.out.println("Incorrect guesses = " + numberOfGuesses);
	System.out.println(guessedletters);
	System.out.println();
	gletter = console.nextLine();
	letter = gletter.charAt(0);
	if (accidentPrevention(letter,guessedletters)){
		guessedletters = guessedletters + letter;
		if(!checkLetter(letter,gameword)){
		numberOfGuesses++;
		}
	}
	if (numberOfGuesses>6){
		failed = true;
		System.out.println("The correct word was: " + gameword);
		return false;
	}
	success = victorycondition(gameword, guessedletters);
	
	}
	System.out.println(gameword);
	System.out.println("You won in " + numberOfGuesses + " guesses.");
	return true;
	}
	
	public static boolean accidentPrevention(char a, String guessedletters){
		for (int i=0;i<guessedletters.length();i++){
			if(guessedletters.charAt(i) == a){
				return false;
			}
		}
		return true;
	}
	
	
	
	
	
	public static void guessedletters(String gameword, String guessedletters){
		for(int i=0;i<gameword.length();i++){
			boolean attemptedL = false;
			
			for(int j=0;j<guessedletters.length();j++){
				if(gameword.charAt(i) == guessedletters.charAt(j)){
					System.out.print(guessedletters.charAt(j));
					attemptedL = true;
				}
				
			}if(attemptedL == false){
				System.out.print(".");
		}
	
	}
	}
	
	
	public static String[] hangmanArray()throws FileNotFoundException {
// 	Scanner input = new Scanner(new File("hangman.txt"));
   	int count = 0;
// 	while(input.hasNextLine()){
// 		input.nextLine();
// 		count++;
// 	}
// 	input = new Scanner(new File("hangman.txt"));
   	String[] words = new String[count];
// 	for(int i=0;i<count;i++){
// 	words[i] = input.nextLine();
// 	}
	words = new String[5];
	words[0] = "Brandon Thomas";
	words[1] = "Daniel Grey";
	words[2] = "Trish Huynh";
	words[3] = "James Brewer";
	words[4] = "Mika Kaur";
	return words;
	}
	
	public static void drawing(int n){
		System.out.println();
		System.out.println("+--+");
		System.out.println("|  |");
		if (n==1){
			System.out.println("|  O"); 
			System.out.println("|");
			System.out.println("|");
		}else if (n==2){
			System.out.println("|  O"); 
			System.out.println("|  |");
			System.out.println("|");
		}else if (n==3){
			System.out.println("|  O"); 
			System.out.println("|  |");
			System.out.println("|   \\");
		}else if (n==4){
			System.out.println("|  O"); 
			System.out.println("|  |");
			System.out.println("| / \\");
		}else if (n==5){
			System.out.println("|  O"); 
			System.out.println("|  |\\");
			System.out.println("| / \\");
		}else {
			System.out.println("|  O"); 
			System.out.println("| /|\\");
			System.out.println("| / \\");
			}
			System.out.println("| ");
			System.out.println("+-----");
		}
	public static boolean playAgain(){
		Scanner console = new Scanner(System.in);
		System.out.println("Would you like to play again? (Yes/No)");
		String input = console.nextLine();
		if (input.equals("yes") || input.equals("Yes")){
			return true;
		}else{ 
		return false;
		}
	}
 	public static boolean checkLetter(char a, String word){
	for(int i=0;i<word.length();i++){
				if(word.charAt(i) == a)
					
					return true;
				}
				
			return false;
				
		}
		
	public static boolean victorycondition(String gameword, String guessedletters){
	for(int i=0;i<gameword.length();i++){
			boolean attemptedL = false;
			
			for(int j=0;j<guessedletters.length();j++){
				if(gameword.charAt(i) == guessedletters.charAt(j)){
					
					attemptedL = true;
				}
				
			}if(attemptedL == false){
			return false;
			
			
	}
	
	
	}
	return true;
	
	
	}
}

		 


	
	
	
	
	
	
	
	






