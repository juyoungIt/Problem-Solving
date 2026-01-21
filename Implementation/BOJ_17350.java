// BOJ - 17350
// Problem Sheet - https://www.acmicpc.net/problem/17350

import java.io.*;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(br.readLine());
            for (int i=0 ; i<n ; i++) {
                String name = br.readLine();
                if ("anj".equals(name)) {
                    System.out.println("뭐야;");
                    return;
                }
            }
            System.out.println("뭐야?");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
