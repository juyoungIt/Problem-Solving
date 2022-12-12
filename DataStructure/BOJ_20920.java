// BOJ - 20920
// Problem Sheet - https://www.acmicpc.net/problem/20920

import java.util.*;
import java.io.*;

public class Main {

    static class Word implements Comparable<Word> {
        private String word; // 단어
        private int count; // 빈도

        public Word(String word) {
            this.word = word;
            this.count = 1;
        }

        public void increase() { this.count++; }
        public String getWord() { return this.word; }
        public int getCount() { return this.count; }

        @Override
        public int compareTo(Word word) {
            if(this.count != word.getCount())
                return Integer.compare(this.count, word.getCount()) * -1;
            else if(this.word.length() != word.getWord().length())
                return Integer.compare(this.word.length(), word.getWord().length()) * -1;
            else
                return this.word.compareTo(word.getWord());
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        Map<String, Word> countMapper = new HashMap<>(); // 각 단어별 등장횟수

        int n = Integer.parseInt(st.nextToken()); // 단어의 수
        int m = Integer.parseInt(st.nextToken()); // 단어의 길이 기준

        // 각 단어별 등장 빈도수를 종합
        for(int i=0 ; i<n ; i++) {
            String word = bf.readLine();
            if(word.length() < m) continue;
            if(!countMapper.containsKey(word)) countMapper.put(word, new Word(word));
            else countMapper.get(word).increase();
        }

        List<Word> words = new ArrayList<>(countMapper.values());
        Collections.sort(words);

        for(Word word : words)
            bw.write(word.getWord() + "\n");

        bf.close();
        bw.flush();
        bw.close();
        System.exit(0);
    }
}