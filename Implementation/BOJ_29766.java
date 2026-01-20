// BOJ - 29766
// Problem Sheet - https://www.acmicpc.net/problem/29766

import java.io.*;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String str = br.readLine();
            int cnt = 0;
            for (int i = 0; i < str.length(); i++) {
                if ("DKSH".equals(str.substring(i, Math.min(i + 4, str.length())))) {
                    cnt++;
                }
            }
            System.out.println(cnt);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}