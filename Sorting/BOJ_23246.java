// BOJ - 23246
// Problem Sheet - https://www.acmicpc.net/problem/23246

import java.util.*;
import java.io.*;

public class Main {

    static class Score implements Comparable<Score> {
        private final int playerNumber;
        private final int lead;
        private final int speed;
        private final int bouldering;

        public Score(int playerNumber, int lead, int speed, int bouldering) {
            this.playerNumber = playerNumber;
            this.lead = lead;
            this.speed = speed;
            this.bouldering = bouldering;
        }

        public int getPlayerNumber() { return this.playerNumber; }

        @Override
        public int compareTo(Score s) {
            if (this.getMultiply() == s.getMultiply()) {
                if (this.getSum() == s.getSum()) {
                    return this.playerNumber - s.getPlayerNumber();
                }
                return this.getSum() - s.getSum();
            }
            return this.getMultiply() - s.getMultiply();
        }

        private int getMultiply() {
            return this.lead * this.speed * this.bouldering;
        }

        private int getSum() {
            return this.lead + this.speed + this.bouldering;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        List<Score> scores = new ArrayList<>(n);
        for (int i=0 ; i<n ; i++) {
            st = new StringTokenizer(br.readLine());
            int playerNumber = Integer.parseInt(st.nextToken());
            int lead = Integer.parseInt(st.nextToken());
            int speed = Integer.parseInt(st.nextToken());
            int bouldering = Integer.parseInt(st.nextToken());
            scores.add(new Score(playerNumber, lead, speed, bouldering));
        }
        Collections.sort(scores);

        for (int i=0 ; i<3 ; i++) {
            sb.append(scores.get(i).getPlayerNumber()).append(" ");
        }
        System.out.println(sb);

        br.close();
        System.exit(0);
    }
}