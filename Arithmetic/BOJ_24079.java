// BOJ - 24079
// Problem Sheet - https://www.acmicpc.net/problem/24079

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int x = Integer.parseInt(br.readLine());
        int y = Integer.parseInt(br.readLine());
        int z = Integer.parseInt(br.readLine());

        System.out.println((x + y <= z) ? 1 : 0);

        br.close();
        System.exit(0);
    }
}