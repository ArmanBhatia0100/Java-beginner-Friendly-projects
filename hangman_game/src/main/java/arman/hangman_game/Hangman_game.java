/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package arman.hangman_game;

import java.util.Scanner;

/**
 *
 * @author arman
 */
/**
 * The program selects a random word from a predefined list of words. The player
 * has to guess the letters in the word one by one. For each incorrect guess, a
 * part of the hangman is drawn. The player must guess the word before the
 * hangman is completed. The game continues until the player guesses the word
 * correctly or runs out of attempts
 */
public class Hangman_game {

    private static int lifelines = 10;
    private static int totalCount = 0;
    private static StringBuilder userInput;
    private static String[] words = {
        "abruptly",
        "absurd",
        "abyss",
        "affix",
        "askew",
        "avenue",
        "awkward",
        "axiom",
        "azure",
        "bagpipes",
        "bandwagon",
        "banjo",
        "bayou",
        "beekeeper",
        "bikini",
        "blitz",
        "blizzard",
        "boggle",
        "bookworm",
        "boxcar",
        "boxful",
        "buckaroo",
        "buffalo",
        "buffoon",
        "buxom",
        "buzzard",
        "buzzing",
        "buzzwords",
        "caliph",
        "cobweb",
        "cockiness",
        "croquet",
        "crypt",
        "curacao",
        "cycle",
        "daiquiri",
        "dirndl",
        "disavow",
        "dizzying",
        "duplex",
        "dwarves",
        "embezzle",
        "equip",
        "espionage",
        "euouae"};
    private static String randomWord;
    private static StringBuilder fillerWord;

    public static void main(String[] args) {
        initialization();

        do {
            getUserInput();
            totalCount++;

            //if the Guessed word have the char entered by the user
            if (randomWord.contains(userInput.toString())) {
                
                // Loop over the guessed word and match the char[0...] of guessed word with char entered by user. If yes replace the _ with the char.
                for (int i = 0; i < randomWord.length(); i++) {

                    if (randomWord.charAt(i) == userInput.charAt(0) && !randomWord.equals(fillerWord)) {
                        fillerWord.replace(i, i + 1, userInput.toString());
                    }

                }
                // print the final word.
                System.out.println(fillerWord);
                
                
            } 
            //The guessed word DOES NOT have the char, Remove one lifeline and print the lifelines.
            else {
                lifelines--;
                System.out.println("Life line: " + lifelines);
            }

        } while (lifelines
                != 0 && !fillerWord.toString()
                        .equals(randomWord.toString()));

        printResult();
    }

    private static void initialization() {
        randomWord = words[(int) (Math.random() * 45)];
        fillerWord = new StringBuilder(randomWord.length());
        fillerWord.repeat("_", randomWord.length());
    }

    private static void getUserInput() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your guess");
        userInput = new StringBuilder(sc.next());
    }

    private static void printResult() {
        if (lifelines != 0 && fillerWord.toString().equals(randomWord.toString())) {
            System.out.println("Total attempts: " + totalCount);
            System.out.print("-------------------------------------");
            System.out.println("       Winner     ");
            System.out.print("--------------------------------------------");
        }

        if (lifelines == 0) {
            System.out.println("Sorry you loose.");
        }
    }
}
