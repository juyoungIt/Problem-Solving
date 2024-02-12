// BOJ - 2991
// Problem Sheet - https://www.acmicpc.net/problem/2991

import java.util.*;
import java.io.*;

public class Main {

    private static int a, b, c, d;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int p = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        sb.append(getAttackedCnt(p)).append("\n");
        sb.append(getAttackedCnt(m)).append("\n");
        sb.append(getAttackedCnt(n)).append("\n");

        System.out.println(sb);

        br.close();
        System.exit(0);
    }

    private static int getAttackedCnt(int arrivedTime) {
        int attackedCnt = 0;
        int tmpA = arrivedTime % (a + b);
        int tmpB = arrivedTime % (c + d);
        if(tmpA > 0 && tmpA <= a) {
            attackedCnt++;
        }
        if(tmpB > 0 && tmpB <= c) {
            attackedCnt++;
        }
        return attackedCnt;
    }
}