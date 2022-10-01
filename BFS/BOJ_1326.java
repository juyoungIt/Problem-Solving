// BOJ - 1326
// Problem Sheet - https://www.acmicpc.net/problem/1326

import java.util.*;
import java.io.*;

class Node {
    private final int index;
    private final int depth;

    public Node(int index, int depth) {
        this.index = index;
        this.depth = depth;
    }

    public int getIndex() { return this.index; }
    public int getDepth() { return this.depth; }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine()); // 징검 다리의 수
        int[] bridge = new int[n+1]; // 징검다리 정보

        StringTokenizer st = new StringTokenizer(bf.readLine());
        for(int i=1 ; i<=n ; i++)
            bridge[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(bf.readLine());
        int a = Integer.parseInt(st.nextToken()); // start
        int b = Integer.parseInt(st.nextToken()); // target

        System.out.println(bfs(bridge, a, b));

        bf.close();
        System.exit(0);
    }

    static int bfs(int[] bridge, int start, int target) {
        Queue<Node> queue = new LinkedList<>();
        boolean[] visit = new boolean[bridge.length];
        boolean isReacehd = false; // 도달여부
        int result = 0;

        visit[start] = true;
        queue.add(new Node(start, 0));
        while(!queue.isEmpty()) {
            int curIndex = queue.peek().getIndex();
            int curDepth = queue.peek().getDepth();
            int curIncrement = bridge[curIndex];
            if(curIndex == target) {
                isReacehd = true;
                result = curDepth;
                break;
            }
            // 현 위치에서 이동 가능한 모든 경우의 수를 구하고 방문 및 Queue에 넣음
            int index1 = curIndex;
            int index2 = curIndex;
            while(validation(index1, bridge.length-1) || validation(index2, bridge.length-1)) {
                index1 += curIncrement;
                index2 -= curIncrement;
                if(validation(index1, bridge.length-1) && !visit[index1]) {
                    visit[index1] = true;
                    queue.add(new Node(index1, curDepth+1));
                }
                if(validation(index2, bridge.length-1) && !visit[index2]) {
                    visit[index2] = true;
                    queue.add(new Node(index2, curDepth+1));
                }
            }
            queue.poll();
        }
        return (isReacehd) ? result : -1;
    }

    static boolean validation(int x, int n) { return (x>=1 && x<=n); }
}