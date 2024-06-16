// BOJ - 25631
// Problem Sheet - https://www.acmicpc.net/problem/25631

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        Map<Integer, Integer> counts = new HashMap<>();
        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i=0 ; i<n ; i++) {
            int value = Integer.parseInt(st.nextToken());
            counts.put(value, counts.getOrDefault(value, 0) + 1);
        }

        int maxCount = 0;
        for (int count : counts.values()) {
            if (maxCount < count) {
                maxCount = count;
            }
        }

        System.out.println(maxCount);

        br.close();
        System.exit(0);
    }
}