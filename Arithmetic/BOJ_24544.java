// BOJ - 24544
// Problem Sheet - https://www.acmicpc.net/problem/24544

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] interests = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] isRegistered = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int totalInterests = 0;
        int notRegistered = 0;
        for (int i=0 ; i<n ; i++) {
            totalInterests += interests[i];
            if (isRegistered[i] == 0) {
                notRegistered += interests[i];
            }
        }

        System.out.printf("%d\n%d\n", totalInterests, notRegistered);

        br.close();
        System.exit(0);
    }
}