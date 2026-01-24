// BOJ - 25630
// Problem Sheet - https://www.acmicpc.net/problem/25630

import java.io.*;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(br.readLine());
            String str = br.readLine();
            int left, right;
            if (n % 2 == 0) {
                left = n / 2 - 1;
                right = n / 2;
            } else {
                left = right = n / 2;
            }
            int count = 0;
            while (left >= 0) {
                if (str.charAt(left--) != str.charAt(right++)) {
                    count++;
                }
            }
            System.out.println(count);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
