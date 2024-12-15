// BOJ - 20568
// Problem Sheet - https://www.acmicpc.net/problem/20568

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .sorted()
                .toArray();

        int answer = 0;
        int prev = 0;
        for (int i=0 ; i<N ; i++) {
            if (arr[i] <= prev) {
                answer++;
            }
            prev = arr[i];
        }

        System.out.println(answer);
        br.close();
    }
}