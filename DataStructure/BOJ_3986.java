// BOJ - 3986
// Problem Sheet - https://www.acmicpc.net/problem/3986

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int goodWordCount = 0;
        int N = Integer.parseInt(br.readLine());
        while (N-- > 0) {
            if (isGoodWord(br.readLine())) {
                goodWordCount++;
            }
        }
        System.out.println(goodWordCount);

        br.close();
    }

    private static boolean isGoodWord(String word) {
        Deque<Character> stack = new ArrayDeque<>();
        for (char letter : word.toCharArray()) {
            if (!stack.isEmpty() && stack.peekLast() == letter) {
                stack.pollLast();
                continue;
            }
            stack.offerLast(letter);
        }
        return stack.isEmpty();
    }
}