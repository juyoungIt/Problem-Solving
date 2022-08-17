// BOJ - 2606
// Problem Sheet - https://www.acmicpc.net/problem/2606

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int comCount = Integer.parseInt(bf.readLine()); // 컴퓨터의 수
        int connCount = Integer.parseInt(bf.readLine()); // 컴퓨터 사이의 연결 수
        int[][] am = new int[comCount+1][comCount+1]; // adjacent matrix
        boolean[] infected = new boolean[comCount+1]; // 해당 컴퓨터의 감염여부
        for(int i=0 ; i<connCount ; i++) {
            st = new StringTokenizer(bf.readLine());
            int idx1 = Integer.parseInt(st.nextToken());
            int idx2 = Integer.parseInt(st.nextToken());
            am[idx1][idx2] = 1;
            am[idx2][idx1] = 1;
        }
        Queue<Integer> queue = new LinkedList<>(); // bfs를 위한 queue
        int answer = 0; // 감염된 pc의 수

        queue.add(1);
        infected[1] = true;
        while(!queue.isEmpty()) {
            for(int i=1 ; i<=comCount ; i++) {
                if(am[queue.peek()][i] == 1 && !infected[i]) {
                    infected[i] = true;
                    queue.add(i);
                    answer++;
                }
            }
            queue.poll();
        }

        System.out.println(answer);

        bf.close();
        System.exit(0);
    }
}