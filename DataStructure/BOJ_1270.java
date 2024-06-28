// BOJ - 1270
// Problem Sheet - https://www.acmicpc.net/problem/1270

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        for (int i=0 ; i<n ; i++) {
            Map<Long, Integer> countMapper = new HashMap<>();
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            for (int j=0 ; j<t ; j++) {
                long nij = Long.parseLong(st.nextToken());
                countMapper.put(nij, countMapper.getOrDefault(nij, 0) + 1);
            }
            boolean isWarEnd = false;
            double criteria = (double) t / 2;
            for(Map.Entry<Long, Integer> entry : countMapper.entrySet()) {
                if (criteria < entry.getValue()) {
                    sb.append(entry.getKey()).append("\n");
                    isWarEnd = true;
                    break;
                }
            }
            if (!isWarEnd) sb.append("SYJKGW").append("\n");
        }

        System.out.println(sb);

        br.close();
        System.exit(0);
    }
}