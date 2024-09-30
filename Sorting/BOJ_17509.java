// BOJ - 17509
// Problem Sheet - https://www.acmicpc.net/problem/17509

import java.util.*;
import java.io.*;

public class Main {

    private static final int INPUT_SIZE = 11;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int[][] solved = new int[INPUT_SIZE + 1][2];
        for (int i=1 ; i<=INPUT_SIZE ; i++) {
            st = new StringTokenizer(br.readLine());
            solved[i][0] = Integer.parseInt(st.nextToken());
            solved[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(solved, Comparator.comparingInt(e -> e[0]));

        int totalPenalty = 0;
        for (int i=1 ; i<=INPUT_SIZE ; i++) {
            solved[i][0] += solved[i - 1][0];
            totalPenalty += getPenalty(solved[i][0], solved[i][1]);
        }
        System.out.println(totalPenalty);

        br.close();
        System.exit(0);
    }

    private static int getPenalty(int d, int v) {
        return d + 20 * v;
    }
}