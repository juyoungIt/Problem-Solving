// BOJ - 23568
// Problem Sheet - https://www.acmicpc.net/problem/23568

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Map<Integer, Integer> movements = new HashMap<>();
        while (n-- > 0) {
            String[] row = br.readLine().split(" ");
            int i = Integer.parseInt(row[0]);
            char j = row[1].charAt(0);
            int k = Integer.parseInt(row[2]);
            movements.put(i, j == 'L' ? -k : k);
        }
        int s = Integer.parseInt(br.readLine());

        while (!movements.isEmpty()) {
            int tmp = s;
            s += movements.get(tmp);
            movements.remove(tmp);
        }

        System.out.println(s);
        br.close();
    }
}