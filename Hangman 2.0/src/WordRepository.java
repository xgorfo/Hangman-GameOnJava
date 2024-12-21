import java.util.ArrayList;
import java.util.List;

public class WordRepository {
    private static final String[] DEFAULT_WORDS = {
            "PROVIDER", "HELICOPTER", "BACKSPACE", "TRUCK", "SESQUIPEDALIANISM"
    };

    private List<String> words;

    public WordRepository() {
        words = new ArrayList<>();
        for (String word : DEFAULT_WORDS) {
            words.add(word);
        }
    }

    public String getRandomWord() {
        int index = (int) (Math.random() * words.size());
        return words.get(index);
    }

    public void loadWordsFromFile(String filePath) {
    }
}
