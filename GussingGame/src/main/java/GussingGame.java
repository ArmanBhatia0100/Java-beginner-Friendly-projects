
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
/**
 *
 * @author arman
 */
public class GussingGame {

    private static int difficultyLevel;
    private static int randomNumber;
    private static int guessNumber;
    private static int TotalGuess;
    private static int threasholdNumber;
    static Scanner userInput = new Scanner(System.in);
//   The program will ask you to choose a difficulty level: Easy (1-50) || Medium (1-100) || Hard (1-200).
    //Once you choose a difficulty level, the program will generate a random number within the chosen range.
    //Enter your guess and press Enter.
    //The program will tell you whether your guess was too high or too low.
    //Keep guessing until you guess the correct number.
    //Once you guess the correct number, the program will tell you how many guesses it took and end the game.

    public static void main(String[] args) {
        int userChoice;

        do {
            System.out.println("Choose a difficulty level: ");
            System.out.println("1. Low (1-50)");
            System.out.println("2. Medium (1-100)");
            System.out.println("3. High (1-200)");
            System.out.println("4. Exit the game");
            System.out.print("Enter your choice:");
            userChoice = userInput.nextInt();

            switch (userChoice) {
                case 1:
                    randomNumber = (int) (Math.random() * 50 + 1);
                    guessTheNumber();
                    break;
                case 2:
                    randomNumber = (int) (Math.random() * 101);
                    break;
                case 3:
                    randomNumber = (int) (Math.random() * 201);

                    break;
                case 4:
                    System.out.println("See you soon bye....");
                    break;
                default:
                    System.out.println("OOPs,,,Try again");
            }
        } while (userChoice != 4);
    }

    public static void guessTheNumber() {

        do {
            System.out.println("Type a guess number: ");
            guessNumber = userInput.nextInt();

            if (guessNumber != randomNumber && guessNumber > randomNumber) {
                System.out.println("Too high");
            }

            // exact match
            if (guessNumber == randomNumber) {
                System.out.println("Winner..");
            }

            if (guessNumber != randomNumber && guessNumber < randomNumber && guessNumber >= 0) {
                System.out.println("Too low");
            }
        } while (guessNumber != randomNumber && guessNumber > 0);
    }
}
