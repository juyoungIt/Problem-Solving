// BOJ - 34935
// Problem Sheet - https://www.acmicpc.net/problem/34935

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        long prev = Long.MIN_VALUE;
        boolean isValid = true;
        for (int i=0 ; i<n ; i++) {
            long cur = Long.parseLong(st.nextToken());
            if (prev >= cur) {
                isValid = false;
                break;
            }
            prev = cur;
        }
        System.out.println(isValid ? 1 : 0);
        br.close();
    }
}
