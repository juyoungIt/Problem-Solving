// BOJ - 10807
// Problem Sheet - https://www.acmicpc.net/problem/10807

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int target = Integer.parseInt(br.readLine());

        int answer = 0;
        for (int element : arr) {
            if (element == target) {
                answer++;
            }
        }

        System.out.println(answer);

        br.close();
        System.exit(0);
    }
}