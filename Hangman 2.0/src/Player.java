import java.util.HashSet;
import java.util.Set;

public class Player {
    private final int maxTries;
    private int remainingTries;
    private final Set<Character> incorrectGuesses;

    public Player(int maxTries) {
        this.maxTries = maxTries;
        this.remainingTries = maxTries;
        this.incorrectGuesses = new HashSet<>();
    }

    public void addIncorrectGuess(char letter) {
        if (!incorrectGuesses.contains(letter)) {
            incorrectGuesses.add(letter);
            remainingTries--;
        }
    }


    public int getRemainingTries() {
        return remainingTries;
    }

    public Set<Character> getIncorrectGuesses() {
        return incorrectGuesses;
    }
}
