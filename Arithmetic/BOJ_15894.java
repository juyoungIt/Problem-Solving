// BOJ - 15894
// Problem Sheet - https://www.acmicpc.net/problem/15894

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        long bottomLength = Long.parseLong(bf.readLine());

        System.out.println(bottomLength * 4);

        bf.close();
        System.exit(0);
    }
}