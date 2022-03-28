// BOJ - 2178
// Problem Sheet - https://www.acmicpc.net/problem/2178

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Location {
    private int x; // the 'x' coordinates
    private int y; // the 'y' coordinates

    // the constructor
    public Location(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // getter
    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner key = new Scanner(System.in);
        int n = key.nextInt(); // row
        int m = key.nextInt(); // column
        int[][] visit = new int[n+1][m+1]; // (0 - 방문하지 않음, 1 - 방문함, -1 : 지나갈 수 없는 영역)
        String tmp;
        key.nextLine();
        for(int i=0 ; i<n ; i++) {
            tmp = key.nextLine();
            for(int j=0 ; j<m ; j++) {
                int x = Integer.parseInt(tmp.charAt(j)+"");
                if(x == 0) visit[i+1][j+1] = -1;
            }
        }
        
        Queue<Location> q = new LinkedList<>(); // BFS 알고리즘 동작을 위한 Queue

        // BFS 알고리즘의 동작에 대해서 기술하는 부분
        visit[1][1] = 1;
        q.add(new Location(1, 1));

        while(!q.isEmpty()) {
            int x = q.peek().getX();
            int y = q.peek().getY();

            // 원하는 목적지에 도달했는 가?
            if(x == n && y == m) break;

            // 좌로 이동이 가능한 가?
            if(x>1 && visit[y][x-1] == 0) {
                visit[y][x-1] = visit[y][x] + 1;
                q.add(new Location(x-1, y));
            }
            // 우로 이동이 가능한 가?
            if(x<m && visit[y][x+1] == 0) {
                visit[y][x+1] = visit[y][x] + 1;
                q.add(new Location(x+1, y));
            }
            // 위로 이동이 가능한 가?
            if(y>1 && visit[y-1][x] == 0) {
                visit[y-1][x] = visit[y][x] + 1;
                q.add(new Location(x, y-1));
            }
            // 아래로 이동이 가능한 가?
            if(y<n && visit[y+1][x] == 0) {
                visit[y+1][x] = visit[y][x] + 1;
                q.add(new Location(x, y+1));
            }

            q.poll();
        }

        System.out.println(visit[n][m]);

        key.close();
        System.exit(0);
    }
}