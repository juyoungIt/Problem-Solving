// BOJ - 5366
// Problem Sheet - https://www.acmicpc.net/problem/5366

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Map<String, Integer> shotDownMapper = new LinkedHashMap<>();
        while (true) {
            String shotDownFighter = br.readLine();
            if (shotDownFighter.equals("0")) break;
            shotDownMapper.put(shotDownFighter, shotDownMapper.getOrDefault(shotDownFighter, 0) + 1);
        }

        int grandTotal = 0;
        for (Map.Entry<String, Integer> entry : shotDownMapper.entrySet()) {
            sb.append(String.format(entry.getKey() + ": %d\n", entry.getValue()));
            grandTotal += entry.getValue();
        }
        sb.append(String.format("Grand Total: %d\n", grandTotal));
        System.out.println(sb);

        br.close();
        System.exit(0);
    }
}