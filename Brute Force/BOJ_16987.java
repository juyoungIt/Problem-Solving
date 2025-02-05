// BOJ - 16987
// Problem Sheet - https://www.acmicpc.net/problem/16987

import java.io.*;

public class Main {

    static class Egg {
        private int durability;
        private final int weight;

        public Egg(int durability, int weight) {
            this.durability = durability;
            this.weight = weight;
        }

        public int getWeight() { return this.weight; }
        public boolean isBroken() { return durability <= 0; }
        public void hit(int weight) { this.durability -= weight; }
        public void restore(int weight) { this.durability += weight; }
    }

    private static int N;
    private static Egg[] eggs;
    private static int answer = 0;

    public static void main(String[] args) throws IOException {
        input();
        solve(0, 0);
        System.out.println(answer);
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        eggs = new Egg[N];
        for (int i=0 ; i<N ; i++) {
            String[] row = br.readLine().split(" ");
            int S = Integer.parseInt(row[0]);
            int W = Integer.parseInt(row[1]);
            eggs[i] = new Egg(S, W);
        }
        br.close();
    }

    private static void solve(int selected, int brokenCount) {
        if (selected >= N) {
            answer = Math.max(answer, brokenCount);
            return;
        }
        for (int i=0 ; i<N ; i++) {
            if (i == selected) continue;
            if (!eggs[selected].isBroken() && !eggs[i].isBroken()) {
                eggs[i].hit(eggs[selected].getWeight());
                eggs[selected].hit(eggs[i].getWeight());
                int newBrokenCount = brokenCount;
                newBrokenCount += eggs[i].isBroken() ? 1 : 0;
                newBrokenCount += eggs[selected].isBroken() ? 1 : 0;
                solve(selected + 1, newBrokenCount);
                eggs[i].restore(eggs[selected].getWeight());
                eggs[selected].restore(eggs[i].getWeight());
            } else {
                solve(selected + 1, brokenCount);
            }
        }
    }
}