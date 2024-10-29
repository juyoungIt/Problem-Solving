// BOJ - 13422
// Problem Sheet - https://www.acmicpc.net/problem/13422

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            sb.append(getSuccessCaseCount(br)).append("\n");
        }
        System.out.println(sb);

        br.close();
    }

    private static int getSuccessCaseCount(BufferedReader br) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int money = 0;
        int[] homes = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i=0 ; i<N ; i++) {
            homes[i] = Integer.parseInt(st.nextToken());
            if (i < M) {
                money += homes[i];
            }
        }

        int successCaseCount = 0;
        for (int i=0 ; i<N ; i++) {
            if (money < K) {
                successCaseCount++;
            }
            if (N == M) break;
            money -= homes[i];
            money += homes[getIndex(N, i + M)];
        }

        return successCaseCount;
    }

    private static int getIndex(int N, int index) {
        if (index < N) return index;
        return index - N;
    }
}