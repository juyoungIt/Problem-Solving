// BOJ - 7365
// Problem Sheet - https://www.acmicpc.net/problem/7365

import java.util.*;
import java.io.*;

public class Main {

    static class Comb {
        int chainIndex;
        int gearIndex;

        public Comb(int chainIndex, int gearIndex) {
            this.chainIndex = chainIndex;
            this.gearIndex = gearIndex;
        }

        public double getRatio() { return (double) chains[chainIndex] / gears[gearIndex]; }

        @Override
        public String toString() { return String.format("%.2f %d %d\n", getRatio(), chainIndex, gearIndex); }
    }

    static int[] chains, gears;

    public static void main(String[] args) throws IOException {
        input();
        System.out.println(solve());
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        chains = new int[4];
        String[] row = br.readLine().split(" ");
        for (int i=1 ; i<=3 ; i++) {
            chains[i] = Integer.parseInt(row[i - 1]);
        }
        gears = new int[8];
        row = br.readLine().split(" ");
        for (int i=1 ; i<=7 ; i++) {
            gears[i] = Integer.parseInt(row[i - 1]);
        }
        br.close();
    }

    static String solve() {
        StringBuilder sb = new StringBuilder();
        Comb[] combs = new Comb[21];
        int count = 0;
        for (int c=1 ; c<=3 ; c++) {
            for (int g=1 ; g<=7 ; g++) {
                combs[count++] = new Comb(c, g);
            }
        }
        Arrays.sort(combs, (c1, c2) -> {
            double ratio1 = c1.getRatio();
            double ratio2 = c2.getRatio();
            if (ratio1 == ratio2) {
                return c1.chainIndex - c2.chainIndex;
            }
            return Double.compare(ratio1, ratio2);
        });
        for (Comb comb : combs) sb.append(comb.toString());
        return sb.toString();
    }

}