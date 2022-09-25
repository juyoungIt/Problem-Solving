// BOJ - 15558
// Problem Sheet - https://www.acmicpc.net/problem/15558

import java.util.*;
import java.io.*;

class Node {
    private final int num; // 칸의 정보
    private final int depth; // 탐색의 depth
    private final int direction; // 현재 칸의 방향 (0: 왼쪽, 1: 오른쪽)

    public Node(int num, int depth, int direction) {
        this.num = num;
        this.depth = depth;
        this.direction = direction;
    }

    public int getNum() { return this.num; }
    public int getDepth() { return this.depth; }
    public int getDirection() { return this.direction; }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int n = Integer.parseInt(st.nextToken()); // 칸의 수
        int k = Integer.parseInt(st.nextToken()); // 반대편으로 이동 시 이동하는 칸의 수
        String leftStr = bf.readLine();  // 왼쪽 칸에 대한 정보 문자열
        String rightStr = bf.readLine(); // 오른쪽 칸에 대한 정보 문자열
        int[][] board = new int[n+1][2]; // 이동하는 칸에 대한 정보
        Queue<Node> queue = new LinkedList<>(); // bfs를 사용하기 위해 필요한 queue
        int[] increments = {1, -1, k}; // 연산에 사용할 가산 연산자
        boolean isReached = false;

        // 주어진 String 정보를 바탕으로 칸의 정보를 Array로 구성함
        for(int i=1 ; i<=n ; i++) {
            board[i][0] = Integer.parseInt(leftStr.charAt(i-1)+"");
            board[i][1] = Integer.parseInt(rightStr.charAt(i-1)+"");
        }

        // bfs를 수행하며, 가능/불가능 여부를 확인함
        board[1][0] = 2;
        queue.add(new Node(1, 0, 0));
        while(!queue.isEmpty()) {
            if(isReached) break;
            int curNum = queue.peek().getNum();
            int curDepth = queue.peek().getDepth();
            int curDir = queue.peek().getDirection();
            for(int i=0 ; i<3 ; i++) {
                int tNum = curNum + increments[i];
                int tDepth = curDepth + 1;
                int tDir = (i < 2) ? curDir : changeDir(curDir);
                if(tNum > n) {
                    isReached = true;
                    break;
                }
                if(tNum>tDepth && board[tNum][tDir] == 1) {
                    board[tNum][tDir] = 2;
                    queue.add(new Node(tNum, tDepth, tDir));
                }
            }
            queue.poll();
        }

        System.out.println((isReached) ? 1 : 0);

        bf.close();
        System.exit(0);
    }

    // 진행중인 방향을 변경함
    public static int changeDir(int n) {
        return (n == 1) ? 0 : 1;
    }
}