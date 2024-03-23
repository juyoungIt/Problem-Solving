// BOJ - 27328
// Problem Sheet - https://www.acmicpc.net/problem/27328

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numberA = Integer.parseInt(br.readLine());
        int numberB = Integer.parseInt(br.readLine());

        System.out.println(Integer.compare(numberA, numberB));

        br.close();
        System.exit(0);
    }
}