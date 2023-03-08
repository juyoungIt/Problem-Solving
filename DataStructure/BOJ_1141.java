// BOJ - 1141
// Problem Sheet - https://www.acmicpc.net/problem/1141

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
            return Integer.compare(this.value.length(), word.getValue().length()) * -1;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int numberOfWords = Integer.parseInt(bf.readLine());
        List<Word> words = new ArrayList<>(numberOfWords);
        for(int i=0 ; i<numberOfWords ; i++) {
            words.add(new Word(bf.readLine()));
        }
        Collections.sort(words);

        Set<String> wordSet = new HashSet<>();
        for(Word word : words) {
            if(wordSet.size() == 0) {
                wordSet.add(word.getValue());
            } else {
                boolean isPrefix = false;
                for(String token : wordSet) {
                    if(token.indexOf(word.getValue()) == 0) {
                        isPrefix = true;
                        break;
                    }
                }
                if(!isPrefix) {
                    wordSet.add(word.getValue());
                }
            }
        }

        System.out.println(wordSet.size());

        bf.close();
        System.exit(0);
    }
}