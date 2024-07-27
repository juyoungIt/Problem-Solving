// BOJ - 27589
// Problem Sheet - https://www.acmicpc.net/problem/27589

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        Map<String, Integer> indexMapper = new HashMap<>();
        for (int i=1 ; i<=n ; i++) {
            indexMapper.put(br.readLine(), i);
        }

        for (int i=0 ; i<q ; i++) {
            st = new StringTokenizer(br.readLine());
            sb.append(
                    Math.abs(
                            indexMapper.get(st.nextToken())
                                    - indexMapper.get(st.nextToken()
                            )
                    ) - 1)
                    .append("\n");
        }
        System.out.println(sb);

        br.close();
        System.exit(0);
    }
}