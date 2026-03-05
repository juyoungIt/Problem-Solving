// BOJ - 34619
// Problem Sheet - https://www.acmicpc.net/problem/34619

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        br.close();
        int count = 0;
        for (int i=1 ; i<=a ; i++) {
            for (int j=1 ; j<=b ; j++) {
                count += n;
                if (count >= k) {
                    System.out.printf("%d %d", i, j);
                    return;
                }
            }
        }
    }
}
