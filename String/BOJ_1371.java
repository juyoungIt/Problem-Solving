// BOJ - 1371
// Problem Sheet - https://www.acmicpc.net/problem/1371

import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String input;
        int[] counts = new int[26];
        while((input = bf.readLine()) != null) {
            char[] letters = input.toCharArray();
            for(char letter : letters) {
                if(letter >= 'a' && letter <= 'z') {
                    counts[letter-'a']++;
                }
            }
        }

        int maxCount = 0;
        for(int i=0 ; i<26 ; i++) {
            if(counts[i] > maxCount) {
                maxCount = counts[i];
                sb.setLength(0);
                sb.append((char)(i + 'a'));
            } else if(counts[i] == maxCount) {
                sb.append((char)(i + 'a'));
            }
        }

        System.out.println(sb);

        bf.close();
        System.exit(0);
    }
}