// BOJ - 11060
// Problem Sheet - https://www.acmicpc.net/problem/11060

import java.util.*;
import java.io.*;

class Node {
    private final int value; // node가 저장하는 값
    private final int depth; // 탐색의 depth

    public Node(int value, int depth) {
        this.value = value;
        this.depth = depth;
    }

    public int getValue() { return this.value; }
    public int getDepth() { return this.depth; }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine()); // 미로 칸의 수
        int[] maze = new int[n+1];          // 미로의 각 상태를 저장
        boolean[] visit = new boolean[n+1]; // 각 위치에 대한 방문여부
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for(int i=1 ; i<=n ; i++)
            maze[i] = Integer.parseInt(st.nextToken());

        System.out.println(bfs(maze, visit, 1, n));

        bf.close();
        System.exit(0);
    }

    static int bfs(int[] maze, boolean[] visit, int start, int target) {
        Queue<Node> queue = new LinkedList<>();
        int result = -1;

        visit[start] = true;
        queue.add(new Node(start, 0));
        while(!queue.isEmpty()) {
            int curValue = queue.peek().getValue();
            int curDepth = queue.peek().getDepth();
            if(curValue == target) {
                result = curDepth;
                break;
            }
            for(int i=1 ; i<=maze[curValue] ; i++) {
                int tx = curValue + i;
                if(tx <= target && !visit[tx]) {
                    visit[tx] = true;
                    queue.add(new Node(tx, curDepth+1));
                }
            }
            queue.poll();
        }
        return result;
    }
}