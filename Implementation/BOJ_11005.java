// BOJ - 11005
// Problem Sheet - https://www.acmicpc.net/problem/11005

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        Stack<Character> results = new Stack<>();
        while (n > 0) {
            results.add(getCharValue(n % b));
            n /= b;
        }

        while (!results.isEmpty()) {
            sb.append(results.pop());
        }
        System.out.println(sb);

        br.close();
    }

    private static char getCharValue(int n) {
        if (n < 10) {
            return (char) (n + '0');
        }
        return (char) (n - 10 + 'A');
    }
}