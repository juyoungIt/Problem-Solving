// BOJ - 3758
// Problem Sheet - https://www.acmicpc.net/problem/3758

import java.util.*;
import java.io.*;

public class Main {

    static class TeamInfo implements Comparable<TeamInfo> {
        private final int id;
        private final int[] solved;
        private int totalSubmitCount;
        private int lastSubmitIndex;

        public TeamInfo(int id, int problemCount) {
            this.id = id;
            this.solved = new int[problemCount + 1];
            this.totalSubmitCount = 0;
            this.lastSubmitIndex = -1;
        }

        public int getId() { return this.id; }
        public int getTotalSubmitCount() { return this.totalSubmitCount; }
        public int getLastSubmitIndex() { return this.lastSubmitIndex; }

        public void updateSolvedInfo(int problemId, int score, int logIndex) {
            if (this.solved[problemId] < score) {
                this.solved[problemId] = score;
            }
            this.totalSubmitCount++;
            this.lastSubmitIndex = logIndex;
        }

        public int getTotalScore() {
            return Arrays.stream(solved).sum();
        }

        @Override
        public int compareTo(TeamInfo t) {
            if (getTotalScore() == t.getTotalScore()) {
                if (totalSubmitCount == t.getTotalSubmitCount()) {
                    return this.lastSubmitIndex - t.getLastSubmitIndex();
                }
                return this.totalSubmitCount - t.getTotalSubmitCount();
            }
            return t.getTotalScore() - getTotalScore();
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int testCaseCount = Integer.parseInt(br.readLine());
        for (int i=0 ; i<testCaseCount ; i++) {
            st = new StringTokenizer(br.readLine());
            int teamCount = Integer.parseInt(st.nextToken());
            int problemCount = Integer.parseInt(st.nextToken());
            int myTeamId = Integer.parseInt(st.nextToken());
            int logCount = Integer.parseInt(st.nextToken());
            TeamInfo[] teams = new TeamInfo[teamCount];
            for (int j=0 ; j<teamCount ; j++) {
                teams[j] = new TeamInfo(j + 1, problemCount);
            }
            for (int j=0 ; j<logCount ; j++) {
                st = new StringTokenizer(br.readLine());
                int teamId = Integer.parseInt(st.nextToken());
                int problemId = Integer.parseInt(st.nextToken());
                int score = Integer.parseInt(st.nextToken());
                teams[teamId - 1].updateSolvedInfo(problemId, score, j);
            }
            Arrays.sort(teams);
            for (int j=0 ; j<teamCount ; j++) {
                if (teams[j].getId() == myTeamId) {
                    sb.append(j + 1).append("\n");
                    break;
                }
            }
        }

        System.out.println(sb);

        br.close();
        System.exit(0);
    }
}