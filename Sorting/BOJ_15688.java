// BOJ - 15688
// Problem Sheet - https://www.acmicpc.net/problem/15688

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for (int i=0 ; i<n ; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        for (int element : arr) {
            sb.append(element).append("\n");
        }
        System.out.println(sb);

        br.close();
        System.exit(0);
    }
}