// BOJ - 1926
// Problem Sheet - https://www.acmicpc.net/problem/1926

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

        int n = Integer.parseInt(st.nextToken()); // 도화지의 세로크기
        int m = Integer.parseInt(st.nextToken()); // 도화지의 가로크기
        int[][] painting = new int[n][m]; // 그림을 나타내는 부분
        ArrayList<Integer> answers = new ArrayList<>(); // 정답을 저장하는 부분

        // 입력된 정보를 바탕으로 그림을 구성함
        for(int i=0 ; i<n ; i++) {
            st = new StringTokenizer(bf.readLine());
            for(int j=0 ; j<m ; j++)
                painting[i][j] = Integer.parseInt(st.nextToken());
        }

        // bfs하여 각 영역들의 넓이를 구함
        for(int i=0 ; i<n ; i++)
            for(int j=0 ; j<m ; j++)
                if(painting[i][j] == 1)
                    answers.add(bfsWithArea(painting, j, i));
        Collections.sort(answers); // 오름차순 정렬

        // 그림의 갯수, 가장 넓은 그림의 넓이 출력
        int size = answers.size();
        System.out.println(size);
        System.out.println((size == 0) ? 0 : answers.get(size-1));

        bf.close();
        System.exit(0);
    }

    // bfs를 수행하여 탐색한 넓이의 영역을 반환함
    public static int bfsWithArea(int[][] painting, int startX, int startY) {
        Queue<Location> queue = new LinkedList<>(); // bfs를 위한 queue
        int[] xi = {-1, 1, 0, 0}; // x-increment
        int[] yi = {0, 0, -1, 1}; // y-increment
        int area = 0; // 탐색한 영역의 넓이

        painting[startY][startX] = 2;
        queue.add(new Location(startX, startY));
        area++;
        while(!queue.isEmpty()) {
            int curX = queue.peek().getX();
            int curY = queue.peek().getY();
            for(int i=0 ; i<4 ; i++) {
                int tx = curX + xi[i];
                int ty = curY + yi[i];
                if(validation(tx, ty, painting[0].length, painting.length) && painting[ty][tx] == 1) {
                    painting[ty][tx] = 2;
                    queue.add(new Location(tx, ty));
                    area++;
                }
            }
            queue.poll();
        }
        return area;
    }

    // 해당 좌표가 유효한 좌표의 범위인지 판단함
    public static boolean validation(int x, int y, int xLimit, int yLimit) {
        return (x>=0  && y>=0 && x<xLimit && y<yLimit);
    }
}