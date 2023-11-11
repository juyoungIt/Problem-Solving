// BOJ - 14726
// Problem Sheet - https://www.acmicpc.net/problem/14726

import java.util.*;
import java.io.*;

public class Main {

    enum RESULT {
        T, F
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(bf.readLine());
        for(int i=0 ; i<t ; i++) {
            String[] creditNumber = bf.readLine().split("");
            sb.append(validation(creditNumber) ? RESULT.T : RESULT.F).append("\n");
        }

        System.out.println(sb);

        bf.close();
        System.exit(0);
    }

    private static boolean validation(String[] creditNumber) {
        for(int i=15 ; i>=0 ; i--) {
            if(i % 2 == 0) {
                int num = Integer.parseInt(creditNumber[i]) * 2;
                if(num >= 10) {
                    num = num / 10 + num % 10;
                }
                creditNumber[i] = Integer.toString(num);
            }
        }
        int sum = Arrays.stream(creditNumber)
                .mapToInt(Integer::parseInt)
                .sum();
        return sum % 10 == 0;
    }

}