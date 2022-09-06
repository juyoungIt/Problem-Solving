// BOJ - 18352
// Problem Sheet - https://www.acmicpc.net/problem/18352

import java.util.*;
import java.io.*;

class Node {
    private final int value; // node가 저장하는 값
    private final int depth; // bfs가 도달하게 되는 depth

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
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int[] inputs = new int[4]; // 도시의 수, 도로의 갯수, 거리 정보, 출발도시 번호
        for(int i=0 ; i<4 ; i++)
            inputs[i] = Integer.parseInt(st.nextToken());

        ArrayList<Integer>[] al = new ArrayList[inputs[0]+1];
        for(int i=1 ; i<=inputs[0] ; i++)
            al[i] = new ArrayList<>();
        boolean[] visit = new boolean[inputs[0]+1]; // 각 도시에 대한 방문여부
        Queue<Node> queue = new LinkedList<>(); // bfs를 수행하기 위한 queue
        ArrayList<Integer> answers = new ArrayList<>(); // 특정 거리에 위치한 도시들의 번호

        // 입력된 정보를 바탕으로 도시에 대한 단방향 그래프 구성
        for(int i=0 ; i<inputs[1] ; i++) {
            st = new StringTokenizer(bf.readLine());
            int idx1 = Integer.parseInt(st.nextToken());
            int idx2 = Integer.parseInt(st.nextToken());
            al[idx1].add(idx2);
        }

        // bfs를 수행하며 특정 거리에 있는 도시들을 찾음
        visit[inputs[3]] = true;
        queue.add(new Node(inputs[3], 0));
        while(!queue.isEmpty()) {
            int value = queue.peek().getValue();
            int depth = queue.peek().getDepth();

            if(depth == inputs[2])
                answers.add(value);

            for(int v : al[value]) {
                if(!visit[v]) {
                    visit[v] = true;
                    queue.add(new Node(v, depth+1));
                }
            }
            queue.poll();
        }

        // 탐색 결과를 출력함
        if(answers.isEmpty())
            System.out.println(-1);
        else {
            Collections.sort(answers); // 오름차 순으로 정렬
            for(int answer : answers)
                System.out.println(answer);
        }

        bf.close();
        System.exit(0);
    }
}