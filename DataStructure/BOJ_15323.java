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
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        StringBuilder sb = new StringBuilder();

        PriorityQueue<Word>[] words = new PriorityQueue[26];
        for(int i=0 ; i<26 ; i++) {
            words[i] = new PriorityQueue<>();
        }

        int numberOfWords = Integer.parseInt(st.nextToken());
        int numberOfLetters = Integer.parseInt(st.nextToken());
        String word;
        for(int i=0 ; i<numberOfWords ; i++) {
            word = bf.readLine();
            words[word.charAt(0)-97].add(new Word(word, 0));
        }

        for(int i=0 ; i<numberOfLetters ; i++) {
            int index = bf.readLine().charAt(0)-97;
            Word firstWord = words[index].poll();
            sb.append(firstWord.getValue()).append("\n");
            firstWord.useWord();
            words[index].add(firstWord);
        }

        System.out.println(sb);

        bf.close();
        System.exit(0);
    }
}