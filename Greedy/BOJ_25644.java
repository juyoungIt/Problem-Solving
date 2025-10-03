// BOJ - 25644
// Problem Sheet - https://www.acmicpc.net/problem/25644

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int max = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0 ; i<n ; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, arr[i]);
        }
        int min = max;
        int answer = 0;
        for (int i=0 ; i<n ; i++) {
            min = Math.min(min, arr[i]);
            answer = Math.max(answer, arr[i] - min);
        }
        System.out.println(answer);
        br.close();
    }
}
