// BOJ - 26511
// Problem Sheet - https://www.acmicpc.net/problem/26511

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
            int[] letters = new int[26];
            String word = br.readLine();
            for (int i=0 ; i<word.length() ; i++) {
                letters[word.charAt(i) - 'a']++;
            }
            int setCount = 0;
            for (int letter : letters) {
                if (letter > 0) {
                    setCount++;
                }
            }
            Arrays.sort(letters);
            int removeCount = 0;
            int letterIndex = 0;
            while (letterIndex < 26 && setCount > 2) {
                if (letters[letterIndex] > 0) {
                    setCount--;
                    removeCount += letters[letterIndex];
                }
                letterIndex++;
            }
            sb.append(removeCount).append("\n");
        }

        System.out.println(sb);
        br.close();
    }
}