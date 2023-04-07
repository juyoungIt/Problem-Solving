// BOJ - 25099
// Problem Sheet - https://www.acmicpc.net/problem/25099

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        Set<String> wordSet = new HashSet<>();
        StringBuilder sb = new StringBuilder();

        int numberOfWords = Integer.parseInt(bf.readLine());
        for(int i=0 ; i<numberOfWords ; i++) {
            String originWord = bf.readLine();
            String sortedWord = getSortedWord(originWord);
            if(!wordSet.contains(sortedWord)) {
                sb.append(originWord).append("\n");
                wordSet.add(sortedWord);
            }
        }

        System.out.println(sb);

        bf.close();
        System.exit(0);
    }

    private static String getSortedWord(String originWord) {
        StringBuilder sb = new StringBuilder();

        char[] tokens = originWord.toCharArray();
        Arrays.sort(tokens);
        for(char token : tokens) {
            sb.append(token);
        }

        return sb.toString();
    }
}