// BOJ - 13717
// Problem Sheet - https://www.acmicpc.net/problem/13717

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int count = 0;
        int maxCount = 0;
        String maxName = "";
        while (n-- > 0) {
            String name = br.readLine();
            String[] row = br.readLine().split(" ");
            int k = Integer.parseInt(row[0]);
            int m = Integer.parseInt(row[1]);
            int partCount = 0;
            while (m >= k) {
                count++;
                partCount++;
                m -= k;
                m += 2;
            }
            if (partCount > maxCount) {
                maxCount = partCount;
                maxName = name;
            }
        }
        System.out.println(count);
        System.out.println(maxName);
        br.close();
    }
}
