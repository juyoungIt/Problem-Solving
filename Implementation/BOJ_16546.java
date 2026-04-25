// BOJ - 16546
// Problem Sheet - https://www.acmicpc.net/problem/16546

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean[] isFinished = new boolean[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        br.close();
        while (st.hasMoreElements()) {
            isFinished[Integer.parseInt(st.nextToken())] = true;
        }
        for (int i=1 ; i<=n ; i++) {
            if (!isFinished[i]) {
                System.out.println(i);
                return;
            }
        }
    }
}
