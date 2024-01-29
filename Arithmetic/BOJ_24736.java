// BOJ - 24736
// Problem Sheet - https://www.acmicpc.net/problem/24736

import java.util.*;
import java.io.*;

public class Main {

    private static final Map<Integer, Integer> pointMapper = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        pointMapper.put(0, 6);
        pointMapper.put(1, 3);
        pointMapper.put(2, 2);
        pointMapper.put(3, 1);
        pointMapper.put(4, 2);

        for(int i=0 ; i<2 ; i++) {
            st = new StringTokenizer(br.readLine());
            int totalScore = 0;
            for(int j=0 ; j<5 ; j++) {
                int cnt = Integer.parseInt(st.nextToken());
                totalScore += pointMapper.get(j) * cnt;
            }
            sb.append(totalScore).append(" ");
        }

        System.out.println(sb);

        br.close();
        System.exit(0);
    }
}