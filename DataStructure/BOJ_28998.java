// BOJ - 28998
// Problem Sheet - https://www.acmicpc.net/problem/28998

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Set<Integer> sumSet = new HashSet<>();
        while (n-- > 0) {
            String[] row = br.readLine().split(" ");
            int x = Integer.parseInt(row[0]);
            int y = Integer.parseInt(row[1]);
            sumSet.add(x + y);
        }
        System.out.println(sumSet.size());
        br.close();
    }
}