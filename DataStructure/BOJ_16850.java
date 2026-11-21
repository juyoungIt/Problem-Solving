// BOJ - 16850
// Problem Sheet - https://acmicpc.net/problem/16850

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int k = Integer.parseInt(br.readLine());
        Map<Integer, Integer> countMap;
        StringTokenizer st;
        for (int i=1; i<=k; i++) {
            int n = Integer.parseInt(br.readLine());
            countMap = new HashMap<>();
            while (n > 0) {
                st = new StringTokenizer(br.readLine());
                while (st.hasMoreElements()) {
                    int p = Integer.parseInt(st.nextToken());
                    n--;
                    if (p == 0) continue;
                    countMap.put(p, countMap.getOrDefault(p, 0) + 1);
                }
            }
            long pairs = 0;
            for (int value : countMap.values()) {
                pairs += (long) (value - 1) * value / 2;
            }
            sb.append(String.format("Data Set %d:\n%d\n\n", i, pairs));
        }
        System.out.println(sb);
        br.close();
    }
}
