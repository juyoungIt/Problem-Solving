// BOJ - 8321
// Problem Sheet - https://www.acmicpc.net/problem/8321

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);
        int s = Integer.parseInt(input[2]);
        int[] arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .sorted()
                .toArray();

        int answer = 0;
        int targetCount = k * s;
        for (int i=n-1 ; i>=0 ; i--) {
            if (targetCount <= 0) break;
            targetCount -= arr[i];
            answer++;
        }

        System.out.println(answer);
        br.close();
    }
}