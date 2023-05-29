// BOJ - 10822
// Problem Sheet - https://www.acmicpc.net/problem/10822

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] numbers = bf.readLine().split(",");
        int result = 0;

        for(String number : numbers) {
            result += Integer.parseInt(number);
        }

        System.out.println(result);

        bf.close();
        System.exit(0);
    }
}