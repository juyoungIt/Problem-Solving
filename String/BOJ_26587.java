// BOJ - 26587
// Problem Sheet - https://www.acmicpc.net/problem/26587

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            String input = br.readLine();
            if (input == null) break;
            String[] words = input.split(" ");
            boolean[] isVowelStart = new boolean[words.length];
            Deque<String> stack = new ArrayDeque<>(words.length);
            for (int i=0 ; i<words.length ; i++) {
                if (startIsVowel(words[i])) {
                    stack.push(words[i]);
                    isVowelStart[i] = true;
                }
            }
            for (int i=0 ; i<words.length ; i++) {
                if (isVowelStart[i]) {
                    sb.append(stack.pop()).append(" ");
                } else {
                    sb.append(words[i]).append(" ");
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
        br.close();
    }

    private static boolean startIsVowel(String word) {
        char start = Character.toLowerCase(word.charAt(0));
        return start == 'a' || start == 'e' || start == 'i' || start == 'o' || start == 'u';
    }
}