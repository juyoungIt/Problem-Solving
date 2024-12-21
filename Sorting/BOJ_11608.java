// BOJ - 11608
// Problem Sheet - https://www.acmicpc.net/problem/11608

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] input = br.readLine().toCharArray();
        int[] letters = new int[26];
        for (char letter : input) {
            letters[letter - 'a']++;
        }

        PriorityQueue<Integer> letterQueue = new PriorityQueue<>();
        for (int letter : letters) {
            if (letter == 0) continue;
            letterQueue.add(letter);
        }

        int answer = 0;
        while (letterQueue.size() > 2) {
            answer += letterQueue.poll();
        }

        System.out.println(answer);
        br.close();
    }
}