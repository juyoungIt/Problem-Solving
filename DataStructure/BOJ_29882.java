// BOJ - 29882
// Problem Sheet - https://www.acmicpc.net/problem/29882

import java.util.*;
import java.io.*;

public class Main {

    private static String[] submits;

    public static void main(String[] args) throws IOException {
        input();
        System.out.println(solve());
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        submits = new String[n];
        for (int i=0 ; i<n ; i++) {
            submits[i] = br.readLine();
        }
        br.close();
    }

    private static String solve() {
        Map<String, Map<String, Integer>> scoreMap = new HashMap<>();
        for (String submit : submits) {
            String[] tokens = submit.split(" ");
            String accountName = tokens[0];
            String problemName = tokens[1];
            int score = Integer.parseInt(tokens[2]);
            if (!scoreMap.containsKey(accountName)) {
                scoreMap.put(accountName, new HashMap<>());
            }
            if (scoreMap.get(accountName).get(problemName) == null
                    || scoreMap.get(accountName).get(problemName) < score) {
                scoreMap.get(accountName).put(problemName, score);
            }
        }
        Map<String, Integer> totalScoreMap = new HashMap<>();
        scoreMap.forEach((key, value) -> {
            int totalScore = value.values().stream().mapToInt(Integer::intValue).sum();
            totalScoreMap.put(key, totalScore);
        });
        StringBuilder sb = new StringBuilder();
        totalScoreMap.entrySet().stream()
                .sorted((e1, e2) -> e2.getValue() - e1.getValue())
                .forEach(e -> sb.append(e.getKey()).append(" ").append(e.getValue()).append("\n"));
        return sb.toString();
    }

}