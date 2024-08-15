// BOJ - 2752
// Problem Sheet - https://www.acmicpc.net/problem/2752

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] numbers = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        Arrays.sort(numbers);

        System.out.printf("%d %d %d", numbers[0], numbers[1], numbers[2]);

        br.close();
        System.exit(0);
    }
}