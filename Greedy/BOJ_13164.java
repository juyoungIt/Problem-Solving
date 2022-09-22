// BOJ - 13164
// Problem Sheet - https://www.acmicpc.net/problem/13164

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        long answer = 0; // 최소비용

        int n = Integer.parseInt(st.nextToken()); // 유치원 원생의 수
        int k = Integer.parseInt(st.nextToken()); // 나누려고 하는 조의 갯수
        PriorityQueue<Long> diff = new PriorityQueue<>(Collections.reverseOrder()); // 각 신장사이의 차이값 저장

        long[] heights = new long[n];
        st = new StringTokenizer(bf.readLine());
        for(int i=0 ; i<n ; i++) {
            heights[i] = Long.parseLong(st.nextToken());
            if(i>0) diff.add(heights[i] - heights[i-1]);
        }

        // k-1개 만큼의 원소를 제거함
        for(int i=0 ; i<k-1 ; i++)
            diff.poll();

        // 최소비용을 구함
        while(!diff.isEmpty())
            answer += diff.poll();

        System.out.println(answer);

        bf.close();
        System.exit(0);
    }
}