// BOJ - 15727
// Problem Sheet - https://www.acmicpc.net/problem/15727

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int distance = Integer.parseInt(bf.readLine());

        System.out.println(distance / 5 + (distance % 5 == 0 ? 0 : 1));

        bf.close();
        System.exit(0);
    }
}