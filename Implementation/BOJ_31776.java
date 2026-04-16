// BOJ - 31776
// Problem Sheet - https://www.acmicpc.net/problem/31776

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int count = 0;
        for (int i=1 ; i<=n ; i++) {
            st = new StringTokenizer(br.readLine());
            int t1 = Integer.parseInt(st.nextToken());
            int t2 = Integer.parseInt(st.nextToken());
            int t3 = Integer.parseInt(st.nextToken());
            if (isValid(t1, t2, t3)) count++;
        }
        System.out.println(count);
        br.close();
    }

    private static boolean isValid(int t1, int t2, int t3) {
        if (t1 < 0) return false;
        if (t2 < 0) {
            return t3 < 0;
        } else {
            if (t1 > t2) return false;
            if (t3 < 0) return true;
            else return t2 <= t3;
        }
    }
}