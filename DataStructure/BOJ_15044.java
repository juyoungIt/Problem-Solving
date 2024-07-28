// BOJ - 15044
// Problem Sheet - https://www.acmicpc.net/problem/15044

import java.util.*;
import java.io.*;

public class Main {

    static class ScoreInfo implements Comparable<ScoreInfo> {
        private final int score;
        private final int count;

        public ScoreInfo(int score, int count) {
            this.score = score;
            this.count = count;
        }

        public int getScore() { return this.score; }
        public int getCount() { return this.count; }


        @Override
        public int compareTo(ScoreInfo s) {
            return s.getScore() - this.score;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());
        Map<Integer, Integer> scoreCountMapper = new HashMap<>();
        for (int i=0 ; i<n ; i++) {
            int score = Integer.parseInt(br.readLine());
            scoreCountMapper.put(score, scoreCountMapper.getOrDefault(score, 0) + 1);
        }

        List<ScoreInfo> scores = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : scoreCountMapper.entrySet()) {
            scores.add(new ScoreInfo(entry.getKey(), entry.getValue()));
        }
        Collections.sort(scores);

        int answer = 0;
        for (ScoreInfo scoreInfo : scores) {
            if (answer < k) {
                answer += scoreInfo.getCount();
            }
        }
        System.out.println(answer);

        br.close();
        System.exit(0);
    }
}