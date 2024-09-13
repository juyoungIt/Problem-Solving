// BOJ - 2890
// Problem Sheet - https://www.acmicpc.net/problem/2890

import java.util.*;
import java.io.*;

public class Main {

    private static final int TEAM_COUNT = 9;

    static class TeamStatus implements Comparable<TeamStatus> {
        private final int number;
        private final int remainDiff;

        public TeamStatus(int number, int remainDiff) {
            this.number = number;
            this.remainDiff = remainDiff;
        }

        public int getNumber() { return this.number; }
        public int getRemainDiff() { return this.remainDiff; }

        @Override
        public int compareTo(TeamStatus t) {
            return this.remainDiff - t.getRemainDiff();
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int[] ranks = new int[TEAM_COUNT + 1];
        List<TeamStatus> teamStatuses = new ArrayList<>();
        for (int i=0 ; i<r ; i++) {
            String lane = br.readLine();
            int remainDiff = 0;
            for (int j=c-1 ; j>=0 ; j--) {
                if (Character.isDigit(lane.charAt(j))) {
                    int index = Character.getNumericValue(lane.charAt(j));
                    TeamStatus teamStatus = new TeamStatus(index, remainDiff);
                    teamStatuses.add(teamStatus);
                    break;
                }
                remainDiff++;
            }
        }
        Collections.sort(teamStatuses);

        int lastRank = 1;
        int curDiff = teamStatuses.get(0).getRemainDiff();
        for (TeamStatus teamStatus : teamStatuses) {
            if (teamStatus.getRemainDiff() != curDiff) {
                curDiff = teamStatus.getRemainDiff();
                lastRank++;
            }
            ranks[teamStatus.getNumber()] = lastRank;
        }

        for (int i=1 ; i<=TEAM_COUNT ; i++) {
            sb.append(ranks[i]).append("\n");
        }
        System.out.println(sb);

        br.close();
        System.exit(0);
    }
}