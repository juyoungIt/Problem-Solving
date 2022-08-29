// BOJ - 16953
// Problem Sheet - https://www.acmicpc.net/problem/16953

import java.util.*;
import java.io.*;

class Node {
    private final long value; // 실질적으로 값을 저장
    private final long depth; // graph 상에서의 depth 값을 저장

    public Node(long value, long depth) {
        this.value = value;
        this.depth = depth;
    }

    public long getValue() { return this.value; }
    public long getDepth() { return this.depth; }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int a = Integer.parseInt(st.nextToken()); // 시작하는 수
        int b = Integer.parseInt(st.nextToken()); // 도달하고자 하는 수
        Queue<Node> queue = new LinkedList<>(); // bfs를 위해 정의한 queue
        long answer = -1;

        queue.add(new Node(a, 1));
        while(!queue.isEmpty()) {
            if(queue.peek().getValue() == b) {
                answer = queue.peek().getDepth();
                break;
            }
            if(queue.peek().getValue()*2 <= b)
                queue.add(new Node(queue.peek().getValue()*2, queue.peek().getDepth()+1));
            if(queue.peek().getValue()*10+1 <=b)
                queue.add(new Node(queue.peek().getValue()*10+1, queue.peek().getDepth()+1));
            queue.poll();
        }

        System.out.println(answer);

        bf.close();
        System.exit(0);
    }
}