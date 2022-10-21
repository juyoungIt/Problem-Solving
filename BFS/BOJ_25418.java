// BOJ - 25418
// Problem Sheet - https://www.acmicpc.net/problem/25418

import java.util.*;
import java.io.*;

class Node {
    private final int num;   // 도달한 수
    private final int depth; // 탐색의 깊이

    public Node(int num, int depth) {
        this.num = num;
        this.depth = depth;
    }

    public int getNum() { return this.num; }
    public int getDepth() { return this.depth; }
}

public class Main {
    private static int a; // 시작하는 수
    private static int k; // 목표하는 수
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        a = Integer.parseInt(st.nextToken()); // 시작하는 수
        k = Integer.parseInt(st.nextToken()); // 목표하는 수
        boolean[] visit = new boolean[k-a+1]; // 방문정보

        System.out.println(bfs(visit));

        bf.close();
        System.exit(0);
    }

    static int bfs(boolean[] visit) {
        Queue<Node> queue = new LinkedList<>(); // bfs에 사용하는 queue
        int result = -1;

        visit[0] = true;
        queue.add(new Node(a, 0));
        while(!queue.isEmpty()) {
            int curNum = queue.peek().getNum();
            int curDepth = queue.peek().getDepth();
            if(curNum == k) {
                result = curDepth;
                break;
            }
            if(curNum+1 <= k && !visit[curNum+1-a]) {
                visit[curNum+1-a] = true;
                queue.add(new Node(curNum+1, curDepth+1));
            }
            if(curNum*2 <= k && !visit[curNum*2-a]) {
                visit[curNum*2-a] = true;
                queue.add(new Node(curNum*2, curDepth+1));
            }
            queue.poll();
        }
        return result;
    }
}