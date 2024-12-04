import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class Viselicha {
    private static final String[] WORDS = {"PROVIDER", "HELICOPTER", "BACKSPACE", "TRUCK", "Sesquipedalianism "};
    private static final int MAX_TRIES = 6;

private String wordToGuess;
private StringBuilder currentGuess;
private List<Character> incorrectGuesses;

public Viselicha() {
    wordToGuess = getRandomWord();
    currentGuess = new StringBuilder(repeatString('_', wordToGuess.length()));
    incorrectGuesses = new ArrayList<>();
}

private String getRandomWord() {
    int index = (int) (Math.random() * WORDS.length);
    return WORDS[index];
}

public boolean makeGuess(char letter) {
    boolean isCorrect = wordToGuess.indexOf(letter) >= 0;
    if (isCorrect) {
        for (int i = 0; i < wordToGuess.length(); i++) {
            if (wordToGuess.charAt(i) == letter) {
                currentGuess.setCharAt(i, letter);
                }
        }
    } else {
        if (!incorrectGuesses.contains(letter)) {
            incorrectGuesses.add(letter);
        }
    }
    return isCorrect;
}

public boolean isWordGuessed() {
    return currentGuess.toString().equals(wordToGuess);
}

public void printGameState() {
    System.out.println("Current word: " + currentGuess);
    System.out.println("Wrong letters: " + incorrectGuesses);
    System.out.println("Errors left: " + (MAX_TRIES - incorrectGuesses.size()));
}

// Метод для повторения строки
public static String repeatString(char character, int count) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < count; i++) {
        sb.append(character);
    }
    return sb.toString();
}

public static void main(String[] args) {
    Viselicha game = new Viselicha();
    Scanner scanner = new Scanner(System.in);

    System.out.println("Welcome to the Gallows!");

    while (game.incorrectGuesses.size() < MAX_TRIES) {
    game.printGameState();
    System.out.print("Enter a letter (or write 'surrender' to give up): ");
;    String input = scanner.nextLine();

    if (input.equalsIgnoreCase("surrender")) {
        System.out.println("You have given up! Hidden word: " + game.wordToGuess);
        break;
    }

    char guess = input.toUpperCase().charAt(0);
    game.makeGuess(guess);

    if (game.isWordGuessed()) {
        System.out.println("Congratulations! You guessed the word: " + game.wordToGuess);
        break;
    }
}

    if (game.incorrectGuesses.size() >= MAX_TRIES) {
    System.out.println("You lost!Now turn around when you leave the house. Hidden word: " + game.wordToGuess);
    }

    scanner.close();
}
}