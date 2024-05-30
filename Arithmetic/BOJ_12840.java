// BOJ - 12840
// Problem Sheet - https://www.acmicpc.net/problem/12840

import java.time.LocalTime;
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int h = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(br.readLine());
        LocalTime curTime = LocalTime.of(h, m, s);
        for (int i=0 ; i<q ; i++) {
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            if (t == 1) {
                int c = Integer.parseInt(st.nextToken());
                curTime = curTime.plusSeconds(c);
            } else if (t == 2) {
                int c = Integer.parseInt(st.nextToken());
                curTime = curTime.minusSeconds(c);
            } else {
                sb.append(String.format("%d %d %d\n", curTime.getHour(), curTime.getMinute(), curTime.getSecond()));
            }
        }

        System.out.println(sb);

        br.close();
        System.exit(0);
    }
}