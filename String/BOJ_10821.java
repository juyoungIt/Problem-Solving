// BOJ - 10821
// Problem Sheet - https://www.acmicpc.net/problem/10821

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] numbers = bf.readLine().split(",");

        System.out.println(numbers.length);

        bf.close();
        System.exit(0);
    }
}