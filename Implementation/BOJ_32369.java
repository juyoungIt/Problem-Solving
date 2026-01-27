// BOJ - 32369
// Problem Sheet - https://www.acmicpc.net/problem/32369

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int[] len = { 1, 1 };
        int comp = 0; // 첫번째 양파를 칭찬 양파로 설정
        while (n-- > 0) {
            len[comp % 2] += a;
            len[(comp + 1) % 2] += b;
            if (len[comp % 2] < len[(comp + 1) % 2]) {
                comp++;
            } else if (len[comp % 2] == len[(comp + 1) % 2]) {
                len[(comp + 1) % 2]--;
            }
        }
        System.out.printf("%d %d\n", Math.max(len[0], len[1]), Math.min(len[0], len[1]));
        br.close();
    }
}
