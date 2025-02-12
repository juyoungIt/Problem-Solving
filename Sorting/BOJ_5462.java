// BOJ - 5462
// Problem Sheet - https://www.acmicpc.net/problem/5462

import java.util.*;
import java.io.*;

public class Main {

    static class Participant implements Comparable<Participant> {
        private final int id;
        private final int solvedCount;
        private final int score;

        public Participant(int id, int solvedCount, int score) {
            this.id = id;
            this.solvedCount = solvedCount;
            this.score = score;
        }

        public int getId() { return this.id; }
        public int getSolvedCount() { return this.solvedCount; }
        public int getScore() { return this.score; }

        @Override
        public int compareTo(Participant p) {
            if (this.score == p.getScore()) {
                if (this.solvedCount == p.getSolvedCount()) {
                    return this.id - p.getId();
                }
                return p.getSolvedCount() - this.getSolvedCount();
            }
            return p.getScore() - this.score;
        }
    }

    private static int N, T, P;
    private static int[] solvedCount;
    private static boolean[][] isSolved;
    private static int[] score;

    public static void main(String[] args) throws IOException {
        input();
        System.out.println(solve());
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] row = br.readLine().split(" ");
        N = Integer.parseInt(row[0]);
        T = Integer.parseInt(row[1]);
        P = Integer.parseInt(row[2]);
        solvedCount = new int[N];
        isSolved = new boolean[N][T];
        score = new int[T];
        for (int i=0 ; i<N ; i++) {
            row = br.readLine().split(" ");
            for (int j=0 ; j<T ; j++) {
                isSolved[i][j] = Integer.parseInt(row[j]) == 1;
                if (isSolved[i][j]) solvedCount[i]++;
                else score[j]++;
            }
        }
        br.close();
    }

    private static String solve() {
        Participant[] participants = new Participant[N];
        for (int i=0 ; i<N ; i++) {
            int totalScore = 0;
            for (int j=0 ; j<T ; j++) {
                if (isSolved[i][j]) {
                    totalScore += score[j];
                }
            }
            participants[i] = new Participant(i + 1, solvedCount[i], totalScore);
        }
        Arrays.sort(participants);
        int score = -1, rank = -1;
        for (int i=0 ; i<N ; i++) {
            if (participants[i].getId() == P) {
                score = participants[i].getScore();
                rank = i + 1;
            }
        }
        return String.format("%d %d", score, rank);
    }
}
