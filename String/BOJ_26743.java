// BOJ - 26743
// Problem Sheet - https://www.acmicpc.net/problem/26743

import java.util.*;
import java.io.*;
import java.util.stream.Collectors;

public class Main {

    static class Player implements Comparable<Player> {
        private final int id;
        private final String hand;
        private final int score;

        public Player(int id, String hand, int score) {
            this.id = id;
            this.hand = hand;
            this.score = score;
        }

        public int getId() { return this.id; }
        public String getHand() { return this.hand; }
        public int getScore() { return this.score; }

        @Override
        public int compareTo(Player p) {
            if (this.score == p.getScore()) {
                return this.id - p.getId();
            }
            return p.getScore() - this.score;
        }
    }

    private static final int LIMIT = 21;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int p = Integer.parseInt(br.readLine());
        List<Player> players = new ArrayList<>(p);
        for (int i=1 ; i<=p ; i++) {
            String hand = br.readLine();
            int score = calculateScore(hand);
            players.add(new Player(i, hand, score));
        }
        players = players.stream()
                .filter(player -> player.getScore() <= LIMIT)
                .collect(Collectors.toList());
        Collections.sort(players);

        int topScore = players.isEmpty() ? 0 : players.get(0).getScore();
        List<Player> winner = new ArrayList<>();
        for (Player player : players) {
            if (player.getScore() < topScore) break;
            winner.add(player);
        }

        sb.append(winner.size()).append("\n");
        winner.forEach(w -> sb.append(w.getId()).append(" "));
        System.out.println(sb);
        br.close();
    }

    private static int calculateScore(String hand) {
        int score = 0;
        int aCount = 0;
        for (int i=0 ; i<hand.length() ; i++) {
            if (hand.charAt(i) == 'T' || hand.charAt(i) == 'J' || hand.charAt(i) == 'Q' || hand.charAt(i) == 'K') {
                score += 10;
            } else if (hand.charAt(i) == 'A') {
                score++;
                aCount++;
            } else {
                score += (hand.charAt(i) - '0');
            }
        }
        while (aCount-- > 0) {
            if (score + 10 <= LIMIT) {
                score += 10;
            }
        }
        return score;
    }

}
