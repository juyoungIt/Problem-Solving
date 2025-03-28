// BOJ - 25449
// Problem Sheet - https://www.acmicpc.net/problem/25449

import java.util.*;
import java.io.*;

public class Main {

    static class OPG {
        private final int number;
        private int score;

        public OPG(int number) {
            this.number = number;
            this.score = 0;
        }

        public int getNumber() { return this.number; }
        public int getScore() { return this.score; }
        public void setScore(int score) { this.score = score; }
    }

    private static int N;
    private static int[][] score;
    private static boolean[] isPenalty;
    private static Map<Integer, OPG> opgs;

    public static void main(String[] args) throws IOException {
        input();
        System.out.println(solve());
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        score = new int[N + 1][N + 1];
        for (int i=1 ; i<=N ; i++) {
            String[] row = br.readLine().split(" ");
            for (int j=N-1 ; j>0 ; j--) {
                score[i][Integer.parseInt(row[N - 1 - j])] = j;
            }
        }
        br.close();
    }

    private static String solve() {
        return queryA() + "\n" + queryB();
    }

    private static String queryA() {
        opgs = new HashMap<>();
        for (int i=1 ; i<=N ; i++) {
            opgs.put(i, new OPG(i));
        }
        for (int i=1 ; i<=N ; i++) {
            for (int j=1 ; j<=N ; j++) {
                opgs.get(i).setScore(opgs.get(i).getScore() + score[j][i]);
            }
        }
        return getTop3OPG(opgs);
    }

    private static String queryB() {
        opgs = new HashMap<>();
        isPenalty = new boolean[N + 1];
        for (int i=1 ; i<=N ; i++) {
            opgs.put(i, new OPG(i));
        }
        for (int i=1 ; i<=N ; i++) {
            for (int j=1 ; j<=N ; j++) {
                if (score[i][j] == score[j][i] && score[i][j] > 0) {
                    score[i][j] = 0;
                    score[j][i] = 0;
                    isPenalty[i] = true;
                    isPenalty[j] = true;
                }
            }
        }
        for (int i=1 ; i<=N ; i++) {
            if (isPenalty[i]) Arrays.fill(score[i], 0);
        }
        for (int i=1 ; i<=N ; i++) {
            for (int j=1 ; j<=N ; j++) {
                opgs.get(i).setScore(opgs.get(i).getScore() + score[j][i]);
            }
        }
        return getTop3OPG(opgs);
    }

    private static String getTop3OPG(Map<Integer, OPG> opgs) {
        StringBuilder sb = new StringBuilder();
        opgs.values().stream()
                .sorted((o1, o2) -> {
                    if (o1.getScore() == o2.getScore()) return o1.getNumber() - o2.getNumber();
                    return o2.getScore() - o1.getScore();
                })
                .limit(3)
                .forEach(opg -> sb.append(opg.getNumber()).append(" "));
        return sb.toString();
    }

}