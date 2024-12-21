import java.util.Scanner;

public class Game {
    private static final int MAX_TRIES = 6;  // Максимальное количество ошибок
    private final Word word;  // Игровое слово
    private final Player player;  // Игрок
    private final UI ui;  // Интерфейс

    public Game() {
        WordRepository wordRepository = new WordRepository();
        this.word = new Word(wordRepository);
        this.player = new Player(MAX_TRIES);
        this.ui = new UI();
    }


    public void start() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Gallows!");


        while (player.getRemainingTries() > 0) {
            ui.printGameState(word, player);
            System.out.print("Enter a letter (or write 'surrender' to give up): ");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("surrender")) {
                ui.printSurrender(word);
                break;
            }

            char guess = input.toUpperCase().charAt(0);
            word.makeGuess(guess, player);

            if (word.isGuessed()) {
                ui.printVictory(word);
                break;
            }
        }


        if (player.getRemainingTries() == 0) {
            ui.printLoss(word);
        }

        scanner.close();
    }


    public static void main(String[] args) {
        new Game().start();
    }
}
