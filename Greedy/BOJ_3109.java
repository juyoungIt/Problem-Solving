// BOJ - 3109
// Problem Sheet - https://www.acmicpc.net/problem/3109

import java.util.*;
import java.io.*;

public class Main {

    private static int r; // 지도 세로의 길이
    private static int c; // 지도 가로의 길이
    private static final int[] xi = {1, 1, 1};  // x-increment
    private static final int[] yi = {-1, 0, 1}; // y-increment
    private static boolean isReached = false; // 목표지점에 도달했는 가에 대한 여부확인
    private static int answer = 0; // 정답

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        int[][] map = new int[r][c]; // 문제의 정보를 담는 지도

        // 입력된 정보를 기반으로 지도를 구성함
        for(int i=0 ; i<r ; i++) {
            String tmp = bf.readLine();
            for(int j=0 ; j<tmp.length() ; j++) {
                if(tmp.charAt(j) == '.') map[i][j] = 0;
                else map[i][j] = 1;
            }
        }

        // 구성한 지도를 바탕으로 탐색을 수행함
        for(int i=0 ; i<r ; i++) {
            isReached = false; // 재사용을 위해 초기화
            dfs(map, 0, i);
        }

        System.out.println(answer);

        bf.close();
        System.exit(0);
    }

    public static void dfs(int[][] map, int startX, int startY) {
        if(isReached) return;
        map[startY][startX] = 2; // 지난 지점임을 표시함
        if(startX == c-1) {
            isReached = true;
            answer++;
            return;
        }
        for(int i=0 ; i<3 ; i++) {
            int tx = startX + xi[i];
            int ty = startY + yi[i];
            if(validation(tx, ty, c, r) && map[ty][tx] == 0) {
                dfs(map, tx, ty);
            }
        }
    }

    public static boolean validation(int x, int y, int xLimit, int yLimit) {
        return (x>=0 && y>=0 && x<xLimit && y<yLimit);
    }
}