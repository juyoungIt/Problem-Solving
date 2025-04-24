// BOJ - 6826
// Problem Sheet - https://www.acmicpc.net/problem/6826

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Deque<Character> deque = new ArrayDeque<>(5);
        deque.addLast('A');
        deque.addLast('B');
        deque.addLast('C');
        deque.addLast('D');
        deque.addLast('E');
        while (true) {
            String firstInput = br.readLine();
            if (firstInput == null) break;
            int button = Integer.parseInt(firstInput);
            int clickCnt = Integer.parseInt(br.readLine());
            if (button == 1) {
                for (int i=0 ; i<clickCnt ; i++) {
                    deque.addLast(deque.pollFirst());
                }
            } else if (button == 2) {
                for (int i=0 ; i<clickCnt ; i++) {
                    deque.addFirst(deque.pollLast());
                }
            } else if (button == 3) {
                char first = deque.pollFirst();
                char second = deque.pollFirst();
                deque.addFirst(first);
                deque.addFirst(second);
            } else if (button == 4) {
                for (int i=0 ; i<5 ; i++) {
                    sb.append(deque.pollFirst()).append(" ");
                }
                break;
            } else {
                throw new IllegalArgumentException("invalid button types");
            }
        }

        System.out.println(sb);
        br.close();
    }
}