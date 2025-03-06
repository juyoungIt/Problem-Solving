// BOJ - 33540
// Problem Sheet - https://www.acmicpc.net/problem/33540

import java.util.*;
import java.io.*;

public class Main {

    static class Player {
        private final String name;
        private int score;

        public Player(String name, int score) {
            this.name = name;
            this.score = score;
        }

        public String getName() { return this.name; }
        public int getScore() { return this.score; }
        public void addScore(int score) { this.score += score; }

        @Override
        public String toString() {
            return this.name + " " + this.score;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Map<String, Player> playerMap = new HashMap<>();
        int n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
            String[] row = br.readLine().split(" ");
            String name = row[0];
            int score = Integer.parseInt(row[1]);
            if (!playerMap.containsKey(name)) {
                playerMap.put(name, new Player(name, score));
            } else {
                playerMap.get(name).addScore(score);
            }
        }

        playerMap.values().stream()
                .sorted(Comparator.comparing(Player::getName))
                .forEach(p -> sb.append(p).append("\n"));
        System.out.println(sb);
        br.close();
    }
}