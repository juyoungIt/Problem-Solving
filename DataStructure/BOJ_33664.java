// BOJ - 33664
// Problem Sheet - https://www.acmicpc.net/problem/33664

import java.util.*;
import java.io.*;

public class Main {

    private static final String ACCEPTABLE = "acceptable";
    private static final String UNACCEPTABLE = "unacceptable";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] row = br.readLine().split(" ");
        long b = Long.parseLong(row[0]);
        int n = Integer.parseInt(row[1]);
        int m = Integer.parseInt(row[2]);
        Map<String, Long> items = new HashMap<>();
        for (int i=0 ; i<n ; i++) {
            row = br.readLine().split(" ");
            items.put(row[0], Long.parseLong(row[1]));
        }
        long totalPrice = 0;
        for (int i=0 ; i<m ; i++) {
            totalPrice += items.get(br.readLine());
        }
        System.out.println(totalPrice <= b ? ACCEPTABLE : UNACCEPTABLE);
        br.close();
    }
}