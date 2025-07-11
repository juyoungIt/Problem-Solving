// BOJ - 22614
// Problem Sheet - https://www.acmicpc.net/problem/22614

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            String[] row = br.readLine().split(" ");
            int n = Integer.parseInt(row[0]);
            int m = Integer.parseInt(row[1]);
            if (n == 0 && m == 0) break;
            int[][] packets = new int[m][3];
            for (int i=0 ; i<m ; i++) {
                row = br.readLine().split(" ");
                packets[i][0] = Integer.parseInt(row[0]);
                packets[i][1] = Integer.parseInt(row[1]);
                packets[i][2] = Integer.parseInt(row[2]);
            }
            Arrays.sort(packets, Comparator.comparingInt(p -> p[0]));

            Set<Integer> infected = new HashSet<>();
            infected.add(1);
            for (int[] packet : packets) {
                if (!infected.contains(packet[1])) continue;
                infected.add(packet[2]);
            }
            sb.append(infected.size()).append("\n");
        }

        System.out.println(sb);
        br.close();
    }
}