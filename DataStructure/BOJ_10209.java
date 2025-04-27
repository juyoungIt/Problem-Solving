// BOJ - 10209
// Problem Sheet - https://www.acmicpc.net/problem/10209

import java.util.*;
import java.io.*;

public class Main {

    private static int k;
    private static String[] routes;
    private static final String OUTPUT_FORMAT = "Data Set %d:\n%s\n\n";
    private static final String YES = "Yes";
    private static final String NO = "No";

    public static void main(String[] args) throws IOException {
        input();
        System.out.println(solve());
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        k = Integer.parseInt(br.readLine());
        routes = new String[k];
        for (int i=0 ; i<k ; i++) {
            routes[i] = br.readLine();
        }
        br.close();
    }

    private static String solve() {
        StringBuilder sb = new StringBuilder();
        for (int i=0 ; i<routes.length ; i++) {
            sb.append(String.format(OUTPUT_FORMAT, i + 1, isValid(routes[i]) ? YES : NO));
        }
        return sb.toString();
    }

    private static boolean isValid(String route) {
        Deque<Character> stack = new ArrayDeque<>();
        for (int i=0 ; i<route.length() ; i++) {
            if (stack.isEmpty()) stack.push(route.charAt(i));
            else if (isPair(stack.peek(), route.charAt(i))) stack.pop();
            else stack.push(route.charAt(i));
        }
        return stack.isEmpty();
    }

    private static boolean isPair(char prev, char cur) {
        return (prev == 'u' && cur == 'd')
                || (prev == 'd' && cur == 'u')
                || (prev == 'l' && cur == 'r')
                || (prev == 'r' && cur == 'l');
    }

}