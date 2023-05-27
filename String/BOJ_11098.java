// BOJ - 11098
// Problem Sheet - https://www.acmicpc.net/problem/11098

import java.util.*;
import java.io.*;

public class Main {

    static class Player implements Comparable<Player> {
        private final String name;
        private final int price;

        public Player(String name, int price) {
            this.name = name;
            this.price = price;
        }

        public String getName() { return name; }

        public int getPrice() { return price; }

        @Override
        public int compareTo(Player player) {
            return Integer.compare(this.price, player.getPrice()) * -1;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Player> pq = new PriorityQueue<>();
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int numberOfTestCases = Integer.parseInt(bf.readLine());
        for(int i=0 ; i<numberOfTestCases ; i++) {
            int numberOfPlayers = Integer.parseInt(bf.readLine());
            for(int j=0 ; j<numberOfPlayers ; j++) {
                st = new StringTokenizer(bf.readLine());
                int price = Integer.parseInt(st.nextToken());
                pq.add(new Player(st.nextToken(), price));
            }
            sb.append(pq.poll().getName()).append("\n");
            pq.clear();
        }

        System.out.println(sb);

        bf.close();
        System.exit(0);
    }
}