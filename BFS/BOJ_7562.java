// BOJ - 7562
// Problem Sheet - https://www.acmicpc.net/problem/7562

import java.util.*;
import java.io.*;

class Location {
    private final int x;     // x 좌표
    private final int y;     // y 좌표
    private final int depth; // 해당 위치가 탐색된 탐색 depth

    public Location(int x, int y, int depth) {
        this.x = x;
        this.y = y;
        this.depth = depth;
    }

    public int getX() { return this.x; }
    public int getY() { return this.y; }
    public int getDepth() { return this.depth; }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int tcSize = Integer.parseInt(bf.readLine()); // 테스트 케이스의 크기
        Queue<Location> queue = new LinkedList<>(); // bfs에 사용하기 위한 Queue
        int[] xi = {-1, -2, -2, -1, 1, 2, 2, 1}; // x-increment
        int[] yi = {2, 1, -1, -2, -2, -1, 1, 2}; // y-increment
        int[] answers = new int[tcSize]; // 산출된 정답을 저장함

        StringTokenizer st;
        for(int i=0 ; i<tcSize ; i++) {
            int boardSize = Integer.parseInt(bf.readLine()); // 체스판의 크기
            boolean[][] board = new boolean[boardSize][boardSize]; // 체스판 (도달여부를 저장함)
            // 나이트가 현재 있는 칸에 대한 처리
            st = new StringTokenizer(bf.readLine());
            int startX = Integer.parseInt(st.nextToken()); // 나이트의 X좌표
            int startY = Integer.parseInt(st.nextToken()); // 나이트의 Y좌표
            // 나이트가 이동하려고 하는 칸에 대한 처리
            st = new StringTokenizer(bf.readLine());
            int targetX = Integer.parseInt(st.nextToken()); // 나이트가 목표하는 지점의 X좌표
            int targetY = Integer.parseInt(st.nextToken()); // 나이트가 목표하는 지점의 Y좌표
            boolean isReached = false; // 원하는 위치에 도달했는 지에 대한 여부 저장

            board[startY][startX] = true;
            queue.add(new Location(startX, startY, 0));
            while(!queue.isEmpty() && !isReached) {
                int curX = queue.peek().getX();
                int curY = queue.peek().getY();
                int curDepth = queue.peek().getDepth();
                for(int j=0 ; j<8 ; j++) {
                    int tx = curX + xi[j];
                    int ty = curY + yi[j];
                    int tDepth = curDepth + 1;
                    if(validation(tx, ty, boardSize) && !board[ty][tx]) {
                        if(tx == targetX && ty == targetY) {
                            isReached = true;
                            answers[i] = tDepth;
                            break;
                        }
                        board[ty][tx] = true;
                        queue.add(new Location(tx, ty, tDepth));
                    }
                }
                queue.poll();
            }
            queue.clear(); // 재사용을 위해 queue를 비움
        }

        // 각 테스트 케이스에 대한 솔루션을 출력함
        for(int answer : answers)
            System.out.println(answer);

        bf.close();
        System.exit(0);
    }

    public static boolean validation(int x, int y, int n) {
        return (x>=0 && y>=0 && x<n && y<n);
    }
}