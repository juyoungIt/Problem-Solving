// BOJ - 29621
// Problem Sheet - https://www.acmicpc.net/problem/29621

import java.util.*;
import java.io.*;
import java.util.stream.Collectors;

public class Main {

    static class Team implements Comparable<Team> {
        private final String name;
        private int score;

        public Team(String name, int score) {
            this.name = name;
            this.score = score;
        }

        public String getName() { return this.name; }
        public int getScore() { return this.score; }
        public void addScore(int increment) { this.score += increment; }

        @Override
        public int compareTo(Team t) {
            if (this.score == t.getScore()) {
                return this.name.compareTo(t.getName());
            }
            return t.getScore() - this.score;
        }
    }

    private static int n;
    private static String targetTeam, lastMatchedTeam;
    private static Map<String, Team> teamMapper;

    public static void main(String[] args) throws IOException {
        input();
        System.out.println(solve());
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        targetTeam = br.readLine();
        lastMatchedTeam = br.readLine();
        teamMapper = new HashMap<>();
        for (int i=0 ; i<n ; i++) {
            String[] row = br.readLine().split(" ");
            teamMapper.put(row[0], new Team(row[0], Integer.parseInt(row[1])));
        }
        br.close();
    }

    private static String solve() {
        StringBuilder sb = new StringBuilder();
        teamMapper.get(targetTeam).addScore(3);
        sb.append(getRank(teamMapper.values().stream().sorted().collect(Collectors.toList()))).append(" ");
        teamMapper.get(targetTeam).addScore(-3);
        teamMapper.get(targetTeam).addScore(1);
        teamMapper.get(lastMatchedTeam).addScore(1);
        sb.append(getRank(teamMapper.values().stream().sorted().collect(Collectors.toList()))).append(" ");
        teamMapper.get(targetTeam).addScore(-1);
        teamMapper.get(lastMatchedTeam).addScore(-1);
        teamMapper.get(lastMatchedTeam).addScore(3);
        sb.append(getRank(teamMapper.values().stream().sorted().collect(Collectors.toList()))).append(" ");
        return sb.toString();
    }

    private static int getRank(List<Team> teams) {
        int rank = 1;
        for (Team team : teams) {
            if (team.getName().equals(targetTeam)) {
                break;
            }
            rank++;
        }
        return rank;
    }
}