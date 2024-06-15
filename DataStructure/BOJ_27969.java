// BOJ - 27969
// Problem Sheet - https://www.acmicpc.net/problem/27969

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Stack<String> stack = new Stack<>();
        String[] asonString = br.readLine().split(" ");
        int totalCapacity = 0;
        for (String element : asonString) {
            if (element.equals("]")) {
                while (!stack.isEmpty()) {
                    String tmp = stack.pop();
                    if (tmp.equals("[")) {
                        totalCapacity += 8;
                        break;
                    } else if (isNumber(tmp)) {
                        totalCapacity += 8;
                    } else {
                        totalCapacity += tmp.length() + 12;
                    }
                }
            } else {
                stack.push(element);
            }
        }

        System.out.println(totalCapacity);

        br.close();
        System.exit(0);
    }

    private static boolean isNumber(String element) {
        char[] digits = element.toCharArray();
        for (char digit : digits) {
            if (!Character.isDigit(digit)) {
                return false;
            }
        }
        return true;
    }
}