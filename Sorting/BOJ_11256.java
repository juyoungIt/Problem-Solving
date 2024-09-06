// BOJ - 11256
// Problem Sheet - https://www.acmicpc.net/problem/11256

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        for (int i=0 ; i<t ; i++) {
            st = new StringTokenizer(br.readLine());
            int j = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            int[] capacities = new int[n];
            for (int k=0 ; k<n ; k++) {
                st = new StringTokenizer(br.readLine());
                int r = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                capacities[k] = r * c;
            }
            Arrays.sort(capacities);
            int boxCount = 0;
            for (int k=n-1 ; k>=0 ; k--) {
                j -= capacities[k];
                boxCount++;
                if (j <= 0) break;
            }
            sb.append(boxCount).append("\n");
        }

        System.out.println(sb);

        br.close();
        System.exit(0);
    }
}