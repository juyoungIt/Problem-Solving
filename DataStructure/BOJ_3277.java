// BOJ - 3277
// Problem Sheet - https://www.acmicpc.net/problem/3277

import java.util.*;
import java.io.*;
import java.util.stream.Collectors;

public class Main {

    private static int n;
    private static String[] histories;

    public static void main(String[] args) throws IOException {
        input();
        System.out.println(solve());
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        histories = new String[n];
        for (int i=0 ; i<n ; i++) {
            histories[i] = br.readLine();
        }
        br.close();
    }

    private static String solve() {
        Map<String, Integer> domainMap = new HashMap<>();
        for (String history : histories) {
            String domain = getDomain(history);
            domainMap.put(domain, domainMap.getOrDefault(domain, 0) + 1);
        }
        int maxCount = 0;
        for (int count : domainMap.values()) {
            maxCount = Math.max(maxCount, count);
        }
        int finalMaxCount = maxCount;
        List<Map.Entry<String, Integer>> results = domainMap.entrySet().stream()
                .sorted((e1, e2) -> e2.getValue() - e1.getValue())
                .filter(e -> e.getValue() == finalMaxCount)
                .collect(Collectors.toList());
        StringBuilder sb = new StringBuilder();
        sb.append(finalMaxCount).append("\n");
        for (Map.Entry<String, Integer> entry : results) {
            sb.append(entry.getKey()).append(" ");
        }
        return sb.toString();
    }

    private static String getDomain(String url) {
        String first = url.replace("http://", "");
        String[] tokens = first.split("/");
        String[] last = tokens[0].split("\\.");
        return last[last.length - 1];
    }
}