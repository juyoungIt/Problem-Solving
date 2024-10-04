// BOJ - 20650
// Problem Sheet - https://www.acmicpc.net/problem/20650

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        Arrays.sort(arr);

        int a = arr[0];
        int abc = arr[6];
        int bc = abc - a;
        int b = arr[1];
        int c = bc - b;

        System.out.printf("%d %d %d", a, b, c);

        br.close();
        System.exit(0);
    }
}