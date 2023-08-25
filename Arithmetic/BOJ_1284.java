// BOJ - 1284
// Problem Sheet - https://www.acmicpc.net/problem/1284

import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while(true) {
            char[] numbers = bf.readLine().toCharArray();
            int width = 0;
            if(numbers[0] == '0') {
                break;
            }
            for(char number : numbers) {
                width += getWidthOfNumber(number);
            }
            width += numbers.length + 1;
            sb.append(width).append("\n");
        }

        System.out.println(sb);

        bf.close();
        System.exit(0);
    }

    private static int getWidthOfNumber(char number) {
        if(number == '0') {
            return 4;
        } else if(number == '1') {
            return 2;
        } else {
            return 3;
        }
    }
}