// BOJ - 15953
// Problem Sheet - https://www.acmicpc.net/problem/15953

import java.util.*;
import java.io.*;

public class Main {

    static class Node {
        private final int range;
        private final int prize;

        public Node(int range, int prize) {
            this.range = range;
            this.prize = prize;
        }

        public int getRange() { return this.range; }
        public int getPrize() { return this.prize; }

        public String toString() { return this.range + " " + this.prize; }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int[] contestAPrizes = { 5_000_000, 3_000_000, 2_000_000, 500_000, 300_000, 100_000 };
        int[] contestBPrizes = { 5_120_000, 2_560_000, 1_280_000, 640_000, 320_000 };

        Node[] contestA = new Node[6];
        Node[] contestB = new Node[5];

        int accSum = 0;
        for(int i=1 ; i<=6 ; i++) {
            accSum += i;
            contestA[i-1] = new Node(accSum, contestAPrizes[i-1]);
        }

        accSum = 0;
        int index = 0;
        for(int i=1 ; i<=16 ; i*=2) {
            accSum += i;
            contestB[index] = new Node(accSum, contestBPrizes[index++]);
        }

        int T = Integer.parseInt(bf.readLine());
        for(int i=0 ; i<T ; i++) {
            st = new StringTokenizer(bf.readLine());
            int contestAResult = Integer.parseInt(st.nextToken());
            int contestBResult = Integer.parseInt(st.nextToken());
            sb.append(getPrizeValue(contestA, contestAResult) + getPrizeValue(contestB, contestBResult)).append("\n");
        }

        System.out.println(sb);

        bf.close();
        System.exit(0);
    }

    private static int getPrizeValue(Node[] contest, int score) {
        if(score == 0) {
            return 0;
        }
        for (Node node : contest) {
            if (node.getRange() >= score) {
                return node.getPrize();
            }
        }
        return 0;
    }
}