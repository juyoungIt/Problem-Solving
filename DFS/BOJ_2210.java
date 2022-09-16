// BOJ - 2210
// Problem Sheet - https://www.acmicpc.net/problem/2210

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        ArrayList<String> numbers = new ArrayList<>(); // 생성할 수 있는 숫자들을 저장

        // 정보를 입력받아 숫자판 정보를 구성함
        int[][] board = new int[5][5]; // 숫자판 정보 저장
        for(int i=0 ; i<5 ; i++) {
            st = new StringTokenizer(bf.readLine());
            for(int j=0 ; j<5 ; j++)
                board[i][j] = Integer.parseInt(st.nextToken());
        }

        // dfs를 수행하며 가능한 숫자를 구성함
        for(int i=0 ; i<5 ; i++) {
            for(int j=0 ; j<5 ; j++) {
                dfs(board, j, i, 0, numbers, sb);
                sb.setLength(0); // 재사용을 위해 초기화
            }
        }

        System.out.println(numbers.size());

        bf.close();
        System.exit(0);
    }

    public static void dfs(int[][] board, int startX, int startY, int depth, ArrayList<String> numbers, StringBuilder sb) {
        int[] xi = {-1, 1, 0, 0}; // x-increment
        int[] yi = {0, 0, -1, 1}; // y-increment

        sb.setLength(depth); // 유효한 길이까지만 성립하도록 StringBuilder를 자름
        if(depth > 5) {
            if(!numbers.contains(sb.toString()))
                numbers.add(sb.toString());
            return;
        }

        sb.append(board[startY][startX]);
        for(int i=0 ; i<4 ; i++) {
            int tx = startX + xi[i];
            int ty = startY + yi[i];
            if(validation(tx, ty))
                dfs(board, tx, ty, depth+1, numbers, sb);
        }
    }

    public static boolean validation(int x, int y) {
        return (x>=0 && y>=0 && x<5 && y<5);
    }
}