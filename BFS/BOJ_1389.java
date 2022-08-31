// BOJ - 1389
// Problem Sheet - https://www.acmicpc.net/problem/1389

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int n = Integer.parseInt(st.nextToken()); // 유저의 수
        int m = Integer.parseInt(st.nextToken()); // 친구 관계의 수
        int[][] am = new int[n+1][n+1];     // adjacency matrix
        int minCount = 0;
        int answer = 0; // 가장 작은 베이컨 수를 가지는 사람

        // 친구 관계에 대한 정보를 입력받음
        for(int i=0 ; i<m ; i++) {
            st = new StringTokenizer(bf.readLine());
            int idx1 = Integer.parseInt(st.nextToken());
            int idx2 = Integer.parseInt(st.nextToken());
            am[idx1][idx2] = 1;
            am[idx2][idx1] = 1;
        }

        // 각 사람에 대하여 다음을 반복함
        for(int i=1 ; i<=n ; i++) {
            int tmp = bfs(am, i);
            if(minCount == 0 || tmp < minCount) {
                minCount = tmp;
                answer = i;
            }
        }

        System.out.println(answer);

        bf.close();
        System.exit(0);
    }

    public static int bfs(int[][] am, int start) {
        Queue<Integer> queue = new LinkedList<>(); // bfs에 사용하기 위한 queue
        boolean[] visit = new boolean[am.length]; // 방문정보 저장
        int result = 0; // 산출된 베이컨 수

        visit[start] = true;
        am[start][start] = 0;
        queue.add(start);
        while(!queue.isEmpty()) {
            for(int i=1 ; i<am.length ; i++) {
                if(am[queue.peek()][i] == 1 && !visit[i]) {
                    visit[i] = true;
                    am[i][i] = am[queue.peek()][queue.peek()]+1;
                    queue.add(i);
                }
            }
            queue.poll();
        }
        for(int i=1 ; i<am.length ; i++)
            result += am[i][i];
        return result;
    }
}