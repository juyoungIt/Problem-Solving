// BOJ - 22764
// Problem Sheet - https://www.acmicpc.net/problem/22764

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();

        Map<Character, List<Character>> charMap = new HashMap<>();
        charMap.put('1', List.of('.', ',', '!', '?', ' '));
        charMap.put('2', List.of('a', 'b', 'c'));
        charMap.put('3', List.of('d', 'e', 'f'));
        charMap.put('4', List.of('g', 'h', 'i'));
        charMap.put('5', List.of('j', 'k', 'l'));
        charMap.put('6', List.of('m', 'n', 'o'));
        charMap.put('7', List.of('p', 'q', 'r', 's'));
        charMap.put('8', List.of('t', 'u', 'v'));
        charMap.put('9', List.of('w', 'x', 'y', 'z'));

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String s = br.readLine();
            StringBuilder buffer = new StringBuilder();

            char currentKey = ' ';
            int pressCount = 0;

            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);

                if (c == '0') {
                    if (currentKey != ' ') {
                        List<Character> chars = charMap.get(currentKey);
                        char determinedChar = chars.get((pressCount - 1) % chars.size());
                        buffer.append(determinedChar);
                    }
                    currentKey = ' ';
                    pressCount = 0;
                } else {
                    if (currentKey == c) {
                        pressCount++;
                    } else {
                        currentKey = c;
                        pressCount = 1;
                    }
                }
            }
            if (currentKey != ' ') {
                List<Character> chars = charMap.get(currentKey);
                char determinedChar = chars.get((pressCount - 1) % chars.size());
                buffer.append(determinedChar);
            }

            result.append(buffer).append("\n");
        }

        System.out.println(result);
        br.close();
    }
}