// BOJ - 1477
// Problem Sheet - https://www.acmicpc.net/problem/1477

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        int[] stations = new int[n + 2];
        st = new StringTokenizer(br.readLine());
        stations[0] = 0;
        stations[n+1] = l;
        for (int i=1 ; i<=n ; i++) {
            stations[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(stations);

        int left = 1;
        int right = l;
        while (left <= right) {
            int mid = (left + right) / 2;
            int buildableCount = 0;
            for (int i=1 ; i< stations.length ; i++) {
                buildableCount += (stations[i] - stations[i-1] - 1) / mid;
            }
            if (buildableCount > m) left = mid + 1;
            else right = mid - 1;
        }

        System.out.println(left);

        br.close();
        System.exit(0);
    }
}