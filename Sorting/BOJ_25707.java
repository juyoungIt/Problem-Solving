// BOJ - 25707
// Problem Sheet - https://www.acmicpc.net/problem/25707

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .sorted()
                .toArray();

        long answer = arr[n - 1] - arr[0];
        for (int i=1 ; i<n ; i++) {
            answer += arr[i] - arr[i - 1];
        }
        System.out.println(answer);

        br.close();
    }
}