// BOJ - 27829
// Problem Sheet - https://www.acmicpc.net/problem/27829

import java.util.*;
import java.io.*;

public class Main {

    private static final String WIN_G = "Godzilla", WIN_M = "MechaGodzilla", DRAW = "uncertain";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            br.readLine(); // read empty line
            String[] row = br.readLine().split(" ");
            int ng = Integer.parseInt(row[0]);
            int nm = Integer.parseInt(row[1]);
            int[] g = new int[ng];
            row = br.readLine().split(" ");
            for (int i=0 ; i<ng ; i++) {
                g[i] = Integer.parseInt(row[i]);
            }
            int[] m = new int[nm];
            row = br.readLine().split(" ");
            for (int i=0 ; i<nm ; i++) {
                m[i] = Integer.parseInt(row[i]);
            }
            Arrays.sort(g);
            Arrays.sort(m);
            int gIdx = 0, mIdx = 0;
            while (gIdx < ng && mIdx < nm) {
                if (g[gIdx] >= m[mIdx]) mIdx++;
                else gIdx++;
            }
            if (gIdx == ng && mIdx == nm) sb.append(DRAW).append("\n");
            else if (gIdx == ng) sb.append(WIN_M).append("\n");
            else sb.append(WIN_G).append("\n");
        }

        System.out.println(sb);
        br.close();
    }
}