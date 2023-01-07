// BOJ - 15233
// Problem Sheet - https://www.acmicpc.net/problem/15233

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int scoreOfTeamA = 0; // teamA의 점수
        int scoreOfTeamB = 0; // teamB의 점수

        int teamACount = Integer.parseInt(st.nextToken()); // teamA의 인원 수
        int teamBCount = Integer.parseInt(st.nextToken()); // teamB의 인원 수
        int totalGoals = Integer.parseInt(st.nextToken()); // 경기에서 들어간 골의 수
        Map<String, String> teamMapper = new HashMap<>(); // 각 선수에 대한 소속팀 정보를 유지

        st = new StringTokenizer(bf.readLine());
        for(int i=0 ; i<teamACount ; i++) {
            teamMapper.put(st.nextToken(), "A");
        }

        st = new StringTokenizer(bf.readLine());
        for(int i=0 ; i<teamBCount ; i++) {
            teamMapper.put(st.nextToken(), "B");
        }

        st = new StringTokenizer(bf.readLine());
        for(int i=0 ; i<totalGoals ; i++) {
            String player = st.nextToken();
            if(teamMapper.get(player).equals("A")) {
                scoreOfTeamA++;
            } else {
                scoreOfTeamB++;
            }
        }

        if(scoreOfTeamA > scoreOfTeamB) {
            System.out.println("A");
        } else if(scoreOfTeamA < scoreOfTeamB) {
            System.out.println("B");
        } else {
            System.out.println("TIE");
        }

        bf.close();
        System.exit(0);
    }
}