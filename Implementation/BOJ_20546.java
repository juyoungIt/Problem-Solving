// BOJ - 20546
// Problem Sheet - https://www.acmicpc.net/problem/20546

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] sp = new int[14];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0 ; i<14 ; i++) {
            sp[i] = Integer.parseInt(st.nextToken());
        }
        int b = n, t = n;   // 현금 보유량
        int bs = 0, ts = 0; // 주식 보유량
        for (int i=0 ; i<14 ; i++) {
            // 1. bnp 방식 처리
            int p = b / sp[i];
            bs += p;
            b -= sp[i] * p;
            // 2. timing 방식 처리 (매수 or 매도)
            int a = action(sp, i);
            if (a == 1) {
                p = t / sp[i];
                ts += p;
                t -= sp[i] * p;
            } else if (a == 2) {
                t += sp[i] * ts;
                ts = 0;
            }
        }
        int tb = b + sp[13] * bs; // bnp 방식 총 수익
        int tt = t + sp[13] * ts; // timing 방식 총 수익
        System.out.println(tb == tt ? "SAMESAME" : tb > tt ? "BNP" : "TIMING");
        br.close();
    }

    // 0 - 아무것도 하지 않음 / 1 - 전량 매수 / 2 - 전량 매도
    private static int action(int[] sp, int i) {
        if (i < 3) return 0;
        if (sp[i - 3] < sp[i - 2] && sp[i - 2] < sp[i - 1] && sp[i - 1] < sp[i]) return 2; // 3일 연속 상승장
        if (sp[i - 3] > sp[i - 2] && sp[i - 2] > sp[i - 1] && sp[i - 1] > sp[i]) return 1; // 3일 연속 하락장
        return 0;
    }
}
