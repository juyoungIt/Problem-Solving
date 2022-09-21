// BOJ - 14562
// Problem Sheet - https://www.acmicpc.net/problem/14562

import java.util.*;
import java.io.*;

class Score {
    private final int s; // 태균이의 점수
    private final int t; // 상대의 점수
    private final int depth; // bfs 탐색의 깊이

    public Score(int s, int t, int depth) {
        this.s = s;
        this.t = t;
        this.depth = depth;
    }

    public int getS() { return this.s; }
    public int getT() { return this.t; }
    public int getDepth() { return this.depth; }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int c = Integer.parseInt(bf.readLine());
        int[] answers = new int[c];

        // 각 테스트 케이스에 대하여 다음을 반복
        for(int i=0 ; i<c ; i++) {
            st = new StringTokenizer(bf.readLine());
            int s = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            answers[i] = bfs(s, t);
        }

        // 산출한 결과를 출력함
        for(int answer : answers)
            System.out.println(answer);

        bf.close();
        System.exit(0);
    }

    public static int bfs(int s, int t) {
        Queue<Score> queue = new LinkedList<>(); // bfs를 수행하기 위한 queue

        queue.add(new Score(s, t, 0));
        while(!queue.isEmpty()) {
            if(queue.peek().getS() == queue.peek().getT())
                break;

            int curS = queue.peek().getS();
            int curT = queue.peek().getT();
            int curDepth = queue.peek().getDepth();

            if(curS*2 <= curT+3)
                queue.add(new Score(curS*2, curT+3, curDepth+1));
            if(curS+1 <= curT)
                queue.add(new Score(curS+1, curT, curDepth+1));
            queue.poll();
        }
        return queue.peek().getDepth();
    }
}