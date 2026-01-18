// BOJ - 30868
// Problem Sheet - https://www.acmicpc.net/problem/30868

import java.io.*;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();
            int t = Integer.parseInt(br.readLine());
            while (t-- > 0) {
                int n = Integer.parseInt(br.readLine());
                sb.append("++++ ".repeat(n / 5));
                sb.append("|".repeat(n % 5));
                sb.append("\n");
            }
            System.out.println(sb);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}