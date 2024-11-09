// BOJ - 17413
// Problem Sheet - https://www.acmicpc.net/problem/17413

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Deque<Character> stack = new ArrayDeque<>();
        boolean isTag = false;
        for (char letter : br.readLine().toCharArray()) {
            switch (letter) {
                case '<':
                    isTag = true;
                    while (!stack.isEmpty()) {
                        sb.append(stack.pollLast());
                    }
                    sb.append(letter);
                    break;
                case '>':
                    isTag = false;
                    sb.append(letter);
                    break;
                case ' ':
                    if (!isTag) {
                        while (!stack.isEmpty()) {
                            sb.append(stack.pollLast());
                        }
                    }
                    sb.append(letter);
                    break;
                default:
                    if (isTag) sb.append(letter);
                    else stack.offerLast(letter);
            }
        }
        while (!stack.isEmpty()) {
            sb.append(stack.pollLast());
        }

        System.out.println(sb);
        br.close();
    }
}