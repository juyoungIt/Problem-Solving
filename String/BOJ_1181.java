// BOJ - 1181
// Problem Sheet - https://www.acmicpc.net/problem/1181

import java.util.*;
import java.io.*;

public class Main {

    static class Word implements Comparable<Word> {
        private final String value;

        public Word(String value) {
            this.value = value;
        }

        public String getValue() { return this.value; }

        @Override
        public int compareTo(Word word) {
            if(this.value.length() == word.getValue().length()) {
                return this.value.compareTo(word.getValue());
            }
            return Integer.compare(this.value.length(), word.getValue().length());
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int numberOfWords = Integer.parseInt(bf.readLine());
        Word[] words = new Word[numberOfWords];
        for(int i=0 ; i<numberOfWords ; i++) {
            words[i] = new Word(bf.readLine());
        }
        Arrays.sort(words);

        sb.append(words[0].getValue()).append("\n");
        for(int i=1 ; i<numberOfWords ; i++) {
            if(!words[i].getValue().equals(words[i-1].getValue())) {
                sb.append(words[i].getValue()).append("\n");
            }
        }
        System.out.println(sb);

        bf.close();
        System.exit(0);
    }
}