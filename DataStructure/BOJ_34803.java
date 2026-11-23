// BOJ - 34803
// Problem Sheet - https://acmicpc.net/problem/34803

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int l = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        String[] lottos = new String[n];
        for (int i=0; i<n; i++) {
            lottos[i] = br.readLine();
        }
        int k = Integer.parseInt(br.readLine());
        br.close();
        Map<String, Integer> countMap = new HashMap<>();
        for (String lotto : lottos) {
            for (int i=0; i<=l-k; i++) {
                String sub = lotto.substring(i, i + k);
                countMap.put(sub, countMap.getOrDefault(sub, 0) + 1);
            }
        }
        int score = 0;
        for (int count : countMap.values()) {
            score = Math.max(score, count);
        }
        System.out.println(score);
    }
}
