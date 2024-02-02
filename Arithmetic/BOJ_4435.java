// BOJ - 4435
// Problem Sheet - https://www.acmicpc.net/problem/4435

import java.util.*;
import java.io.*;

public class Main {

    private static final String TEAM_A_WIN = "Good triumphs over Evil";
    private static final String TEAM_B_WIN = "Evil eradicates all trace of Good";
    private static final String DRAW = "No victor on this battle field";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        Map<Integer, Integer> teamAScoreMapper = new HashMap<>();
        teamAScoreMapper.put(1, 1);
        teamAScoreMapper.put(2, 2);
        teamAScoreMapper.put(3, 3);
        teamAScoreMapper.put(4, 3);
        teamAScoreMapper.put(5, 4);
        teamAScoreMapper.put(6, 10);

        Map<Integer, Integer> teamBScoreMapper = new HashMap<>();
        teamBScoreMapper.put(1, 1);
        teamBScoreMapper.put(2, 2);
        teamBScoreMapper.put(3, 2);
        teamBScoreMapper.put(4, 2);
        teamBScoreMapper.put(5, 3);
        teamBScoreMapper.put(6, 5);
        teamBScoreMapper.put(7, 10);

        int t = Integer.parseInt(br.readLine());
        for(int i=0 ; i<t ; i++) {
            st = new StringTokenizer(br.readLine());
            int totalScoreOfTeamA = 0;
            int curIndex = 1;
            while(st.hasMoreTokens()) {
                totalScoreOfTeamA += Integer.parseInt(st.nextToken())
                        * teamAScoreMapper.get(curIndex);
                curIndex++;
            }
            int totalScoreOfTeamB = 0;
            curIndex = 1;
            st = new StringTokenizer(br.readLine());
            while(st.hasMoreTokens()) {
                totalScoreOfTeamB += Integer.parseInt(st.nextToken())
                        * teamBScoreMapper.get(curIndex);
                curIndex++;
            }
            if(totalScoreOfTeamA > totalScoreOfTeamB) {
                sb.append("Battle ")
                        .append(i+1)
                        .append(": ")
                        .append(TEAM_A_WIN)
                        .append("\n");
            } else if(totalScoreOfTeamA < totalScoreOfTeamB) {
                sb.append("Battle ")
                        .append(i+1)
                        .append(": ")
                        .append(TEAM_B_WIN)
                        .append("\n");
            } else {
                sb.append("Battle ")
                        .append(i+1)
                        .append(": ")
                        .append(DRAW)
                        .append("\n");
            }
        }

        System.out.println(sb);

        br.close();
        System.exit(0);
    }
}