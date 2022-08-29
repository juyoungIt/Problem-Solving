// BOJ - 1697
// Problem Sheet - https://www.acmicpc.net/problem/1697

import java.util.*;
import java.io.*;

class Node {
    private final int value; // Node가 저장하는 값
    private final int depth; // 그래프가 탐색을 진행한 Depth

    public Node(int value, int depth) {
        this.value = value;
        this.depth = depth;
    }

    public int getValue() { return this.value; }
    public int getDepth() { return this.depth; }
}

public class Main {
    private static final int LOWER_LIMIT = 0; // 탐색 가능한 점 위치의 하한
    private static final int UPPER_LIMIT = 100000; // 탐색 가능한 점 위치의 상한
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int start = Integer.parseInt(st.nextToken()); // 탐색을 시작하는 시작점
        int target = Integer.parseInt(st.nextToken()); // 도달, 찾고자 하는 지점
        Queue<Node> queue = new LinkedList<>(); // bfs에 사용하는 queue
        boolean[] visit = new boolean[UPPER_LIMIT+1]; // 해당 수에 대한 방문여부를 저장
        int answer = 0; // 탐색에 소요된 최단시간

        queue.add(new Node(start, 0));
        while(!queue.isEmpty()) {
            Node front = queue.peek();
            if(front.getValue() == target) {
                answer = front.getDepth();
                break;
            }
            if(front.getValue()-1 >= LOWER_LIMIT && front.getValue()-1 <= UPPER_LIMIT && !visit[front.getValue()-1]) {
                queue.add(new Node(front.getValue()-1, front.getDepth()+1));
                visit[front.getValue()-1] = true;
            }
            if(front.getValue()+1 >= LOWER_LIMIT && front.getValue()+1 <= UPPER_LIMIT && !visit[front.getValue()+1]) {
                queue.add(new Node(front.getValue()+1, front.getDepth()+1));
                visit[front.getValue()+1] = true;
            }
            if(front.getValue()<<1 >= LOWER_LIMIT && front.getValue()<<1 <= UPPER_LIMIT && !visit[front.getValue()<<1]) {
                queue.add(new Node(front.getValue()<<1, front.getDepth()+1));
                visit[front.getValue()<<1] = true;
            }
            queue.poll();
        }

        System.out.println(answer);

        bf.close();
        System.exit(0);
    }
}