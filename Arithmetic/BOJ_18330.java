// BOJ - 18330
// Problem Sheet - https://www.acmicpc.net/problem/18330

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        int totalPrice = 0;
        int assigned = 60 + k;
        totalPrice += Math.min(n, assigned) * 1500 + Math.max(0, n - assigned) * 3000;

        System.out.println(totalPrice);

        br.close();
        System.exit(0);
    }
}