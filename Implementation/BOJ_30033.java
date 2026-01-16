// BOJ - 30033
// Problem Sheet - https://www.acmicpc.net/problem/30033

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(br.readLine());
            int[] plan = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            int[] study = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            int successCount = 0;
            for (int i = 0; i < n; i++) {
                if (plan[i] <= study[i]) {
                    successCount++;
                }
            }
            System.out.println(successCount);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}