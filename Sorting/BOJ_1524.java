// BOJ - 1524
// Problem Sheet - https://www.acmicpc.net/problem/1524

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        while(T-- > 0) {
            br.readLine(); // 공백 지우기 위한 목적의 라인
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            PriorityQueue<Integer> pqs = new PriorityQueue<>();
            PriorityQueue<Integer> pqb = new PriorityQueue<>();
            st = new StringTokenizer(br.readLine());
            for (int i=0 ; i<N ; i++) {
                pqs.add(Integer.parseInt(st.nextToken()));
            }
            st = new StringTokenizer(br.readLine());
            for (int j=0 ; j<M ; j++) {
                pqb.add(Integer.parseInt(st.nextToken()));
            }

            while (!pqs.isEmpty() && !pqb.isEmpty()) {
                if (pqs.peek() < pqb.peek()) {
                    pqs.poll();
                } else {
                    pqb.poll();
                }
            }

            if (!pqs.isEmpty()) {
                sb.append("S").append("\n");
            } else {
                sb.append("B").append("\n");
            }
        }

        System.out.println(sb);
        br.close();
    }
}