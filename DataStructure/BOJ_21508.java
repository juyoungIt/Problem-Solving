// BOJ - 21508
// Problem Sheet - https://www.acmicpc.net/problem/21508

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Map<String, Integer> countMap = new HashMap<>();
        int n = Integer.parseInt(br.readLine());
        for (int i=0 ; i<n ; i++) {
            String code = br.readLine().replaceAll("[^0-9]", "");
            countMap.put(code, countMap.getOrDefault(code, 0) + 1);
        }
        List<String> result = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : countMap.entrySet()) {
            if (1 <= entry.getValue() && entry.getValue() <= 5) {
                result.add(entry.getKey());
            }
        }
        sb.append(result.size()).append("\n");
        result.forEach(e -> sb.append(e).append("\n"));
        System.out.println(sb);
        br.close();
    }
}