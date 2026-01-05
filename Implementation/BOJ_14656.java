// BOJ - 14656
// Problem Sheet - https://www.acmicpc.net/problem/14656

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int count = 0;
        for (int i=1 ; i<=n ; i++) {
            int e = Integer.parseInt(st.nextToken());
            if (e != i) count++;
        }
        System.out.println(count);
        br.close();
    }
}
