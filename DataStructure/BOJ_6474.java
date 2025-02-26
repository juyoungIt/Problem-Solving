// BOJ - 6474
// Problem Sheet - https://www.acmicpc.net/problem/6474

import java.util.*;
import java.io.*;

public class Main {

    private static final String OUTPUT_FORMAT = "%s -- %s\n\n";
    private static final String NOT_PALINDROME = "is not a palindrome.";
    private static final String PALINDROME = "is a palindrome.";
    private static final String MIRRORED_STRING = "is a mirrored string.";
    private static final String MIRRORED_PALINDROME = "is a mirrored palindrome.";
    private static final Map<Character, Character> reversed = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        init();
        while (true) {
            String candidate = br.readLine();
            if (candidate == null) break;
            int result = solve(candidate);
            switch (result) {
                case 1: // not palindrome
                    sb.append(String.format(OUTPUT_FORMAT, candidate, NOT_PALINDROME));
                    break;
                case 2: // palindrome
                    sb.append(String.format(OUTPUT_FORMAT, candidate, PALINDROME));
                    break;
                case 3: // mirrored string
                    sb.append(String.format(OUTPUT_FORMAT, candidate, MIRRORED_STRING));
                    break;
                case 4: // mirrored palindrome
                    sb.append(String.format(OUTPUT_FORMAT, candidate, MIRRORED_PALINDROME));
                    break;
            }
        }
        System.out.println(sb);
        br.close();
    }

    private static int solve(String word) {
        boolean isPalindrome = isPalindrome(word);
        boolean isMirroredString = isMirroredString(word);
        if (isPalindrome && isMirroredString) return 4;
        else if (isMirroredString) return 3;
        else if (isPalindrome) return 2;
        else return 1;
    }

    private static boolean isPalindrome(String word) {
        Deque<Character> stack = new ArrayDeque<>();
        for (int i=0 ; i<word.length() ; i++) {
            stack.push(word.charAt(i));
        }
        for (int i=0 ; i<word.length() ; i++) {
            if (stack.pop() != word.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    private static boolean isMirroredString(String word) {
        Deque<Character> stack = new ArrayDeque<>();
        for (int i=0 ; i<word.length() ; i++) {
            if (reversed.containsKey(word.charAt(i))) {
                stack.push(reversed.get(word.charAt(i)));
            } else {
                return false;
            }
        }
        for (int i=0 ; i<word.length() ; i++) {
            if (stack.pop() != word.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    private static void init() {
        reversed.put('A', 'A');
        reversed.put('E', '3');
        reversed.put('H', 'H');
        reversed.put('I', 'I');
        reversed.put('J', 'L');
        reversed.put('L', 'J');
        reversed.put('M', 'M');
        reversed.put('O', 'O');
        reversed.put('S', '2');
        reversed.put('T', 'T');
        reversed.put('U', 'U');
        reversed.put('W', 'W');
        reversed.put('X', 'X');
        reversed.put('Y', 'Y');
        reversed.put('Z', '5');
        reversed.put('1', '1');
        reversed.put('2', 'S');
        reversed.put('3', 'E');
        reversed.put('5', 'Z');
        reversed.put('8', '8');
    }
}