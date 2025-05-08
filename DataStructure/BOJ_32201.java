// BOJ - 32201
// Problem Sheet - https://www.acmicpc.net/problem/32201

import java.util.*;
import java.io.*;

public class Main {

    private static Map<Integer, Integer> beforeRank, afterRank, rankDiff;

    public static void main(String[] args) throws IOException {
        input();
        System.out.println(solve());
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        beforeRank = new HashMap<>();
        String[] row = br.readLine().split(" ");
        for (int i=0 ; i<n ; i++) {
            beforeRank.put(Integer.parseInt(row[i]), i);
        }
        afterRank = new LinkedHashMap<>();
        row = br.readLine().split(" ");
        for (int i=0 ; i<n ; i++) {
            afterRank.put(Integer.parseInt(row[i]), i);
        }
        rankDiff = new LinkedHashMap<>();
        br.close();
    }

    private static String solve() {
        StringBuilder sb = new StringBuilder();
        int maxDiff = Integer.MIN_VALUE;
        for(int key : afterRank.keySet()) {
            int diff = beforeRank.get(key) - afterRank.get(key);
            rankDiff.put(key, diff);
            maxDiff = Math.max(maxDiff, diff);
        }
        int finalMaxDiff = maxDiff;
        rankDiff.entrySet().stream()
                .sorted((e1, e2) -> e2.getValue() - e1.getValue())
                .filter(e -> e.getValue() == finalMaxDiff)
                .forEach(e -> sb.append(e.getKey()).append(" "));
        return sb.toString();
    }

}