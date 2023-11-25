// BOJ - 30031
// Problem Sheet - https://www.acmicpc.net/problem/30031

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        Map<Integer, Integer> valueMapper = new HashMap<>();
        valueMapper.put(136, 1_000);
        valueMapper.put(142, 5_000);
        valueMapper.put(148, 10_000);
        valueMapper.put(154, 50_000);

        int n = Integer.parseInt(br.readLine());
        int totalPrice = 0;
        for(int i=0 ; i<n ; i++) {
            st = new StringTokenizer(br.readLine());
            int width = Integer.parseInt(st.nextToken());
            int height = Integer.parseInt(st.nextToken());
            totalPrice += valueMapper.get(width);
        }

        System.out.println(totalPrice);

        br.close();
        System.exit(0);
    }
}