// BOJ - 14405
// Problem Sheet - https://www.acmicpc.net/problem/14405

import java.io.*;

public class Main {

    static String s;
    static final String PI = "pi", KA = "ka", CHU = "chu";
    static final String YES = "YES", NO = "NO";

    public static void main(String[] args) throws IOException {
        input();
        System.out.println(solve() ? YES : NO);
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        s = br.readLine();
        br.close();
    }

    static boolean solve() {
        int index = 0;
        while (index < s.length()) {
            if (s.charAt(index) == 'p') {
                if (!s.startsWith(PI, index)) return false;
                else index += 2;
            } else if (s.charAt(index) == 'k') {
                if (!s.startsWith(KA, index)) return false;
                else index += 2;
            } else if (s.charAt(index) == 'c') {
                if (!s.startsWith(CHU, index)) return false;
                else index += 3;
            } else {
                return false;
            }
        }
        return true;
    }

}