// BOJ - 11660
// Problem Sheet - https://www.acmicpc.net/problem/11660

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int sizeOfChart = Integer.parseInt(st.nextToken());
        int numberOfQueries = Integer.parseInt(st.nextToken());
        int[][] chart = new int[sizeOfChart+1][sizeOfChart+1];
        int[][] accChart = new int[sizeOfChart+1][sizeOfChart+1];
        for(int i=1 ; i<=sizeOfChart ; i++) {
            st = new StringTokenizer(bf.readLine());
            for(int j=1 ; j<=sizeOfChart ; j++) {
                chart[i][j] = Integer.parseInt(st.nextToken());
                accChart[i][j] = accChart[i-1][j] + accChart[i][j-1] - accChart[i-1][j-1] + chart[i][j];
            }
        }

        for(int i=0 ; i<numberOfQueries ; i++) {
            st = new StringTokenizer(bf.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            sb.append(accChart[x2][y2] - accChart[x1-1][y2] - accChart[x2][y1-1] + accChart[x1-1][y1-1]).append("\n");
        }

        System.out.println(sb);

        bf.close();
        System.exit(0);
    }
}