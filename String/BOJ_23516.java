// BOJ - 23516
// Problem Sheet - https://www.acmicpc.net/problem/23516

import java.util.*;
import java.io.*;

public class Main {

    private static final String NO_SOLUTION = "No solution";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String t = br.readLine();
        boolean isValid = true;
        for (int i=1 ; i<=Math.min(s.length(), t.length()) ; i++) {
            // 애초에 약수가 될 수 없는 길이는 탐색 대상에서 제외시킴
            if (s.length() % i != 0 || t.length() % i != 0) continue;
            // 1. s의 약수가 될 수 있는 길이인지?
            isValid = true;
            String token = s.substring(0, i);
            for (int j=0 ; j<s.length() ; j+=i) {
                String part = s.substring(j, j + i);
                if (!part.equals(token)) {
                    isValid = false;
                    break;
                }
            }
            if (!isValid) continue;
            // 2. t의 약수가 될 수 있는 길이인지?
            for (int j=0 ; j<t.length() ; j+=i) {
                String part = t.substring(j, j + i);
                if (!part.equals(token)) {
                    isValid = false;
                    break;
                }
            }
            if (isValid) {
                System.out.println(token);
                break;
            }
        }
        if (!isValid) System.out.println(NO_SOLUTION);
        br.close();
    }
}