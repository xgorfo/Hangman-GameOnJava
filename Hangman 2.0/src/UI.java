public class UI {

    public void printGameState(Word word, Player player) {
        System.out.println("Current word: " + word.getCurrentGuess());
        System.out.println("Wrong letters: " + player.getIncorrectGuesses());
        System.out.println("Errors left: " + player.getRemainingTries());
    }


    public void printVictory(Word word) {
        System.out.println("Congratulations! You guessed the word: " + word.getWordToGuess());
    }


    public void printLoss(Word word) {
        System.out.println("You lost! The hidden word was: " + word.getWordToGuess());
    }


    public void printSurrender(Word word) {
        System.out.println("You have surrendered! The hidden word was: " + word.getWordToGuess());
    }
}
