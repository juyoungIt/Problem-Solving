// BOJ - 5738
// Problem Sheet - https://www.acmicpc.net/problem/5738

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            String[] row = br.readLine().split(" ");
            int A = Integer.parseInt(row[0]);
            int D = Integer.parseInt(row[1]);
            if (A == 0 && D == 0) break;
            int[] B = new int[A];
            int[] C = new int[D];
            row = br.readLine().split(" ");
            for (int i=0 ; i<A ; i++) {
                B[i] = Integer.parseInt(row[i]);
            }
            row = br.readLine().split(" ");
            for (int i=0 ; i<D ; i++) {
                C[i] = Integer.parseInt(row[i]);
            }
            sb.append(isOffSide(B, C) ? "Y" : "N").append("\n");
        }

        System.out.println(sb);
        br.close();
    }

    private static boolean isOffSide(int[] attacker, int[] defender) {
        Arrays.sort(attacker);
        Arrays.sort(defender);
        return attacker[0] < defender[0] || attacker[0] < defender[1];
    }
}