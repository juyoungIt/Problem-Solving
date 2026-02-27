// BOJ - 34146
// Problem Sheet - https://www.acmicpc.net/problem/34146

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] counter = new int[10_001];
        for (int i=0 ; i<n ; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0 ; j<m ; j++) {
                counter[Integer.parseInt(st.nextToken())]++;
            }
        }

        boolean isValid = true;
        if (m % 2 == 0) {
            for (int count : counter) {
                if (count % 2 != 0) {
                    isValid = false;
                    break;
                }
            }
        } else {
            int v = n - getOddCount(counter);
            if (!(v >= 0 && v % 2 == 0)) {
                isValid = false;
            }
        }
        System.out.println(isValid ? "YES" : "NO");
        br.close();
    }

    private static int getOddCount(int[] arr) {
        int count = 0;
        for (int e : arr) {
            if (e % 2 == 1) {
                count++;
            }
        }
        return count;
    }
}
