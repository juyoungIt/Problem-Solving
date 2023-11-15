// BOJ - 2145
// Problem Sheet - https://www.acmicpc.net/problem/2145

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while(true) {
            int number = Integer.parseInt(br.readLine());
            if(number == 0) {
                break;
            }
            sb.append(compress(Integer.toString(number))).append("\n");
        }

        System.out.println(sb);

        br.close();
        System.exit(0);
    }

    private static String compress(String number) {
        while(number.length() > 1) {
            number = Integer.toString(getDigitSum(number));
        }
        return number;
    }

    private static int getDigitSum(String number) {
        return Arrays.stream(number.split(""))
                .mapToInt(Integer::parseInt)
                .sum();
    }
}