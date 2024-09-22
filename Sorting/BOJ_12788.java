// BOJ - 12788
// Problem Sheet - https://www.acmicpc.net/problem/12788

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int totalNeeds = m * k;
        st = new StringTokenizer(br.readLine());
        int[] ctp = new int[n];
        for (int i=0 ; i<n ; i++) {
            ctp[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(ctp);

        int ctpCount = 0;
        for (int i=n-1 ; i>=0 ; i--) {
            totalNeeds -= ctp[i];
            ctpCount++;
            if (totalNeeds <= 0) break;
        }

        if (totalNeeds > 0) {
            System.out.println("STRESS");
        } else {
            System.out.println(ctpCount);
        }

        br.close();
        System.exit(0);
    }
}