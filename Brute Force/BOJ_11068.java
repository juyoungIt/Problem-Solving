// BOJ - 11068
// Problem Sheet - https://www.acmicpc.net/problem/11068

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        for (int i=0 ; i<t ; i++) {
            int number = Integer.parseInt(br.readLine());
            sb.append(isValid(number) ? 1 : 0).append("\n");
        }

        System.out.println(sb);

        br.close();
        System.exit(0);
    }

    private static boolean isValid(int number) {
        for (int i=2 ; i<=64 ; i++) {
            int data = number;
            List<Integer> remains = new ArrayList<>();
            while (true) {
                if (data / i == 0) {
                    remains.add(data % i);
                    break;
                }
                remains.add(data % i);
                data /= i;
            }
            if (isPalindrome(remains)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isPalindrome(List<Integer> remains) {
        for (int i=0 ; i<remains.size() / 2 ; i++) {
            if (!remains.get(i).equals(remains.get(remains.size() - 1 - i))) {
                return false;
            }
        }
        return true;
    }
}