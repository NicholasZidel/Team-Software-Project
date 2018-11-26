package Hangman;


import java.util.Scanner;

public class HangmanAI 
{
	static String[] words = {"understand","computer","java", "jake", "amount", "hangman",
			"destroy","caterpillar","specific","why","goat","quantum","juno","sacrifice",
			"lemonade","theatre","rocket","faucet","contemporary","loser","college","amphitheatre",
			"sloth","magical","mistake","stratosphere"};
	static int len = words.length;
	static String  theWord;
	static String  newWord = "";
	static String replaceWord = "-";
	static int count = 0;
	static int x = 0;
	public static boolean run = true;
	static Scanner scan = new Scanner(System.in);
	public void runHM()
	{
			playGame();
	}
	
	private static void playGame() {
			count = 0;
			wordFinder();
			newWord = wordPlacer2();
			letterPlacer();
			//System.out.println("here and run = " + run);
	}

	private static String wordPlacer2() 
	{
		for(int i = 0; i < theWord.length(); i++)
		{
			newWord += replaceWord;
		}
		return newWord;
	}

	private static void wordFinder() 
	{
		int num = (int) (Math.random()*len);
		theWord = words[num];
		//System.out.println(theWord);
		//wordPlacer();
	}
	
	//------------------------------------------------------------------------------------------------------Done
	void wordPlacer() 
	{
		String w = "";
		int num = (int) (Math.random()*len); //picks a random word
		theWord = words[num];
		for(int i = 0; i < theWord.length(); i++)
		{
			w = w + "-";
			//System.out.print("-");
			HangmanGame.setWord(w);
		}
	}
	//------------------------------------------------------------------------------------------------------
	private static void letterPlacer() 
	{
		Scanner kb = new Scanner(System.in);
		
			for(int j = 0; j < (theWord.length() + 8);  j++)
			{
				System.out.println("Enter a letter");
				//kb.close();						this broke it
				char letter = kb.next().charAt(0);
				x = 0;
				for(int i = 0; i < theWord.length(); i++)
				{
					if(letter == (theWord.charAt(i)))
					{
						newWord = (newWord.substring(0,i) + letter + newWord.substring(i + 1, newWord.length()));
						x = 1;
					}
				}
				System.out.println(newWord);
				if(x == 0)
				{
					count++;
					System.out.print("strike " + count + ": ");
					 if (checkLoss(count)) {     								// if checkLoss is true, player has lost
						 break;
					 }
				}
			}
		System.out.println("ur done");
	}

	private static boolean checkLoss(int c) {
		boolean loss = false;
		if (c >= 6 )
			loss = true;
		return loss;
	}
}


