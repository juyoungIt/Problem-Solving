// BOJ - 5931
// Problem Sheet - https://www.acmicpc.net/problem/5931

import java.util.*;
import java.io.*;

class Location {
    private final int x;
    private final int y;
    private final int depth;

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
        Queue<Location> queue = new LinkedList<>(); // global 하게 사용하는 queue

        int n = Integer.parseInt(st.nextToken()); // pattern의 세로길이
        int m = Integer.parseInt(st.nextToken()); // pattern의 가로길이
        char[][] pattern = new char[n][m]; // pattern의 상태정보 저장
        boolean[][] visit = new boolean[n][m]; // 방문 상태정보 저장
        int startX = -1,  startY = -1;
        for(int i=0 ; i<n ; i++) {
            String tmp = bf.readLine();
            for(int j=0 ; j<m ; j++) {
                pattern[i][j] = tmp.charAt(j);
                if(pattern[i][j] == 'X' && startX == -1 && startY == -1) {
                    startX = j;
                    startY = i;
                }
            }
        }
        getFirstPattern(pattern, visit, startX, startY, queue);
        System.out.println(bfs(pattern, visit, queue));

        bf.close();
        System.exit(0);
    }

    static void getFirstPattern(char[][] pattern, boolean[][] visit, int startX, int startY, Queue<Location> queue) {
        Queue<Location> tmpQueue = new LinkedList<>(); // bfs의 수행을 위해 일시적으로 사용하는 queue
        int[] xi = {-1, 1, 0, 0}; // x-increment
        int[] yi = {0, 0, -1, 1}; // y-increment

        visit[startY][startX] = true;
        tmpQueue.add(new Location(startX, startY, 0));
        queue.add(new Location(startX, startY, 0));
        while(!tmpQueue.isEmpty()) {
            int curX = tmpQueue.peek().getX();
            int curY = tmpQueue.peek().getY();
            int curDepth = tmpQueue.peek().getDepth();
            for(int i=0 ; i<4 ; i++) {
                int tx = curX + xi[i];
                int ty = curY + yi[i];
                if(validation(tx, ty, pattern[0].length, pattern.length)
                        && pattern[ty][tx] == 'X'
                        && !visit[ty][tx]) {
                    visit[ty][tx] = true;
                    tmpQueue.add(new Location(tx, ty, curDepth+1));
                    queue.add(new Location(tx, ty, 0));
                }
            }
            tmpQueue.poll();
        }
    }

    static int bfs(char[][] pattern, boolean[][] visit, Queue<Location> queue) {
        int[] xi = {-1, 1, 0, 0}; // x-increment
        int[] yi = {0, 0, -1, 1}; // y-increment
        boolean isReached = false;
        int result = 0;

        while(!queue.isEmpty()) {
            if(isReached) break;
            int curX = queue.peek().getX();
            int curY = queue.peek().getY();
            int curDepth = queue.peek().getDepth();
            for(int i=0 ; i<4 ; i++) {
                int tx = curX + xi[i];
                int ty = curY + yi[i];
                if(validation(tx, ty, pattern[0].length, pattern.length) && !visit[ty][tx]) {
                    if(pattern[ty][tx] == 'X') {
                        isReached = true;
                        result = curDepth;
                        break;
                    }
                    visit[ty][tx] = true;
                    queue.add(new Location(tx, ty, curDepth+1));
                }
            }
            queue.poll();
        }
        return result;
    }

    static boolean validation(int x, int y, int xLimit, int yLimit) {
        return (x>=0 && y>=0 && x<xLimit && y<yLimit);
    }
}