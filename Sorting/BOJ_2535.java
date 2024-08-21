// BOJ - 2535
// Problem Sheet - https://www.acmicpc.net/problem/2535

import java.util.*;
import java.io.*;

public class Main {

    static class ScoreInfo {
        private final int country;
        private final int student;
        private final int score;

        public ScoreInfo(int country, int student, int score) {
            this.country = country;
            this.student = student;
            this.score = score;
        }

        public int getCountry() { return this.country; }
        public int getStudent() { return this.student; }
        public int getScore() { return this.score; }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        ScoreInfo[] scoreInfos = new ScoreInfo[n];
        for (int i=0 ; i<n ; i++) {
            st = new StringTokenizer(br.readLine());
            int country = Integer.parseInt(st.nextToken());
            int student = Integer.parseInt(st.nextToken());
            int score = Integer.parseInt(st.nextToken());
            scoreInfos[i] = new ScoreInfo(country, student, score);
        }
        Arrays.sort(scoreInfos, (s1, s2) -> s2.getScore() - s1.getScore());

        Map<Integer, Integer> winnerMapper = new HashMap<>();
        int winnerCount = 0;
        for (ScoreInfo scoreInfo : scoreInfos) {
            if (winnerCount >= 3) break;
            winnerMapper.put(scoreInfo.getCountry(), winnerMapper.getOrDefault(scoreInfo.getCountry(), 0) + 1);
            if (winnerMapper.get(scoreInfo.getCountry()) > 2) continue;
            sb.append(scoreInfo.getCountry())
                    .append(" ")
                    .append(scoreInfo.getStudent())
                    .append("\n");
            winnerCount++;
        }

        System.out.println(sb);

        br.close();
        System.exit(0);
    }
}