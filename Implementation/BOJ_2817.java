// BOJ - 2817
// Problem Sheet - https://www.acmicpc.net/problem/2817

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int x = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        double[][] scores = new double[14 * 26][2];
        int[] staffs = new int[26];
        Arrays.fill(staffs, -1);
        for (int i=0 ; i<n ; i++) {
            st = new StringTokenizer(br.readLine());
            char name = st.nextToken().charAt(0);
            int count = Integer.parseInt(st.nextToken());
            if ((double)count / x < 0.05) {
                continue;
            }
            staffs[name - 'A'] = 0;
            for (int j=1 ; j<=14 ; j++) {
                scores[14 * i + j - 1][0] = name - 'A';
                scores[14 * i + j - 1][1] = (double) count / j;
            }
        }
        Arrays.sort(scores, (o1, o2) -> Double.compare(o2[1], o1[1]));

        for (int i=0 ; i<14 ; i++) {
            staffs[(int)scores[i][0]]++;
        }

        for (int i=0 ; i<26 ; i++) {
            if (staffs[i] >= 0) {
                sb.append((char)(i + 'A'))
                        .append(" ")
                        .append(staffs[i])
                        .append("\n");
            }
        }
        System.out.println(sb);

        br.close();
        System.exit(0);
    }
}