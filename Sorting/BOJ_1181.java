// BOJ - 1181
// Problem Sheet - https://www.acmicpc.net/problem/1181

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int numberOfWords = Integer.parseInt(bf.readLine());
        String[] words = new String[numberOfWords];
        for(int i=0 ; i<numberOfWords ; i++) {
            words[i] = bf.readLine();
        }
        Arrays.sort(words, (o1, o2) -> {
            if(o1.length() == o2.length()) {
                return o1.compareTo(o2);
            }
            return  Integer.compare(o1.length(), o2.length());
        });

        String prevWord = "";
        for(String word : words) {
            if(prevWord.equals(word)) {
                continue;
            }
            sb.append(word).append("\n");
            prevWord = word;
        }

        System.out.println(sb);

        bf.close();
        System.exit(0);
    }
}