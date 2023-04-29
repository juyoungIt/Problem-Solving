// BOJ - 1259
// Problem Sheet - https://www.acmicpc.net/problem/1259

import java.util.*;
import java.io.*;

public class Main {

    private static final String IS_PALINDROME = "yes";

    private static final String IS_NOT_PALINDROME = "no";

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while(true) {
            String input = bf.readLine();
            if(input.equals("0")) {
                break;
            }
            sb.append((isPalindrome(input)) ? IS_PALINDROME : IS_NOT_PALINDROME).append("\n");
        }

        System.out.println(sb);

        bf.close();
        System.exit(0);
    }

    private static boolean isPalindrome(String input) {
        boolean result = true;
        Stack<Character> stack = new Stack<>();
        for(int i=0 ; i<input.length()/2 ; i++) {
            stack.push(input.charAt(i));
        }
        for(int i=input.length()/2+input.length()%2 ; i<input.length() ; i++) {
            if(input.charAt(i) != stack.pop()) {
                result = false;
                break;
            }
        }
        return result;
    }
}