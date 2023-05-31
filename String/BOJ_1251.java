// BOJ - 1251
// Problem Sheet - https://www.acmicpc.net/problem/1251

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        List<String> words = new LinkedList<>();

        String input = bf.readLine();
        for(int i=1; i<input.length()-1 ; i++) {
            for(int j=i+1 ; j<input.length() ; j++) {
                sb.append(getReversedWord(input.substring(0, i)));
                sb.append(getReversedWord(input.substring(i, j)));
                sb.append(getReversedWord(input.substring(j)));
                words.add(sb.toString());
                sb.setLength(0);
            }
        }

        Collections.sort(words);
        System.out.println(words.get(0));

        bf.close();
        System.exit(0);
    }

    private static String getReversedWord(String word) {
        StringBuilder sb = new StringBuilder(word);
        return sb.reverse().toString();
    }
}