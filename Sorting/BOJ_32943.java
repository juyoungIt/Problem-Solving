// BOJ - 32943
// Problem Sheet - https://www.acmicpc.net/problem/32943

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] input = br.readLine().split(" ");
        int X = Integer.parseInt(input[0]);
        int C = Integer.parseInt(input[1]);
        int K = Integer.parseInt(input[2]);

        int[][] logs = new int[K][3];
        for (int i=0 ; i<K ; i++) {
            input = br.readLine().split(" ");
            logs[i][0] = Integer.parseInt(input[0]);
            logs[i][1] = Integer.parseInt(input[1]);
            logs[i][2] = Integer.parseInt(input[2]);
        }
        Arrays.sort(logs, Comparator.comparingInt(e -> e[0]));

        int[] students = new int[X + 1];
        int[] chairs = new int[C + 1];
        for (int i=0 ; i<K ; i++) {
            int S = logs[i][1];
            int N = logs[i][2];
            if (chairs[S] > 0) continue;
            if (students[N] > 0) chairs[students[N]] = 0;
            chairs[S] = N;
            students[N] = S;
        }

        for (int i=1 ; i<=X ; i++) {
            if (students[i] == 0) continue;
            sb.append(i).append(" ").append(students[i]).append("\n");
        }

        System.out.println(sb);
        br.close();
    }
}