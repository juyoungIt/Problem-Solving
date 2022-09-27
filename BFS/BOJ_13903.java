// BOJ - 13903
// Problem Sheet - https://www.acmicpc.net/problem/13903

import java.util.*;
import java.io.*;

class Location {
    private final int x; // x좌표
    private final int y; // y좌표
    private final int depth; // 탐색의 depth

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
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int answer = -1;

        // 사용자 입력을 바탕으로 보도블록을 구성하기 위한 기본구조를 구성함
        int r = Integer.parseInt(st.nextToken()); // 보도블록 세로의 길이
        int c = Integer.parseInt(st.nextToken()); // 보도블록 가로의 길이
        int[][] board = new int[r][c]; // 보도블록의 상태
        Queue<Location> queue = new LinkedList<>(); // bfs 수행에 필요한 queue
        boolean[][] visit = new boolean[board.length][board[0].length]; // 각 보도블록의 방문정보

        // 입력정보를 바탕으로 보도블록 정보를 구성함
        for(int i=0 ; i<r ; i++) {
            st = new StringTokenizer(bf.readLine());
            for(int j=0 ; j<c ; j++)
                board[i][j] = Integer.parseInt(st.nextToken());
        }

        // 입력정보를 바탕으로 BFS 수행 시 사용할 increment를 구성함
        int iCount = Integer.parseInt(bf.readLine()); // 이동가능한 방법의 수
        int[] xi = new int[iCount]; // x-increment
        int[] yi = new int[iCount]; // y-increment
        for(int i=0 ; i<iCount ; i++) {
            st = new StringTokenizer(bf.readLine());
            yi[i] = Integer.parseInt(st.nextToken());
            xi[i] = Integer.parseInt(st.nextToken());
        }

        // 첫째줄에서 가능한 세로블록들을 먼저 queue에 넣음
        for(int i=0 ; i<c ; i++) {
            if(board[0][i] == 1) {
                visit[0][i] = true;
                queue.add(new Location(i, 0, 0));
            }
        }
        while(!queue.isEmpty()) {
            int curX = queue.peek().getX();
            int curY = queue.peek().getY();
            int curDepth = queue.peek().getDepth();
            if(curY == board.length-1) {
                answer = curDepth;
                break;
            }
            for(int i=0 ; i<xi.length ; i++) {
                int tx = curX + xi[i];
                int ty = curY + yi[i];
                int tDepth = curDepth+1;
                if(validation(tx, ty, board[0].length, board.length) && board[ty][tx] == 1 && !visit[ty][tx]) {
                    visit[ty][tx] = true;
                    queue.add(new Location(tx, ty, tDepth));
                }
            }
            queue.poll();
        }

        System.out.println(answer);

        bf.close();
        System.exit(0);
    }

    public static boolean validation(int x, int y, int xLimit, int yLimit) {
        return (x>=0 && y>=0 && x<xLimit && y<yLimit);
    }
}