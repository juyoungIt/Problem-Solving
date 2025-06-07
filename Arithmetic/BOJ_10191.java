// BOJ - 10191
// Problem Sheet - https://www.acmicpc.net/problem/10191

import java.util.*;
import java.io.*;

public class Main {

    static class Player {
        private final String name;
        private int hits;
        private int bats;

        public Player(String name, int hits, int bats) {
            this.name = name;
            this.hits = hits;
            this.bats = bats;
        }

        public String getName() { return this.name; }
        public int getHits() { return this.hits; }
        public int getBats() { return this.bats; }
        public void setHits(int hits) { this.hits = hits; }
        public void setBats(int bats) { this.bats = bats; }
        public double getAverage() { return ((double) hits) / bats; }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<Player> players = new LinkedList<>();
        for (int i=0 ; i<9 ; i++) {
            String[] row = br.readLine().split(" ");
            String name = row[0];
            int hits = Integer.parseInt(row[1]);
            int bats = Integer.parseInt(row[2]);
            players.add(new Player(name, hits, bats));
        }

        for (int i=0 ; i<9 ; i++) {
            String[] row = br.readLine().split(" ");
            int hits = Integer.parseInt(row[0]);
            int bats = Integer.parseInt(row[1]);
            players.get(i).setHits(players.get(i).getHits() + hits);
            players.get(i).setBats(players.get(i).getBats() + bats);
        }

        double maxAvg = 0.0;
        int topPlayerIndex = 0;
        for (int i=0 ; i<9 ; i++) {
            double average = players.get(i).getAverage();
            if (maxAvg < average) {
                maxAvg = average;
                topPlayerIndex = i;
            }
        }

        if (topPlayerIndex < 3) {
            Player tmp = players.get(3);
            players.set(3, players.get(topPlayerIndex));
            players.set(topPlayerIndex, tmp);
        }
        if (topPlayerIndex > 3) {
            Player topPlayer = players.get(topPlayerIndex);
            players.remove(topPlayerIndex);
            players.add(3, topPlayer);
        }

        StringBuilder sb = new StringBuilder();
        for (Player player : players) {
            sb.append(player.getName()).append("\n");
        }
        System.out.println(sb);
        br.close();
    }


}