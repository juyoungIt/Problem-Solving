// BOJ - 12712
// Problem Sheet - https://www.acmicpc.net/problem/12712

import java.util.*;
import java.io.*;

public class Main {

    static final String OUTPUT_FORMAT = "Case #%d: %d\n";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        for (int i=1 ; i<=n ; i++) {
            String[] row = br.readLine().split(" ");
            int p = Integer.parseInt(row[0]);
            int k = Integer.parseInt(row[1]);
            int l = Integer.parseInt(row[2]);
            PriorityQueue<Integer> useCounts = new PriorityQueue<>(Collections.reverseOrder());
            row = br.readLine().split(" ");
            for (int j=0 ; j<l ; j++) {
                useCounts.add(Integer.parseInt(row[j]));
            }
            int layer = 1;
            long count = 0;
            while (!useCounts.isEmpty()) {
                for (int j=0 ; j<k ; j++) {
                    if (useCounts.isEmpty()) break;
                    count += (long) useCounts.poll() * layer;
                }
                layer++;
            }
            sb.append(String.format(OUTPUT_FORMAT, i, count));
        }

        System.out.println(sb);
        br.close();
    }
}