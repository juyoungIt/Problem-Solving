// BOJ - 4383
// Problem Sheet - https://www.acmicpc.net/problem/4383

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        while (true) {
            String input = br.readLine();
            if (input == null) break;
            st = new StringTokenizer(input);
            int n = Integer.parseInt(st.nextToken());
            int[] arr = new int[n];
            for (int i=0 ; i<n ; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            sb.append(getSequenceType(arr)).append("\n");
        }
        System.out.println(sb);
        br.close();
    }

    private static String getSequenceType(int[] arr) {
        if (arr.length == 1) return "Jolly";
        boolean[] isExistAbs = new boolean[arr.length];
        for (int i=0 ; i<arr.length-1 ; i++) {
            int diffAbs = Math.abs(arr[i] - arr[i + 1]);
            if (diffAbs < 1 || diffAbs > arr.length-1) return "Not jolly";
            isExistAbs[diffAbs] = true;
        }
        for (int i=1 ; i<=arr.length-1 ; i++) {
            if (!isExistAbs[i]) return "Not jolly";
        }
        return "Jolly";
    }
}
