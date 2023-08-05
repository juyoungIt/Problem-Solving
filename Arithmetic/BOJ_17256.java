// BOJ - 17256
// Problem Sheet - https://www.acmicpc.net/problem/17256

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int[] a = new int[3];
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for(int i=0 ; i<3 ; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        int[] c = new int[3];
        st = new StringTokenizer(bf.readLine());
        for(int i=0 ; i<3 ; i++) {
            c[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0 ; i<3 ; i++) {
            if(i == 1) {
                sb.append(c[i] / a[2-i]).append(" ");
            } else {
                sb.append(c[i] - a[2-i]).append(" ");
            }
        }

        System.out.println(sb);

        bf.close();
        System.exit(0);
    }
}