// BOJ - 15873
// Problem Sheet - https://www.acmicpc.net/problem/15873

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int totalSum = 0;

        char[] digits = bf.readLine().toCharArray();
        for(char digit : digits) {
            if(digit == '0') {
                totalSum += 9;
            }
            totalSum += Integer.parseInt(String.valueOf(digit));
        }

        System.out.println(totalSum);

        bf.close();
        System.exit(0);
    }
}