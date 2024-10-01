// BOJ - 9047
// Problem Sheet - https://www.acmicpc.net/problem/9047

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        for (int i=0 ; i<t ; i++) {
            int source = Integer.parseInt(br.readLine());
            int operationCount = 0;
            while (true) {
                if (source == 6174) break;
                int result = kaprekar(source);
                operationCount++;
                if (result == 6174) break;
                source = result;
            }
            sb.append(operationCount).append("\n");
        }

        System.out.println(sb);

        br.close();
        System.exit(0);
    }

    private static int kaprekar(int source) {
        int[] digits = valueToArray(source);
        Arrays.sort(digits);
        int min = arrayToValue(digits, false);
        int max = arrayToValue(digits, true);
        return max - min;
    }

    private static int[] valueToArray(int value) {
        int[] arr = new int[4];
        for (int i=3 ; i>=0 ; i--) {
            if (value == 0) break;
            arr[i] = value % 10;
            value /= 10;
        }
        return arr;
    }

    private static int arrayToValue(int[] arr, boolean direction) {
        int value = 0;
        if (direction) {
            for (int i=3 ; i>=0 ; i--) {
                value += arr[i] * (int) Math.pow(10, i);
            }
        } else {
            for (int i=0 ; i<4 ; i++) {
                value += arr[i] * (int) Math.pow(10, arr.length - i - 1);
            }
        }
        return value;
    }
}