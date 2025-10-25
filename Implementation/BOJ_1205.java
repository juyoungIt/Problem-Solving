// BOJ - 1205
// Problem Sheet - https://www.acmicpc.net/problem/1205

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());

        if (n == 0) {
            System.out.println(1);
            br.close();
            return;
        }

        int[] scores = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i=0 ; i<n ; i++) {
            scores[i] = Integer.parseInt(st.nextToken());
        }

        if (n == p && s <= scores[n - 1]) {
            System.out.println(-1);
            br.close();
            return;
        }

        int rank = 1;
        for (int i=0 ; i<n ; i++) {
            if (scores[i] > s) {
                rank++;
            } else {
                break;
            }
        }

        System.out.println(rank);
        br.close();
    }
}
