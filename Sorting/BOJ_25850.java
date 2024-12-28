// BOJ - 25850
// Problem Sheet - https://www.acmicpc.net/problem/25850

import java.util.*;
import java.io.*;

public class Main {

    static class Card implements Comparable<Card> {
        private final char player;
        private final int value;

        public Card(char player, int value) {
            this.player = player;
            this.value = value;
        }

        public char getPlayer() { return this.player; }
        public int getValue() { return this.value; }

        @Override
        public int compareTo(Card c) {
            return this.value - c.getValue();
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        List<Card> cards = new ArrayList<>();
        int p = Integer.parseInt(br.readLine());
        for (int i=0 ; i<p ; i++) {
            String[] input = br.readLine().split(" ");
            int c = Integer.parseInt(input[0]);
            for (int j=1 ; j<=c ; j++) {
                cards.add(new Card((char) ('A' + i), Integer.parseInt(input[j])));
            }
        }
        Collections.sort(cards);
        cards.forEach(card -> sb.append(card.getPlayer()));

        System.out.println(sb);
        br.close();
    }
}