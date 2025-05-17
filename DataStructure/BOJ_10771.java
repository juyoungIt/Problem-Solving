// BOJ - 10771
// Problem Sheet - https://www.acmicpc.net/problem/10771

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int m = Integer.parseInt(br.readLine());
        int currentTime = 0;
        Set<Integer> users = new HashSet<>();
        Map<Integer, Integer> waiting = new HashMap<>();
        Map<Integer, Integer> result = new HashMap<>();
        boolean beforeW = false;
        for (int i=0 ; i<m ; i++) {
            String[] row = br.readLine().split(" ");
            char action = row[0].charAt(0);
            int value = Integer.parseInt(row[1]);
            boolean needIncrease = i != 0 && !beforeW;
            if (action == 'R') {
                if (needIncrease) currentTime++;
                waiting.put(value, currentTime);
                beforeW = false;
                users.add(value);
            } else if (action == 'S') {
                if (needIncrease) currentTime++;
                result.put(value, result.getOrDefault(value, 0) + currentTime - waiting.get(value));
                waiting.remove(value);
                beforeW = false;
            } else if (action == 'W') {
                currentTime += value;
                beforeW = true;
            } else {
                throw new IllegalArgumentException("invalid action...");
            }
        }

        users.stream()
                .sorted()
                .forEach(u -> {
                    if (waiting.containsKey(u)) {
                        sb.append(String.format("%d %d\n", u, -1));
                    } else {
                        sb.append(String.format("%d %d\n", u, result.get(u)));
                    }
                });
        System.out.println(sb);
        br.close();
    }
}