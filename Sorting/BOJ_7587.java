// BOJ - 7587
// Problem Sheet - https://www.acmicpc.net/problem/7587

import java.util.*;
import java.io.*;

public class Main {

    private static final String OUTPUT_FORMAT = "%s %d\n";

    static class Word implements Comparable<Word> {
        private final int seq;
        private final String originWord;
        private int anagramCount;

        public Word(int seq, String originWord) {
            this.seq = seq;
            this.originWord = originWord;
            this.anagramCount = 0;
        }

        public int getSeq() { return this.seq; }
        public String getOriginWord() { return this.originWord; }
        public int getAnagramCount() { return this.anagramCount; }
        public void addAnagramCount() { this.anagramCount++; }

        @Override
        public int compareTo(Word w) {
            if (this.anagramCount == w.getAnagramCount()) {
                return this.seq - w.getSeq();
            }
            return w.getAnagramCount() - this.anagramCount;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) break;
            Map<String, Word> wordMap = new HashMap<>();
            for (int i=0 ; i<n ; i++) {
                String originWord = br.readLine();
                String tokenWord = getTokenWord(originWord);
                if (!wordMap.containsKey(tokenWord)) {
                    wordMap.put(tokenWord, new Word(i, originWord));
                } else {
                    wordMap.get(tokenWord).addAnagramCount();
                }
            }
            List<Word> words = new ArrayList<>(wordMap.values());
            Collections.sort(words);
            sb.append(
                    String.format(
                            OUTPUT_FORMAT,
                            words.get(0).getOriginWord(),
                            words.get(0).getAnagramCount()
                    )
            );
        }

        System.out.println(sb);
        br.close();
    }

    private static String getTokenWord(String originWord) {
        StringBuilder sb = new StringBuilder();
        char[] letters = originWord.toCharArray();
        Arrays.sort(letters);
        sb.append(letters);
        return sb.toString();
    }
}