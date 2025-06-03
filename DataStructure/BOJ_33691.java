// BOJ - 33691
// Problem Sheet - https://www.acmicpc.net/problem/33691

import java.util.*;
import java.io.*;
import java.util.stream.Collectors;

public class Main {

    private static Map<String, Integer> log;
    private static Set<String> fixed;

    public static void main(String[] args) throws IOException {
        input();
        System.out.println(solve());
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        log = new HashMap<>();
        for (int i=0 ; i<n ; i++) {
            log.put(br.readLine(), i);
        }
        int k = Integer.parseInt(br.readLine());
        fixed = new HashSet<>();
        for (int i=0 ; i<k ; i++) {
            fixed.add(br.readLine());
        }
        br.close();
    }

    private static String solve() {
        StringBuilder sb = new StringBuilder();
        List<String> fixedList = fixed.stream()
                .sorted((c1, c2) -> log.get(c2) - log.get(c1))
                .collect(Collectors.toList());
        for (String container : fixedList) {
            sb.append(container).append("\n");
        }
        List<String> containers = log.entrySet().stream()
                .sorted((c1, c2) -> c2.getValue() - c1.getValue())
                .map(Map.Entry::getKey)
                .filter(c -> !fixed.contains(c))
                .collect(Collectors.toList());
        for (String container : containers) {
            sb.append(container).append("\n");
        }
        return sb.toString();
    }

}