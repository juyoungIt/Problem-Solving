// BOJ - 4677
// Problem Sheet - https://www.acmicpc.net/problem/4677

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        ArrayList<Integer> answers = new ArrayList<>(); // 각 테스트 케이스에 대한 정답

        while(true) {
            st = new StringTokenizer(bf.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int count = 0;

            // 0, 0이 연속으로 입력된 경우 - 프로그램을 종료함
            if(n == 0 && m == 0) break;

            // 입력받은 정보를 바탕으로 매장지 정보를 구성함
            char[][] map = new char[n][m]; // 석유 매장지 정보
            for(int i=0 ; i<n ; i++) {
                String tmp = bf.readLine();
                for(int j=0 ; j<m ; j++)
                    map[i][j] = tmp.charAt(j);
            }

            // DFS를 수행하여 석유 매장지 정보를 카운트 함
            for(int i=0 ; i<n ; i++) {
                for(int j=0 ; j<m ; j++) {
                    if(map[i][j] == '@') {
                        dfs(map, j, i);
                        count++;
                    }
                }
            }

            // 카운트 결과를 추가함
            answers.add(count);
        }

        // 모인 정답들을 출력함
        for(int answer : answers)
            System.out.println(answer);

        bf.close();
        System.exit(0);
    }

    public static void dfs(char[][] map, int startX, int startY) {
        int[] xi = {-1, 0, 1, 1, 1, 0, -1, -1}; // x-increment
        int[] yi = {-1, -1, -1, 0, 1, 1, 1, 0}; // y-increment

        map[startY][startX] = 'X';
        for(int i=0 ; i<8 ; i++) {
            int tx = startX + xi[i];
            int ty = startY + yi[i];
            if(validation(tx, ty, map[0].length, map.length) && map[ty][tx] == '@') {
                map[ty][tx] = 'X';
                dfs(map, tx, ty);
            }
        }
    }

    public static boolean validation(int x, int y, int xLimit, int yLimit) {
        return (x>=0 && y>=0 && x<xLimit && y<yLimit);
    }
}