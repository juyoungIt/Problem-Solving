// BOJ - 24771
// Problem Sheet - https://www.acmicpc.net/problem/24771

import java.util.*;
import java.io.*;
import java.util.stream.Collectors;

public class Main {

    private static final String OUTPUT_FORMAT = "List %d:";
    private static final String COUNT_FORMAT = "%s | %d";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int idx = 1;
        while (true) {
            Map<String, Integer> animals = new HashMap<>();
            int n = Integer.parseInt(br.readLine());
            if (n == 0) break;
            for (int i=0 ; i<n ; i++) {
                String[] name = br.readLine().split(" ");
                String species = name[name.length - 1].toLowerCase();
                animals.put(species, animals.getOrDefault(species, 0) + 1);
            }
            List<Map.Entry<String, Integer>> result = animals.entrySet().stream()
                    .sorted(Map.Entry.comparingByKey())
                    .collect(Collectors.toList());
            sb.append(String.format(OUTPUT_FORMAT, idx++)).append("\n");
            for (Map.Entry<String, Integer> entry : result) {
                sb.append(String.format(COUNT_FORMAT, entry.getKey(), entry.getValue())).append("\n");
            }
        }
        System.out.println(sb);
        br.close();
    }
}
