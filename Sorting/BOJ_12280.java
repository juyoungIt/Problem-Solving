// BOJ - 12280
// Problem Sheet - https://www.acmicpc.net/problem/12280

import java.util.*;
import java.io.*;

public class Main {

    static final String FORMAT = "Case #%d: %s";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        for (int i=1 ; i<=t ; i++) {
            int n = Integer.parseInt(br.readLine());
            int[] labels = new int[n];
            PriorityQueue<Integer> pqA = new PriorityQueue<>();
            PriorityQueue<Integer> pqB = new PriorityQueue<>(Collections.reverseOrder());
            String[] row = br.readLine().split(" ");
            for (int j=0 ; j<n ; j++) {
                int value = Integer.parseInt(row[j]);
                labels[j] = value % 2;
                if (labels[j] == 0) pqB.add(value);
                else pqA.add(value);
            }
            StringBuilder buffer = new StringBuilder();
            for (int j=0 ; j<n ; j++) {
                if (labels[j] == 0) buffer.append(pqB.poll()).append(" ");
                else buffer.append(pqA.poll()).append(" ");
            }
            sb.append(String.format(FORMAT, i, buffer)).append("\n");
        }

        System.out.println(sb);
        br.close();
    }
}