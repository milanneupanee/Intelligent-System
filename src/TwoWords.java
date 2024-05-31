import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class TwoWords {
    HashMap<String, Integer> bigramMap = new HashMap<>();

    public void readFile(String file) {
        Scanner sc;
        try {
            sc = new Scanner(new File(file));
            sc.useDelimiter("\\s+");
            String previousWord = null;
            while (sc.hasNext()) {
                String word = sc.next().toLowerCase().replaceAll("[,;]", "");
                if (!word.equals("")) {
                    if (previousWord != null) {
                        String bigram = previousWord + " " + word;
                        bigramMap.put(bigram, bigramMap.getOrDefault(bigram, 0) + 1);
                    }
                    previousWord = word;
                }
            }
            sc.close();
        } catch (FileNotFoundException e) {
            System.out.println("File does not exist: " + e);
        }
    }

    public void printBigramFreq() {
        for (String bigram : bigramMap.keySet()) {
            int count = bigramMap.get(bigram);
            System.out.println("{" + bigram + "}, " + count);
        }
    }

    public static void main(String[] args) {
        TwoWords bigramCounter = new TwoWords();
        bigramCounter.readFile("/home/milan/IdeaProjects/data.txt");
        bigramCounter.printBigramFreq();
    }
}

