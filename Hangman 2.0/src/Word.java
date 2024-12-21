public class Word {
    private final String wordToGuess;
    private final StringBuilder currentGuess;


    public Word(WordRepository wordRepository) {
        this.wordToGuess = wordRepository.getRandomWord();
        this.currentGuess = new StringBuilder(StringUtils.repeatString('_', wordToGuess.length()));
    }


    public void makeGuess(char letter, Player player) {
        if (wordToGuess.contains(String.valueOf(letter))) {
            revealLetter(letter);
        } else {
            player.addIncorrectGuess(letter);
        }
    }


    private void revealLetter(char letter) {
        for (int i = 0; i < wordToGuess.length(); i++) {
            if (wordToGuess.charAt(i) == letter) {
                currentGuess.setCharAt(i, letter);
            }
        }
    }


    public boolean isGuessed() {
        return currentGuess.toString().equals(wordToGuess);
    }


    public String getCurrentGuess() {
        return currentGuess.toString();
    }


    public String getWordToGuess() {
        return wordToGuess;
    }
}
