// BOJ - 2993
// Problem Sheet - https://www.acmicpc.net/problem/2993

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();

        StringBuilder sb = new StringBuilder();
        PriorityQueue<String> candidates = new PriorityQueue<>();
        for (int i=1 ; i<word.length()-2 ; i++) {
            for (int j=i+1 ; j<word.length() ; j++) {
                String partA = word.substring(0, i);
                String partB = word.substring(i, j);
                String partC = word.substring(j);
                String reversedPartA = getReversedWord(partA);
                String reversedPartB = getReversedWord(partB);
                String reversedPartC = getReversedWord(partC);
                sb.append(reversedPartA).append(reversedPartB).append(reversedPartC);
                candidates.add(sb.toString());
                sb.setLength(0);
            }
        }

        System.out.println(candidates.poll());
        br.close();
    }

    private static String getReversedWord(String word) {
        return new StringBuilder(word).reverse().toString();
    }
}