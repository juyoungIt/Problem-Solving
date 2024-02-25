// BOJ - 11286
// Problem Sheet - https://www.acmicpc.net/problem/11286

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        PriorityQueue<Integer> pq = new PriorityQueue<>((e1, e2) -> {
            if(Math.abs(e1) == Math.abs(e2)) {
                return e1 - e2;
            }
            return Math.abs(e1) - Math.abs(e2);
        });
        int n = Integer.parseInt(br.readLine());
        for(int i=0 ; i<n ; i++) {
            int command = Integer.parseInt(br.readLine());
            if(command == 0) {
                if(pq.isEmpty()) {
                    sb.append(command).append("\n");
                    continue;
                }
                sb.append(pq.poll()).append("\n");
                continue;
            }
            pq.add(command);
        }

        System.out.println(sb);

        br.close();
        System.exit(0);
    }
}