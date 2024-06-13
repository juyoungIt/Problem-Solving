// BOJ - 28446
// Problem Sheet - https://www.acmicpc.net/problem/28446

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int m = Integer.parseInt(br.readLine());
        Map<Integer, Integer> lockerMapper = new HashMap<>();
        for (int i=0 ; i<m ; i++) {
            st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());
            if (command == 1) {
                int x = Integer.parseInt(st.nextToken());
                int w = Integer.parseInt(st.nextToken());
                lockerMapper.put(w, x);
            } else {
                int w = Integer.parseInt(st.nextToken());
                sb.append(lockerMapper.get(w)).append("\n");
            }
        }

        System.out.println(sb);

        br.close();
        System.exit(0);
    }
}