// BOJ - 34668
// Problem Sheet - https://www.acmicpc.net/problem/34668

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int q = Integer.parseInt(br.readLine());
        for (int i=0 ; i<q ; i++) {
            int m = Integer.parseInt(br.readLine());
            int[] time = { 6, 6 };
            m -= 50;
            while (m >= 0) {
                addTime(time, 12);
                if (time[0] >= 24) break;
                m -= 50;
            }
            if (m <= 0) sb.append(String.format("%02d:%02d\n", time[0], time[1]));
            else sb.append(-1).append("\n");
        }
        System.out.println(sb);
        br.close();
    }

    private static void addTime(int[] time, int minute) {
        time[0] += (time[1] + minute) / 60;
        time[1] = (time[1] + minute) % 60;
    }
}
