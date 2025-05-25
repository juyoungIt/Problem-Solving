// BOJ - 25873
// Problem Sheet - https://www.acmicpc.net/problem/25873

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Map<Character, Map<String, Integer>> countMap = new HashMap<>();
        for (int i=0 ; i<n ; i++) {
            String name = br.readLine();
            char firstLetter = name.charAt(0);
            if (!countMap.containsKey(firstLetter)) {
                countMap.put(firstLetter, new HashMap<>());
            }
            countMap.get(firstLetter).put(name, countMap.get(firstLetter).getOrDefault(name, 0) + 1);
        }

        long totalCaseCount = 0;
        for (Map<String, Integer> nameCountMap : countMap.values()) {
            long groupSum = 0;
            for (int count : nameCountMap.values()) {
                groupSum += count;
            }
            long groupPairs = groupSum * (groupSum - 1);
            for (int count : nameCountMap.values()) {
                groupPairs -= (long) count * (count - 1);
            }
            totalCaseCount += groupPairs;
        }

        System.out.println(totalCaseCount);
        br.close();
    }
}