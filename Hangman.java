import java.util.*;

public class Hangman {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("apple", "banana", "cherry", "date", "grape", "kiwi", "mango", "orange");

        Random random = new Random();
        String chosenWord = words.get(random.nextInt(words.size())).toLowerCase();

        Set<Character> guessedLetters = new HashSet<>();
        int attemptsLeft = 6; 
        char[] displayWord = new char[chosenWord.length()];
        Arrays.fill(displayWord, '_');

        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Hangman!");
        System.out.println("You have " + attemptsLeft + " attempts to guess the word.");

        while (attemptsLeft > 0) {
            System.out.println("\nWord: " + String.valueOf(displayWord));
            System.out.println("Attempts left: " + attemptsLeft);
            System.out.println("Guessed letters: " + guessedLetters);
            System.out.print("Enter a letter: ");

            char guess = scanner.nextLine().toLowerCase().charAt(0);

            if (guessedLetters.contains(guess)) {
                System.out.println("You already guessed that letter. Try again.");
                continue;
            }

            guessedLetters.add(guess);

            if (chosenWord.indexOf(guess) >= 0) {
                System.out.println("Good guess!");
                for (int i = 0; i < chosenWord.length(); i++) {
                    if (chosenWord.charAt(i) == guess) {
                        displayWord[i] = guess;
                    }
                }

                if (String.valueOf(displayWord).equals(chosenWord)) {
                    System.out.println("\nCongratulations! You guessed the word: " + chosenWord);
                    break;
                }
            } else {
                System.out.println("Wrong guess.");
                attemptsLeft--;
            }
        }

        if (attemptsLeft == 0) {
            System.out.println("\nYou ran out of attempts! The word was: " + chosenWord);
        }

        scanner.close();
    }
}
