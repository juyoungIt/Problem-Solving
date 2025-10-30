// BOJ - 18206
// Problem Sheet - https://www.acmicpc.net/problem/18206

import java.util.*;
import java.io.*;

public class Main {

    enum Answer {
        Yes, No
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String p = br.readLine();
        System.out.println(check(p, s) ? Answer.Yes : Answer.No);
        br.close();
    }

    private static boolean check(String s1, String s2) {
        return checkCaseA(s1, s2)
                || checkCaseB(s1, s2)
                || checkCaseC(s1, s2)
                || checkCaseD(s1, s2);
    }

    // 1. P와 S가 동일한 경우
    private static boolean checkCaseA(String s1, String s2) {
        return s1.equals(s2);
    }

    // 2. P의 맨 앞에 숫자 하나를 추가하여 S를 만들 수 있는 경우
    private static boolean checkCaseB(String s1, String s2) {
        return s2.substring(1).equals(s1) && Character.isDigit(s2.charAt(0));
    }

    // 3. P의 맨 뒤에 숫자 하나를 추가하여 S를 만들 수 있는 경우
    private static boolean checkCaseC(String s1, String s2) {
        return s2.substring(0, s2.length() - 1).equals(s1) && Character.isDigit(s2.charAt(s2.length() - 1));
    }

    // 4. P에 포함된 모든 대소문자를 반전시킨후 S와 같은 경우
    private static boolean checkCaseD(String s1, String s2) {
        StringBuilder sb = new StringBuilder();
        for (int i=0 ; i<s1.length() ; i++) {
            char c = s1.charAt(i);
            if (Character.isAlphabetic(c)) {
                if (Character.isLowerCase(c)) sb.append(Character.toUpperCase(c));
                else sb.append(Character.toLowerCase(c));
            } else {
                sb.append(c);
            }
        }
        return sb.toString().equals(s2);
    }

}
