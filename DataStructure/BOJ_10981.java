// BOJ - 10981
// Problem Sheet - https://www.acmicpc.net/problem/10981

import java.util.*;
import java.io.*;

public class Main {

    static class TeamInfo {
        private final String university;
        private final String team;
        private final int solve;
        private final int penalty;

        public TeamInfo(String university, String team, int solve, int penalty) {
            this.university = university;
            this.team = team;
            this.solve = solve;
            this.penalty = penalty;
        }

        public String getUniversity() { return this.university; }
        public String getTeam() { return this.team; }
        public int getSolve() { return this.solve; }
        public int getPenalty() { return this.penalty; }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        PriorityQueue<TeamInfo> teamInfos = new PriorityQueue<>((t1, t2) -> {
            if (t1.getSolve() == t2.getSolve()) {
                return Integer.compare(t1.getPenalty(), t2.getPenalty());
            }
            return Integer.compare(t1.getSolve(), t2.getSolve()) * -1;
        });
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        for (int i=0 ; i<n ; i++) {
            st = new StringTokenizer(br.readLine());
            String university = st.nextToken();
            String team = st.nextToken();
            int solve = Integer.parseInt(st.nextToken());
            int penalty = Integer.parseInt(st.nextToken());
            teamInfos.add(new TeamInfo(university, team, solve, penalty));
        }

        Set<String> universities = new HashSet<>();
        while (!teamInfos.isEmpty() && universities.size() < k) {
            if (universities.contains(teamInfos.peek().getUniversity())) {
                teamInfos.poll();
                continue;
            }
            universities.add(teamInfos.peek().getUniversity());
            sb.append(teamInfos.poll().getTeam()).append("\n");
        }
        System.out.println(sb);

        br.close();
        System.exit(0);
    }
}