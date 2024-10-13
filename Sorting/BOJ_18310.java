// BOJ - 18310
// Problem Sheet - https://www.acmicpc.net/problem/18310

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] homes = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .sorted()
                .toArray();

        System.out.println(homes[(n-1)/2]);

        br.close();
    }
}