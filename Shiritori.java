/*********************************************** Game Instructions **********************************************/
/** The Shiritori game allows n amount of players to input new words according to the following rules:
  * 	1. The first letter of a new word has to be the same as the last letter of the last word inputted
  *		2. A word cannot be repeated
  * The player who inputs a non valid word will cause the game to terminate.
  *
  * --- Example (2 players) ---
  *		Player 1: Tomato
  *		Player 2: Oval
  *		Player 1: Language
  *		Player 2: Engaged
  *		Player 1: Oval		<-- Game Over (repeated word)

  * --- Example (3 players) ---
  *		Player 1: Tomato
  *		Player 2: Oval
  *		Player 3: Language
  *		Player 1: Engaged
  *		Player 2: Dgeluhae	<-- Game Over (not a word)
/****************************************************************************************************************/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Shiritori {

	/************************************************** Attributes **************************************************/

	public String[] words = new String[10];						// This array holds all words give during the game
	public int 	 	elem  = 0;									// Number of elements stored in the array
	public boolean 	gameOver = false;							// Boolean that represents if game is finished

	/****************************************************************************************************************/


	/**************************************************  Methods  ***************************************************/

	/** This method will take care of introducing new words to the array while following
	  * the rules imposed by the game.
	  * @param  newWord -> New word to be added to array
	  * @return updated array of words (may or may not have the newWord)
	  */
	public String[] play(String newWord) {
		/**
         * Your code goes here!
		 * Make sure to use the 3 attributes above
		 * (this.words, this.elem, and this.gameOver)
		 * In addition, don't forget to resize your
		 * array when it needs by calling resize()
         */
		if (this.gameOver) {
			System.out.println(">> Game over!!");
		}
		return this.words;
	}

	/** This method will take care of restarting a game by setting all attibutes to their original state
	  * @param  none
	  * @return "game restarted"
	  */
	public String restart() {
		String[] restartWords = new String[10];
		this.words = restartWords;
		this.elem  = 0;

		this.gameOver = false;

		return "game restarted";
	}

	/** This method will return the array containing all the words inputted.
	  * @param  none
	  * @return the list of words played so far
	  */
	public String[] getWords() {
		return this.words;
	}

	/** The resize method will increase the size of the words array by two.
	  * This will allow the players to keep playing regardless of the space left in the array.
	  * @param  none
	  * @return void
	  */
	private void resize() {
		int theNewArraySize	 = this.words.length * 2;
		String[] biggerArray = new String[theNewArraySize];

		for (int i = 0; i < this.words.length; i++) {
			biggerArray[i] = this.words[i];
		}

		this.words = biggerArray;
	}

	/**
	 * Checks to see if a word is a valid dictionary word (case insensitive)
	 * @param word -> Word to check in the dictionary
	 * @return a boolean indicating if the word is in the dictionary
	 */
	public static boolean isValidWord(String word) {
		BufferedReader in;
		try {
            in = new BufferedReader(new FileReader("./dictionary"));
            String str;
            while ((str = in.readLine()) != null) {
                if (str.compareToIgnoreCase(word) == 0) {
					in.close();
                    return true;
                }
            }
            in.close();
        } catch (IOException e) {
			// Could not find dictionary, default to true
			return true;
		}
        return false;
    }

	/****************************************************************************************************************/

	/************************************************* Main Method **************************************************/
	public static void main(String[] args) {
		int playersVar;
		int counter = 0;
		String gameValidation;

		Shiritori game = new Shiritori();
		Scanner scanner = new Scanner(System.in);

		System.out.println("------------------------------------------------------");
		System.out.println("---------------- Welcome to Shiritori ----------------");
		while (true) {
			System.out.println(">> Would you like to play? (Yes/No)");
			System.out.print(">> ");
			gameValidation = scanner.next();

			if (gameValidation.compareToIgnoreCase("Yes") == 0) {
				if (game.elem > 0) {
					counter = 0;
					game.restart();
				}

				System.out.println(">> How many players are there? ");
				System.out.print(">> ");
				playersVar = scanner.nextInt();

				if (playersVar <= 0) {
					System.out.println(">> Okay...");
					break;
				}

				while (!game.gameOver) {
					System.out.println(">> Player " + (counter + 1) + ", please input a new word:");
					System.out.print(">> ");
					String newWord = scanner.next();

					if (isValidWord(newWord)) {
						game.play(newWord);
						counter = (counter + 1) % playersVar;
					} else {
						System.out.println(">> " + newWord + " isn't a valid dictionary word!");
					}
				}

				System.out.println(">> This were the words used: ");
				String wordsUsed[] = game.getWords();

				for (int i = 0; i < game.elem; i++) {
					System.out.println("\t>> " + wordsUsed[i]);
				}

				System.out.println("------------------------------------------------------");
			} else {
				System.out.println(">> Okay...");
				break;
			}
		}
		scanner.close();
		System.out.println(">> Game finished :)");
		System.out.println("------------------------------------------------------");
	}
}
