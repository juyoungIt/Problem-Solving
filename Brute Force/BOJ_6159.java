// BOJ - 6159
// Problem Sheet - https://www.acmicpc.net/problem/6159

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        for (int i=0 ; i<n ; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int answer = 0;
        for (int i=0 ; i<n-1 ; i++) {
            for (int j=i+1 ; j<n ; j++) {
                int sum = arr[i] + arr[j];
                if (sum <= s) answer++;
            }
        }
        System.out.println(answer);

        br.close();
        System.exit(0);
    }
}