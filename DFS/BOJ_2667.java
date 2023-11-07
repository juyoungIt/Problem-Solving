// BOJ - 2667
// Problem Sheet - https://www.acmicpc.net/problem/2667

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        List<Integer> results = new LinkedList<>();

        int n = Integer.parseInt(bf.readLine());
        int[][] map = new int[n][n];
        for(int i=0 ; i<n ; i++) {
            String[] row = bf.readLine().split("");
            for(int j=0 ; j<n ; j++) {
                map[i][j] = Integer.parseInt(row[j]);
            }
        }

        for(int i=0 ; i<n ; i++) {
            for(int j=0 ; j<n ; j++) {
                if(map[i][j] > 0) {
                    results.add(search(map, j, i));
                }
            }
        }

        Collections.sort(results);
        sb.append(results.size()).append("\n");
        for(int result : results) {
            sb.append(result).append("\n");
        }
        System.out.println(sb);

        bf.close();
        System.exit(0);
    }

    private static int search(int[][] map, int sx, int sy) {
        Stack<Integer> xStack = new Stack<>();
        Stack<Integer> yStack = new Stack<>();
        int homeCnt = 0;
        int[] incX = { -1, 0, 1, 0 };
        int[] incY = { 0, -1, 0, 1 };

        xStack.add(sx);
        yStack.add(sy);
        map[sy][sx] = 0;
        homeCnt++;
        while(!xStack.isEmpty() && !yStack.isEmpty()) {
            int curX = xStack.peek();
            int curY = yStack.peek();
            int i;
            for(i=0 ; i<4 ; i++) {
                int newX = curX + incX[i];
                int newY = curY + incY[i];
                if(isValid(newX, newY, map.length) && map[newY][newX] > 0) {
                    xStack.push(newX);
                    yStack.push(newY);
                    map[newY][newX] = 0;
                    homeCnt++;
                    break;
                }
            }
            if(i > 3) {
                xStack.pop();
                yStack.pop();
            }
        }
        return homeCnt;
    }

    private static boolean isValid(int x, int y, int n) {
        return x>=0 && x<n && y>=0 && y<n;
    }
}