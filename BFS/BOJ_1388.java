// BOJ - 1388
// Problem Sheet - https://www.acmicpc.net/problem/1388

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
       int n = Integer.parseInt(st.nextToken()); // 방 바닥의 세로길이
       int m = Integer.parseInt(st.nextToken()); // 방 바닥의 가로길이
       char[][] floor = new char[n][m]; // 방바닥을 표현하는 배열
       boolean[][] check = new boolean[n][m]; // 바닥 각 위치에 대한 확인여부
       int answer = 0;

       // 방 바닥에 대한 정보를 입력
       for(int i=0 ; i<n ; i++) {
           String tmp = bf.readLine();
           for(int j=0 ; j<m ; j++)
               floor[i][j] = tmp.charAt(j);
       }

       // 방바닥을 BFS로 탐색하며 카운트 정보를 갱신함
       for(int i=0 ; i<n ; i++) {
           for(int j=0 ; j<m ; j++) {
               if(!check[i][j]) {
                   bfs(floor, check, j, i, floor[i][j]);
                   answer++;
               }
           }
       }

       System.out.println(answer);

       bf.close();
       System.exit(0);
   }

   public static void bfs(char[][] floor, boolean[][] check, int startX, int startY, char target) {
       Queue<Location> queue = new LinkedList<>(); // bfs를 수행하기 위한 queue

       check[startY][startX] = true;
       queue.add(new Location(startX, startY));
       while(!queue.isEmpty()) {
           int curX = queue.peek().getX();
           int curY = queue.peek().getY();
           if(target == '-') {
               int tx = curX + 1;
               int ty = curY;
               if(validation(tx, ty, floor[0].length, floor.length) && floor[ty][tx] == '-' && !check[ty][tx]) {
                   check[ty][tx] = true;
                   queue.add(new Location(tx, ty));
               }
           }
           else { // target이 '|'
               int tx = curX;
               int ty = curY + 1;
               if(validation(tx, ty, floor[0].length, floor.length) && floor[ty][tx] == '|' && !check[ty][tx]) {
                   check[ty][tx] = true;
                   queue.add(new Location(tx, ty));
               }
           }
           queue.poll();
       }
   }

   public static boolean validation(int x, int y, int xLimit, int yLimit) {
       return (x>=0 && y>=0 && x<xLimit && y<yLimit);
   }
}