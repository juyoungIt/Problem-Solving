// BOJ - 24480
// Problem Sheet - https://www.acmicpc.net/problem/24480

import java.util.*;
import java.io.*;

public class Main {
    private static int sequence = 1;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int n = Integer.parseInt(st.nextToken()); // 정점의 수
        int m = Integer.parseInt(st.nextToken()); // 간선의 수
        int r = Integer.parseInt(st.nextToken()); // 시작 정점

        ArrayList<Integer>[] al = new ArrayList[n+1]; // adjacency list
        for(int i=1 ; i<=n ; i++)
            al[i] = new ArrayList<>();
        boolean[] visit = new boolean[n+1]; // 방문정보 저장
        int[] answers = new int[n+1]; // 정답을 저장

        // 입력된 정보를 바탕으로 adjacency list 구성
        for(int i=0 ; i<m ; i++) {
            st = new StringTokenizer(bf.readLine());
            int idx1 = Integer.parseInt(st.nextToken());
            int idx2 = Integer.parseInt(st.nextToken());
            al[idx1].add(idx2);
            al[idx2].add(idx1);
        }

        // adjacency list의 각 요소들을 내림차순 정렬
        for(int i=1 ; i<=n ; i++)
            Collections.sort(al[i], Collections.reverseOrder());

        // dfs 수행
        dfs(al, visit, answers, r);

        // 솔루션을 출력함
        for(int i=1 ; i<=n ; i++)
            System.out.println(answers[i]);

        bf.close();
        System.exit(0);
    }

    public static void dfs(ArrayList<Integer>[] al, boolean[] visit, int[] answers, int start) {
        visit[start] = true;
        answers[start] = sequence++;
        for(int v : al[start]) {
            if(!visit[v])
                dfs(al, visit, answers, v);
        }
    }
}