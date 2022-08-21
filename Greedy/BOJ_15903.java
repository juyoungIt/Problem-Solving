// BOJ - 15903
// Problem Sheet - https://www.acmicpc.net/problem/15903

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken()); // 카드의 수
        int m = Integer.parseInt(st.nextToken()); // 합체 횟수
        PriorityQueue<Long> pQueue = new PriorityQueue<>(); // 카드에 적힌 값을 저장
        st = new StringTokenizer(bf.readLine());
        for(int i=0 ; i<n ; i++)
            pQueue.add(Long.parseLong(st.nextToken()));
        long answer = 0;

        for(int i=0 ; i<m ; i++) {
            long merge = pQueue.poll() + pQueue.poll();
            pQueue.add(merge);
            pQueue.add(merge);
        }

        while(!pQueue.isEmpty())
            answer += pQueue.poll();

        System.out.println(answer);

        bf.close();
        System.exit(0);
    }
}