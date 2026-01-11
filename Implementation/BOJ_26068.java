// BOJ - 26068
// Problem Sheet - https://www.acmicpc.net/problem/26068

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(br.readLine());
            int count = 0;
            for (int i=0 ; i<n ; i++) {
                String coupon = br.readLine().substring(2);
                int remain = Integer.parseInt(coupon);
                if (remain > 90) continue;
                count++;
            }
            System.out.println(count);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
