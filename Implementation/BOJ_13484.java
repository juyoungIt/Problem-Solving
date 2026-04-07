// BOJ - 13484
// Problem Sheet - https://www.acmicpc.net/problem/13484

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        int carry = 0;
        while (n-- > 0) {
            int p = Integer.parseInt(br.readLine());
            carry += x - p;
        }
        System.out.println(x + carry);
        br.close();
    }
}