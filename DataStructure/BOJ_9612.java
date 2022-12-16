// BOJ - 9612
// Problem Sheet - https://www.acmicpc.net/problem/9612

import java.util.*;
import java.io.*;

public class Main {

    static class Word implements Comparable<Word> {
        private final String word; // 단어
        private final int freq; // 빈도 수

        public Word(String word, int freq) {
            this.word = word;
            this.freq = freq;
        }

        public String getWord() { return this.word; }
        public int getFreq() { return this.freq; }

        @Override
        public int compareTo(Word word) {
            if(this.freq != word.getFreq()) return Integer.compare(this.freq, word.getFreq()) * -1;
            else return this.word.compareTo(word.getWord()) * -1;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer> countMapper = new HashMap<>(); // 단어별 빈도수 저장
        PriorityQueue<Word> queue = new PriorityQueue<>(); // 지정한 우선순위 기반으로 저장

        int n = Integer.parseInt(bf.readLine()); // 단어의 수
        for(int i=0 ; i<n ; i++) {
            String word = bf.readLine(); // 1개의 단어
            if(!countMapper.containsKey(word)) countMapper.put(word, 1);
            else countMapper.put(word, countMapper.get(word) + 1);
        }

        // 수집한 결과를 저장함
        for(Map.Entry<String, Integer> entry : countMapper.entrySet())
            queue.add(new Word(entry.getKey(), entry.getValue()));

        // 수집한 결과를 출력함
        System.out.println(queue.peek().getWord() + " " + queue.peek().getFreq());

        bf.close();
        System.exit(0);
    }
}