// BOJ - 5575
// Problem Sheet - https://www.acmicpc.net/problem/5575

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        for(int i=0 ; i<3 ; i++) {
            st = new StringTokenizer(bf.readLine());
            int[] start = new int[3];
            int[] end = new int[3];
            for(int j=0 ; j<3 ; j++) {
                start[j] = Integer.parseInt(st.nextToken());
            }
            for(int j=0 ; j<3 ; j++) {
                end[j] = Integer.parseInt(st.nextToken());
            }
            int second = end[2] - start[2];
            int minute = end[1] - start[1];
            int hour = end[0] - start[0];
            if(second < 0) {
                second += 60;
                minute--;
            }
            if(minute < 0) {
                minute += 60;
                hour--;
            }
            sb.append(hour)
                    .append(" ")
                    .append(minute)
                    .append(" ")
                    .append(second)
                    .append("\n");
        }

        System.out.println(sb);

        bf.close();
        System.exit(0);
    }
}