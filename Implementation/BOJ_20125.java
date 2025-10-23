// BOJ - 20125
// Problem Sheet - https://www.acmicpc.net/problem/20125

import java.util.*;
import java.io.*;

public class Main {

    private static int n;
    private static boolean[][] isCookie;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());
        isCookie = new boolean[n + 1][n + 1];
        for (int i=1 ; i<=n ; i++) {
            String[] row = br.readLine().split("");
            for (int j=0 ; j<n ; j++) {
                char status = row[j].charAt(0);
                if (status == '*') {
                    isCookie[i][j + 1] = true;
                }
            }
        }

        int[] heart = new int[2];
        for (int i=1 ; i<=n ; i++) {
            for (int j=1 ; j<=n ; j++) {
                if (isHeart(i, j)) {
                    heart[0] = i;
                    heart[1] = j;
                }
            }
        }

        int[] parts = new int[5];
        for (int i=heart[1]-1 ; i>=1 && isCookie[heart[0]][i] ; i--) {
            parts[0]++;
        }
        for (int i=heart[1]+1 ; i<=n && isCookie[heart[0]][i] ; i++) {
            parts[1]++;
        }
        int[] endOfBack = new int[2];
        endOfBack[1] = heart[1];
        for (int i=heart[0]+1 ; i<=n && isCookie[i][heart[1]] ; i++) {
            parts[2]++;
            endOfBack[0] = i;
        }
        for (int i=endOfBack[0]+1 ; i<=n && isCookie[i][heart[1] - 1] ; i++) {
            parts[3]++;
        }
        for (int i=endOfBack[0]+1 ; i<=n && isCookie[i][heart[1] + 1] ; i++) {
            parts[4]++;
        }

        sb.append(heart[0]).append(" ").append(heart[1]).append("\n");
        for (int part : parts) sb.append(part).append(" ");
        System.out.println(sb);
        br.close();
    }

    private static boolean isHeart(int x, int y) {
        return isConnected(x - 1, y)
            && isConnected(x + 1, y)
            && isConnected(x, y - 1)
            && isConnected(x, y + 1);
    }

    private static boolean isConnected(int x, int y) {
        return x>=1 && x<=n && y>=1 && y<=n && isCookie[x][y];
    }

}
