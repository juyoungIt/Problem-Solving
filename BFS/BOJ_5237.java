// BOJ - 5237
// Problem Sheet - https://www.acmicpc.net/problem/5237

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t = Integer.parseInt(bf.readLine()); // 테스트 케이스의 수
        boolean[] answers = new boolean[t]; // 각 테스트 케이스별 정답 저장
        for(int i=0 ; i<t ; i++) {
            st = new StringTokenizer(bf.readLine());
            int n = Integer.parseInt(st.nextToken()); // 사이트의 수
            int k = Integer.parseInt(st.nextToken()); // 사이트 간의 연결 수
            // k개 쌍의 숫자정보로 그래프를 구성함
            ArrayList<Integer>[] al = new ArrayList[n]; // adjacency list
            for(int j=0 ; j<n ; j++)
                al[j] = new ArrayList<>();
            for(int l=0 ; l<k ; l++) {
                int idx1 = Integer.parseInt(st.nextToken());
                int idx2 = Integer.parseInt(st.nextToken());
                al[idx1].add(idx2);
                al[idx2].add(idx1);
            }
            // 구성된 그래프를 가지고 bfs를 수행함
            answers[i] = bfs(al, n);
        }

        // 종합된 정답을 출력함
        for(boolean answer : answers)
            System.out.println((answer) ? "Connected." : "Not connected.");

        bf.close();
        System.exit(0);
    }

    static boolean bfs(ArrayList<Integer>[] al, int n) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visit = new boolean[n]; // 방문정보 저장
        boolean result = true;

        visit[0] = true;
        queue.add(0);
        while(!queue.isEmpty()) {
            int curValue = queue.peek();
            for(int node : al[curValue]) {
                if(!visit[node]) {
                    visit[node] = true;
                    queue.add(node);
                }
            }
            queue.poll();
        }

        // 모두 연결되었는 지 검사
        for(boolean v : visit) {
            if(!v) {
                result = false;
                break;
            }
        }
        return result;
    }
}