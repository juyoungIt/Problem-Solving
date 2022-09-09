// BOJ - 13565
// Problem Sheet - https://www.acmicpc.net/problem/13565

import java.util.*;
import java.io.*;

class Location {
    private final int x;
    private final int y;

    public Location(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() { return this.x; }
    public int getY() { return this.y; }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        Queue<Location> queue = new LinkedList<>(); // bfs를 수행하는 데 필요한 queue
        int[] xi = {-1, 1, 0, 0}; // x-increment
        int[] yi = {0, 0, -1, 1}; // y-increment
        boolean isReached = false;
        String[] answer = {"YES", "NO"};

        int m = Integer.parseInt(st.nextToken()); // 격자 세로의 길이
        int n = Integer.parseInt(st.nextToken()); // 격자 가로의 길이
        int[][] fiber = new int[m][n]; // 섬유 구조를 표현함
        for(int i=0 ; i<m ; i++) {
            String tmp = bf.readLine();
            for(int j=0 ; j<n ; j++) {
                fiber[i][j] = Integer.parseInt(tmp.charAt(j)+"");
                if(i == 0 && fiber[i][j] == 0)
                    queue.add(new Location(j, i));
            }
        }

        // bfs를 수행하여 도달 가능한 지점을 계산함
        while(!queue.isEmpty()) {
            int curX = queue.peek().getX();
            int curY = queue.peek().getY();
            for(int i=0 ; i<4 ; i++) {
                int tx = curX + xi[i];
                int ty = curY + yi[i];
                if(validation(tx, ty, n, m) && fiber[ty][tx] == 0) {
                    fiber[ty][tx] = 2;
                    queue.add(new Location(tx, ty));
                }
            }
            queue.poll();
        }

        // 끝에 전류가 도달 하였는 지 검사
        for(int i=0 ; i<n ;i++) {
            if(fiber[m-1][i] == 2) {
                isReached = true;
                break;
            }
        }

        // 산출된 정답을 출력함
        System.out.println((isReached) ? answer[0] : answer[1]);

        bf.close();
        System.exit(0);
    }

    public static boolean validation(int x, int y, int xLimit, int yLimit) {
        return (x>=0 && y>=0 && x<xLimit && y<yLimit);
    }
}