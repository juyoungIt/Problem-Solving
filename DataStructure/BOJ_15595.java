// BOJ - 15595
// Problem Sheet - https://www.acmicpc.net/problem/15595

import java.util.*;
import java.io.*;

public class Main {

    private static final String adminId = "megalusion";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Map<String, Integer> failedCount = new HashMap<>();
        Set<String> correctUsers = new HashSet<>();
        for (int i=0 ; i<n ; i++) {
            String[] row = br.readLine().split(" ");
            String userId = row[1];
            int result = Integer.parseInt(row[2]);
            if (userId.equals(adminId)) continue;
            if (correctUsers.contains(userId)) continue;
            if (result == 4) {
                correctUsers.add(userId);
            } else {
                failedCount.put(userId, failedCount.getOrDefault(userId, 0) + 1);
            }
        }
        int correctUserCount = correctUsers.size();
        int totalCount = correctUserCount;
        totalCount += failedCount.entrySet().stream()
                .filter(e -> correctUsers.contains(e.getKey()))
                .mapToInt(Map.Entry::getValue)
                .sum();
        if (totalCount == 0) System.out.println(0);
        else System.out.println((((double) correctUserCount) / totalCount) * 100);
        br.close();
    }
}