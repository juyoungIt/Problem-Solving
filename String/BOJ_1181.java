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
            if(this.value.length() != word.getValue().length()) {
                return Integer.compare(this.value.length(), word.getValue().length());
            } else {
                return this.value.compareTo(word.getValue());
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        Set<String> wordSet = new HashSet<>(); // 입력받은 단어의 Set

        int n = Integer.parseInt(bf.readLine()); // 단어의 수
        List<Word> result = new ArrayList<>(n); // 지정된 기준에 따라 정렬된 단어의 리스트
        for(int i=0 ; i<n ; i++) {
            String word = bf.readLine();
            if(!wordSet.contains(word)) {
                wordSet.add(word);
                result.add(new Word(word));
            }
        }
        Collections.sort(result);

        for(Word word : result) {
            System.out.println(word.getValue());
        }

        bf.close();
        System.exit(0);
    }
}