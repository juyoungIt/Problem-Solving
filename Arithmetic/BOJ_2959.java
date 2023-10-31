// BOJ - 2959
// Problem Sheet - https://www.acmicpc.net/problem/2959

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int[] numbers = Arrays.stream(bf.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        Arrays.sort(numbers);

        System.out.println(numbers[0] * numbers[2]);

        bf.close();
        System.exit(0);
    }
}