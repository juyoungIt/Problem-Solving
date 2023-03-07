// BOJ - 18115
// Problem Sheet - https://www.acmicpc.net/problem/18115

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int numberOfCards = Integer.parseInt(bf.readLine());
        Deque<Integer> deque = new ArrayDeque<>(numberOfCards);
        Stack<Integer> operations = new Stack<>();
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for(int i=0 ; i<numberOfCards ; i++) {
            operations.push(Integer.parseInt(st.nextToken()));
        }

        int currentCardNumber = 0;
        while(!operations.isEmpty()) {
            currentCardNumber++;
            int operationType = operations.pop();
            if(operationType == 1) {
                deque.addLast(currentCardNumber);
            } else if(deque.size() > 1 && operationType == 2) {
                int storage = deque.pollLast();
                deque.addLast(currentCardNumber);
                deque.addLast(storage);
            } else { // 3인 경우
                deque.addFirst(currentCardNumber);
            }
        }

        while(!deque.isEmpty()) {
            sb.append(deque.pollLast()).append(" ");
        }

        System.out.println(sb);

        bf.close();
        System.exit(0);
    }
}