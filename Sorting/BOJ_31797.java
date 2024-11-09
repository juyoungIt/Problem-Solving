// BOJ - 31797
// Problem Sheet - https://www.acmicpc.net/problem/31797

import java.util.*;
import java.io.*;

public class Main {

    static class Hand implements Comparable<Hand> {
        private final int playerNumber;
        private final int height;

        public Hand(int playerNumber, int height) {
            this.playerNumber = playerNumber;
            this.height = height;
        }

        public int getPlayerNumber() { return this.playerNumber; }
        public int getHeight() { return this.height; }

        @Override
        public int compareTo(Hand h) {
            return h.getHeight() - this.height;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        List<Hand> hands = new ArrayList<>(M * 2);
        for (int i=1 ; i<=M ; i++) {
            input = br.readLine().split(" ");
            int H1 = Integer.parseInt(input[0]);
            int H2 = Integer.parseInt(input[1]);
            hands.add(new Hand(i, H1));
            hands.add(new Hand(i, H2));
        }
        Collections.sort(hands);

        Deque<Hand> deque = new ArrayDeque<>(M * 2);
        deque.addAll(hands);
        while (N-- > 0) {
            deque.addFirst(deque.pollLast());
        }

        System.out.println(deque.peekFirst().getPlayerNumber());
        br.close();
    }
}