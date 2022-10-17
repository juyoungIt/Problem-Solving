// BOJ - 10917
// Problem Sheet - https://www.acmicpc.net/problem/10917

import java.util.*;
import java.io.*;

class Situation {
    private final int num; // 해당 상황에 대한 번호
    private final int depth; // 탐색의 depth

    public Situation(int num, int depth) {
        this.num = num;
        this.depth = depth;
    }

    public int getNum() { return this.num; }
    public int getDepth() { return this.depth; }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        Queue<Situation> queue = new LinkedList<>();
        int answer = -1;

        int n = Integer.parseInt(st.nextToken()); // 마주할 수 있는 상황의 수
        int m = Integer.parseInt(st.nextToken()); // 선택할 수 있는 변화의 수
        ArrayList<Integer>[] al = new ArrayList[n+1]; // adjacency list
        boolean[] visit = new boolean[n+1]; // 방문정보
        for(int i=1 ; i<=n ; i++)
            al[i] = new ArrayList<>();

        for(int i=0 ; i<m ; i++) {
            st = new StringTokenizer(bf.readLine());
            int idx1 = Integer.parseInt(st.nextToken());
            int idx2 = Integer.parseInt(st.nextToken());
            al[idx1].add(idx2);
        }

        visit[1] = true;
        queue.add(new Situation(1, 0));
        while(!queue.isEmpty()) {
            int curIdx = queue.peek().getNum();
            int curDepth = queue.peek().getDepth();
            if(curIdx == n) {
                answer = curDepth;
                break;
            }
            for(int s : al[curIdx]) {
                if(!visit[s]) {
                    visit[s] = true;
                    queue.add(new Situation(s, curDepth+1));
                }
            }
            queue.poll();
        }

        System.out.println(answer);

        bf.close();
        System.exit(0);
    }
}