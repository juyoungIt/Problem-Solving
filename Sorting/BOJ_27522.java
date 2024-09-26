// BOJ - 27522
// Problem Sheet - https://www.acmicpc.net/problem/27522

import java.util.*;
import java.io.*;

public class Main {

    static class Player implements Comparable<Player> {
        private final String finishTime;
        private final String team;

        public Player(String finishTime, String team) {
            this.finishTime = finishTime;
            this.team = team;
        }

        public String getFinishTime() { return this.finishTime; }
        public String getTeam() { return this.team; }

        @Override
        public int compareTo(Player p) {
            return this.finishTime.compareTo(p.getFinishTime());
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        Map<Integer, Integer> scoreMapper = new HashMap<>();
        scoreMapper.put(1, 10);
        scoreMapper.put(2, 8);
        scoreMapper.put(3, 6);
        scoreMapper.put(4, 5);
        scoreMapper.put(5, 4);
        scoreMapper.put(6, 3);
        scoreMapper.put(7, 2);
        scoreMapper.put(8, 1);

        List<Player> players = new ArrayList<>();
        for (int i=0 ; i<8 ; i++) {
            st = new StringTokenizer(br.readLine());
            String finishTime = st.nextToken();
            String team = st.nextToken();
            players.add(new Player(finishTime, team));
        }
        Collections.sort(players);

        int teamBScore = 0;
        int teamRScore = 0;
        for (int i=0 ; i<8 ; i++) {
            if (players.get(i).getTeam().equals("B")) {
                teamBScore += scoreMapper.get(i + 1);
            } else {
                teamRScore += scoreMapper.get(i + 1);
            }
        }

        if (teamRScore < teamBScore) {
            System.out.println("Blue");
        } else {
            System.out.println("Red");
        }

        br.close();
        System.exit(0);
    }
}