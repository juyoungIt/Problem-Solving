// BOJ - 13300
// Problem Sheet - https://www.acmicpc.net/problem/13300

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<Integer, Integer> maleCount = new HashMap<>();
        Map<Integer, Integer> femaleCount = new HashMap<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        for (int i=0 ; i<n ; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            if (s == 0) femaleCount.put(y, femaleCount.getOrDefault(y, 0) + 1);
            else maleCount.put(y, maleCount.getOrDefault(y, 0) + 1);
        }
        int rc = 0;
        for (int count : maleCount.values()) {
            rc += count / k;
            rc += (count % k > 0) ? 1 : 0;
        }
        for (int count : femaleCount.values()) {
            rc += count / k;
            rc += (count % k > 0) ? 1 : 0;
        }
        System.out.println(rc);
        br.close();
    }
}
