// BOJ - 2232
// Problem Sheet - https://www.acmicpc.net/problem/2232

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] origin = new int[N];
        int[][] P = new int[N][2];
        boolean[] isExploded = new boolean[N];
        List<Integer> triggered = new ArrayList<>();
        for (int i=0 ; i<N ; i++) {
            P[i][0] = i;
            P[i][1] = Integer.parseInt(br.readLine());
            origin[i] = P[i][1];
        }
        Arrays.sort(P, (e1, e2) -> e2[1] - e1[1]);

        int remainMines = N;
        for (int i=0 ; i<N; i++) {
            if (remainMines == 0) break;
            if (isExploded[P[i][0]]) continue;
            isExploded[P[i][0]] = true;
            remainMines--;
            triggered.add(P[i][0] + 1);
            // 왼쪽 방향 사이드 이펙트 체크
            int curIndexForLeft = P[i][0];
            while (curIndexForLeft > 0) {
                if (origin[curIndexForLeft - 1] >= origin[curIndexForLeft]
                        || isExploded[curIndexForLeft - 1]) {
                    break;
                }
                isExploded[curIndexForLeft - 1] = true;
                remainMines--;
                curIndexForLeft--;
            }
            // 오른쪽 방향 사이드 이펙트 체크
            int curIndexForRight = P[i][0];
            while (curIndexForRight < N - 1) {
                if (origin[curIndexForRight] <= origin[curIndexForRight + 1]
                        || isExploded[curIndexForRight + 1]) {
                    break;
                }
                isExploded[curIndexForRight + 1] = true;
                remainMines--;
                curIndexForRight++;
            }
        }
        Collections.sort(triggered);

        for (int index : triggered) {
            sb.append(index).append("\n");
        }
        System.out.println(sb);

        br.close();
    }
}