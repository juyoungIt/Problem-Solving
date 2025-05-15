// BOJ - 5741
// Problem Sheet - https://www.acmicpc.net/problem/5741

import java.util.*;
import java.io.*;

public class Main {

    static class Team implements Comparable<Team> {
        private final String name;
        private int score;
        private int diff;

        public Team(String name) {
            this.name = name;
        }

        public String getName() { return this.name; }
        public int getScore() { return this.score; }
        public int getDiff() { return this.diff; }
        public void addScore(int score) { this.score += score; }
        public void addDiff(int diff) { this.diff += diff; }

        @Override
        public int compareTo(Team team) {
            if (this.score == team.getScore()) {
                return team.getDiff() - this.diff;
            }
            return team.getScore() - this.score;
        }
    }

    private static final int WIN = 3;
    private static final int TIE = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) break;
            Map<String, Team> teamMap = new HashMap<>();
            for (int i=0 ; i<n ; i++) {
                String[] row = br.readLine().split(" ");
                String teamA = row[0];
                int teamAScore = Integer.parseInt(row[1]);
                String teamB = row[4];
                int teamBScore = Integer.parseInt(row[3]);
                if (!teamMap.containsKey(teamA)) teamMap.put(teamA, new Team(teamA));
                if (!teamMap.containsKey(teamB)) teamMap.put(teamB, new Team(teamB));
                if (teamAScore < teamBScore) {
                    teamMap.get(teamB).addScore(WIN);
                    teamMap.get(teamA).addDiff(teamAScore - teamBScore);
                    teamMap.get(teamB).addDiff(teamBScore - teamAScore);
                } else if (teamAScore > teamBScore) {
                    teamMap.get(teamA).addScore(WIN);
                    teamMap.get(teamA).addDiff(teamAScore - teamBScore);
                    teamMap.get(teamB).addDiff(teamBScore - teamAScore);
                } else {
                    teamMap.get(teamA).addScore(TIE);
                    teamMap.get(teamB).addScore(TIE);
                }
            }
            teamMap.values().stream()
                    .sorted()
                    .forEach(t -> sb.append(String.format("%d %s\n", t.getScore(), t.getName())));
            sb.append("\n");
        }

        System.out.println(sb);
        br.close();
    }
}