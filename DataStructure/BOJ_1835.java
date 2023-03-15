// BOJ - 1835
// Problem Sheet - https://www.acmicpc.net/problem/1835

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int numberOfCards = Integer.parseInt(bf.readLine());
        Deque<Integer> cards = new ArrayDeque<>(numberOfCards);
        for(int i=numberOfCards ; i>0 ; i--) {
            cards.addFirst(i);
            for(int j=0 ; j<i ; j++) {
                cards.addFirst(cards.pollLast());
            }
        }

        for(int card : cards) {
            sb.append(card).append(" ");
        }

        System.out.println(sb);

        bf.close();
        System.exit(0);
    }
}