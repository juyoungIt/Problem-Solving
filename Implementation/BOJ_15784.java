// BOJ - 15784
// Problem Sheet - https://www.acmicpc.net/problem/15784

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int[][] arr = new int[n + 1][n + 1];
            for (int i=1 ; i<=n ; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j=1 ; j<=n ; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            for (int i=1 ; i<=n ; i++) {
                if (arr[a][b] < arr[a][i] || arr[a][b] < arr[i][b]) {
                    System.out.println("ANGRY");
                    return;
                }
            }
            System.out.println("HAPPY");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
