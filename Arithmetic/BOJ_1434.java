// BOJ - 1434
// Problem Sheet - https://www.acmicpc.net/problem/1434

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int totalSumOfBoxes = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .sum();
        int totalSumOfBooks = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .sum();

        System.out.println(totalSumOfBoxes - totalSumOfBooks);

        br.close();
        System.exit(0);
    }
}