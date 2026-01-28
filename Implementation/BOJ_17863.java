// BOJ - 17863
// Problem Sheet - https://www.acmicpc.net/problem/17863

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        System.out.println(input.substring(0, 3).equals("555") ? "YES" : "NO");
        br.close();
    }
}
