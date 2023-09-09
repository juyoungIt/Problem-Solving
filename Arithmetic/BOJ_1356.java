// BOJ - 1356
// Problem Sheet - https://www.acmicpc.net/problem/1356

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String number = bf.readLine();

        boolean isValid = false;
        for(int i=1 ; i<number.length() ; i++) {
            if(getDigitMult(number.substring(0, i)) == getDigitMult(number.substring(i))) {
                isValid = true;
                break;
            }
        }

        System.out.println(isValid ? "YES" : "NO");

        bf.close();
        System.exit(0);
    }

    private static int getDigitMult(String number) {
        String[] digits = number.split("");
        return Arrays.stream(digits)
                .mapToInt(Integer::parseInt)
                .reduce(1, (a, b) -> a * b);
    }
}