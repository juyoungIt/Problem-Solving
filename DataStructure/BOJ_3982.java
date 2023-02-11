// BOJ - 3982
// Problem Sheet - https://www.acmicpc.net/problem/3982

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int testCaseSize = Integer.parseInt(bf.readLine()); // 테스트 케이스의 수
        for(int i=0 ; i<testCaseSize ; i++) {
            Map<String, Integer> winningCountInfo = new HashMap<>();
            for(int j=0 ; j<16 ; j++) {
                st = new StringTokenizer(bf.readLine());
                List<String> teams = new ArrayList<>(2);
                teams.add(st.nextToken());
                teams.add(st.nextToken());
                addTeams(winningCountInfo, teams); // 팀 정보를 Map에 등록

                int goal1 = Integer.parseInt(st.nextToken());
                int goal2 = Integer.parseInt(st.nextToken());
                String winners = teams.get(getWinners(goal1, goal2));
                winningCountInfo.put(winners, winningCountInfo.get(winners) + 1);
            }

            int maxWinnings = 0;
            String winners = "none";
            for(Map.Entry<String, Integer> entry : winningCountInfo.entrySet()) {
                if(maxWinnings < entry.getValue()) {
                    winners = entry.getKey();
                    maxWinnings = entry.getValue();
                }
            }
            System.out.println(winners);
        }

        bf.close();
        System.exit(0);
    }

    static void addTeams(Map<String, Integer> mapper, List<String> teams) {
        if(!mapper.containsKey(teams.get(0))) {
            mapper.put(teams.get(0), 0);
        }

        if(!mapper.containsKey(teams.get(1))) {
            mapper.put(teams.get(1), 0);
        }
    }

    static int getWinners(int goal1, int goal2) {
        if(goal1 > goal2) {
            return 0;
        } else if(goal1 < goal2) {
            return 1;
        } else {
            throw new IllegalArgumentException();
        }
    }
}