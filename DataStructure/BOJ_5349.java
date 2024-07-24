// BOJ - 5349
// Problem Sheet - https://www.acmicpc.net/problem/5349

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Map<String, Integer> countMapper = new HashMap<>();
        while (true) {
            String number = br.readLine();
            if (number.equals("000-00-0000")) break;
            countMapper.put(number, countMapper.getOrDefault(number, 0) + 1);
        }

        List<String> duplicated = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : countMapper.entrySet()) {
            if (entry.getValue() > 1) {
                duplicated.add(entry.getKey());
            }
        }
        Collections.sort(duplicated);
        for (String number : duplicated) {
            sb.append(number).append("\n");
        }
        System.out.println(sb);

        br.close();
        System.exit(0);
    }
}