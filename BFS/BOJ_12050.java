// BOJ - 12050
// Problem Sheet - https://www.acmicpc.net/problem/12050

import java.util.*;
import java.io.*;

public class Main {

    static class Location {
        private final int x;
        private final int y;

        public Location(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() { return this.x; }
        public int getY() { return this.y; }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        List<ArrayList<Integer>> answers = new ArrayList<>(); // 정답을 저장

        int t = Integer.parseInt(bf.readLine()); // 테스트 케이스의 수
        for(int i=0 ; i<t ; i++) {
            answers.add(new ArrayList<>());
            st = new StringTokenizer(bf.readLine());
            int r = Integer.parseInt(st.nextToken()); // grid의 세로 길이
            int c = Integer.parseInt(st.nextToken()); // grid의 가로 길이
            int[][] grid = new int[r][c]; // entry의 상태를 저장
            for(int j=0 ; j<r ; j++) {
                String tmp = bf.readLine();
                for(int k=0 ; k<c ; k++)
                    grid[j][k] = Integer.parseInt(tmp.charAt(k)+"");
            }
            int n = Integer.parseInt(bf.readLine()); // 수행하는 연산의 횟수를 저장
            for(int j=0 ; j<n ; j++) {
                String[] command = bf.readLine().split(" ");
                if(command[0].equals("M")) {
                    int x = Integer.parseInt(command[1]);
                    int y = Integer.parseInt(command[2]);
                    int z = Integer.parseInt(command[3]);
                    grid[x][y] = z;
                }
                else {
                    answers.get(i).add(findConnectionOfOnes(grid));
                }
            }
        }

        // 수집한 정답을 출력함
        for(int i=0 ; i<answers.size() ; i++) {
            System.out.println("Case #" + (i+1) + ":");
            for(int n : answers.get(i))
                System.out.println(n);
        }

        bf.close();
        System.exit(0);
    }

    static int findConnectionOfOnes(int[][] grid) {
        boolean[][] visit = new boolean[grid.length][grid[0].length]; // 방문상태 저장
        int connCount = 0; // 발견한 Connection의 수
        for(int i=0 ; i<grid.length ; i++) {
            for(int j=0 ; j<grid[0].length ; j++) {
                if(grid[i][j] == 1 && !visit[i][j]) {
                    bfs(grid, visit, j, i);
                    connCount++;
                }
            }
        }
        return connCount;
    }

    static void bfs(int[][] grid, boolean[][] visit, int startX, int startY) {
        Queue<Location> queue = new LinkedList<>(); // bfs에 사용하는 queue
        int[] xi = {-1, 1, 0, 0}; // x-increment
        int[] yi = {0, 0, -1, 1}; // y-increment

        visit[startY][startX] = true;
        queue.add(new Location(startX, startY));
        while(!queue.isEmpty()) {
            int curX = queue.peek().getX();
            int curY = queue.peek().getY();
            for(int i=0 ; i<4 ; i++) {
                int tx = curX + xi[i];
                int ty = curY + yi[i];
                if(validation(tx, ty, grid[0].length, grid.length) && grid[ty][tx] == 1 && !visit[ty][tx]) {
                    visit[ty][tx] = true;
                    queue.add(new Location(tx, ty));
                }
            }
            queue.poll();
        }
    }

    static boolean validation(int x, int y, int xLimit, int yLimit) {
        return (x>=0 && y>=0 && x<xLimit && y<yLimit);
    }
}