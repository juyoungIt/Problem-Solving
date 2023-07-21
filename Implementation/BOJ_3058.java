// BOJ - 3058
// Problem Sheet - https://www.acmicpc.net/problem/3058

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(bf.readLine());
        for(int i=0 ; i<T ; i++) {
            st = new StringTokenizer(bf.readLine());
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            for(int j=0 ; j<7 ; j++) {
                int value = Integer.parseInt(st.nextToken());
                if(value % 2 == 0) {
                    pq.add(value);
                }
            }
            int minValue = pq.peek();
            int sum = 0;
            while(!pq.isEmpty()) {
                sum += pq.poll();
            }
            sb.append(sum).append(" ").append(minValue).append("\n");
        }

        System.out.println(sb);

        bf.close();
        System.exit(0);
    }
}