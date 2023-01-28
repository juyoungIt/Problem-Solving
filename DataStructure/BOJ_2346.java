// BOJ - 2346
// Problem Sheet - https://www.acmicpc.net/problem/2346

import java.util.*;
import java.io.*;

public class Main {

    static class Node {
        private int index; // 내부적으로 사용하는 인덱스
        private int step; // 이동할 방향, 거리를 나타내는 수

        public Node(int index, int step) {
            this.index = index;
            this.step = step;
        }

        public int getIndex() { return this.index; }
        public int getStep() { return this.step; }

        public String toString() {
            return this.index + "(" + this.step + ")";
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine()); // 풍선의 수
        Deque<Node> deque = new ArrayDeque<>();
        StringTokenizer st = new StringTokenizer(bf.readLine()); // 풍선번호
        for(int i=1 ; i<=n ; i++) {
            int step = Integer.parseInt(st.nextToken());
            deque.add(new Node(i, step));
        }

        while(true) {
            Node node = deque.pollFirst();
            System.out.print(node.getIndex() + " ");
            if(deque.isEmpty()) {
                break;
            }
            if(node.getStep() > 0) { // step이 양수
                for(int i=0 ; i<node.getStep()-1 ; i++) {
                    deque.addLast(deque.pollFirst());
                }
            } else { // step이 음수
                for(int i=0 ; i<node.getStep()*(-1) ; i++) {
                    deque.addFirst(deque.pollLast());
                }
            }
        }

        bf.close();
        System.exit(0);
    }
}