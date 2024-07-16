// BOJ - 5614
// Problem Sheet - https://www.acmicpc.net/problem/5614

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        Map<String, Integer> countMapper = new HashMap<>();
        int n = Integer.parseInt(br.readLine());
        for (int i=0 ; i<n ; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int count = Integer.parseInt(st.nextToken());
            countMapper.put(name, countMapper.getOrDefault(name, 0) + count);
        }

        List<String> productNames = new ArrayList<>(countMapper.keySet());
        productNames.sort((p1, p2) -> {
            if (p1.length() == p2.length()) {
                return p1.compareTo(p2);
            }
            return p1.length() - p2.length();
        });
        for (String productName : productNames) {
            sb.append(productName).append(" ").append(countMapper.get(productName)).append("\n");
        }
        System.out.println(sb);

        br.close();
        System.exit(0);
    }
}