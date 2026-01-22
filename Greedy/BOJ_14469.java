// BOJ - 14469
// Problem Sheet - https://www.acmicpc.net/problem/14469

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];
        for (int i=0 ; i<n ; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr, (e1, e2) -> e1[0] - e2[0]);
        long latest = 0;
        for (int i=0 ; i<n ; i++) {
            if (arr[i][0] > latest) latest = arr[i][0];
            latest += arr[i][1];
        }
        System.out.println(latest);
        br.close();
    }
}
