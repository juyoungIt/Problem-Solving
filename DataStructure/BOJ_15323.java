// BOJ - 15323
// Problem Sheet - https://www.acmicpc.net/problem/15323

import java.util.*;
import java.io.*;

public class Main {

    static class Word implements Comparable<Word> {
        private final String value;
        private int usageCount;

        public Word(String value, int usageCount) {
            this.value = value;
            this.usageCount = usageCount;
        }

        public String getValue() { return this.value; }

        public void useWord() { this.usageCount++; }

        @Override
        public int compareTo(Word word) {
            if(this.usageCount != word.usageCount) {
                return Integer.compare(this.usageCount, word.usageCount);
            }
            return this.value.compareTo(word.getValue());
        }

        public String toString() {
            return this.value + " - " + this.usageCount;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        StringBuilder sb = new StringBuilder();

        Map<Character, Map<String, Word>> wordMapper = new HashMap<>();
        int numberOfWords = Integer.parseInt(st.nextToken());
        int numberOfLetters = Integer.parseInt(st.nextToken());
        for(int i=0 ; i<numberOfWords ; i++) {
            String word = bf.readLine();
            if(!wordMapper.containsKey(word.charAt(0))) {
                wordMapper.put(word.charAt(0), new HashMap<>());
            }
            wordMapper.get(word.charAt(0)).put(word, new Word(word, 0));
        }

        List<Word> words = new LinkedList<>();
        for(int i=0 ; i<numberOfLetters ; i++) {
            char letter = bf.readLine().charAt(0);
            words.addAll(wordMapper.get(letter).values());
            Collections.sort(words);
            sb.append(words.get(0).getValue()).append("\n");
            words.get(0).useWord();
            words.clear();
        }

        System.out.println(sb);

        bf.close();
        System.exit(0);
    }
}