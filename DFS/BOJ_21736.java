// BOJ - 21736
// Problem Sheet - https://www.acmicpc.net/problem/21736

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
    private static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int n = Integer.parseInt(st.nextToken()); // 캠퍼스의 세로 길이
        int m = Integer.parseInt(st.nextToken()); // 캠퍼스의 가로 길이
        int startX = 0, startY = 0; // 도연이의 위치
        char[][] campus = new char[n][m]; // 캠퍼스에 대한 정보
        for(int i=0 ; i<n ; i++) {
            String tmp = bf.readLine();
            for(int j=0 ; j<m ; j++) {
                char tmpChar = tmp.charAt(j);
                if(tmpChar == 'I') {
                    startX = j;
                    startY = i;
                }
                campus[i][j] = tmpChar;
            }
        }

        // dfs를 수행하며 만날 수 있는 사람의 수를 셈
        dfs(campus, startX, startY);

        System.out.println((count > 0) ? count : "TT");

        bf.close();
        System.exit(0);
    }

    public static void dfs(char[][] campus, int startX, int startY) {
        int[] xi = {-1, 1, 0, 0}; // x-increment
        int[] yi = {0 ,0, -1, 1}; // y-increment

        campus[startY][startX] = '/';
        for(int i=0 ; i<4 ; i++) {
            int tx = startX + xi[i];
            int ty = startY + yi[i];
            if(validation(tx, ty, campus[0].length, campus.length) && (campus[ty][tx] == 'O' || campus[ty][tx] == 'P')) {
                if(campus[ty][tx] == 'P')
                    count++;
                campus[ty][tx] = '/';
                dfs(campus, tx, ty);
            }
        }
    }

    public static boolean validation(int x, int y, int xLimit, int yLimit) {
        return (x>=0 && y>=0 && x<xLimit && y<yLimit);
    }
}