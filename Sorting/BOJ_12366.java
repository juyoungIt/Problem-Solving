// BOJ - 12366
// Problem Sheet - https://www.acmicpc.net/problem/12366

import java.util.*;
import java.io.*;

public class Main {

    static class Level {
        final int index;
        final int time;
        final int percent;

        public Level(int index, int time, int percent) {
            this.index = index;
            this.time = time;
            this.percent = percent;
        }
    }

    static final String OUTPUT_FORMAT = "Case #%d: %s\n";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        for (int i=1 ; i<=t ; i++) {
            int n = Integer.parseInt(br.readLine());
            Level[] levels = new Level[n];
            int[] l = new int[n];
            int[] p = new int[n];
            String[] row = br.readLine().split(" ");
            for (int j=0 ; j<n ; j++) l[j] = Integer.parseInt(row[j]);
            row = br.readLine().split(" ");
            for (int j=0 ; j<n ; j++) p[j] = Integer.parseInt(row[j]);
            for (int j=0 ; j<n ; j++) levels[j] = new Level(j, l[j], p[j]);
            Arrays.sort(levels, (l1, l2) -> {
                if (l1.percent == l2.percent) return l1.index - l2.index;
                return l2.percent - l1.percent;
            });
            StringBuilder buffer = new StringBuilder();
            for (Level level : levels) {
                buffer.append(level.index).append(" ");
            }
            sb.append(String.format(OUTPUT_FORMAT, i, buffer));
        }

        System.out.println(sb);
        br.close();
    }
}