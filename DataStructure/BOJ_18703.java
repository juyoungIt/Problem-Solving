// BOJ - 18703
// Problem Sheet - https://www.acmicpc.net/problem/18703

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            Map<String, Integer> keyMapper = new HashMap<>();
            for (int i=0 ; i<N ; i++) {
                String[] row = br.readLine().split(" ");
                String fileName = row[0];
                int fileKey = Integer.parseInt(row[1]);
                if (!keyMapper.containsKey(fileName)) {
                    keyMapper.put(fileName, fileKey);
                    continue;
                }
                if (keyMapper.get(fileName) > fileKey) {
                    keyMapper.put(fileName, fileKey);
                    continue;
                }
            }
            int[] keys = keyMapper.values().stream()
                .mapToInt(k -> k.intValue())
                .sorted()
                .toArray();
            for (int key : keys) {
                sb.append(key).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
        br.close();
    }
}