// BOJ - 26496
// Problem Sheet - https://www.acmicpc.net/problem/26496

import java.util.*;
import java.io.*;

public class Main {

    private static final String MESSAGE_FORMAT = "%d - %s\n";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            String input = br.readLine();
            if (input == null) break;

            Set<String> palindromes = new LinkedHashSet<>();
            for (int i=1 ; i<=input.length() ; i++) {
                for (int j=0 ; j<input.length()-i + 1 ; j++) {
                    String candidate = input.substring(j, j + i);
                    if (isPalindrome(candidate)) {
                        palindromes.add(candidate);
                    }
                }
            }

            if (isPalindrome(input)) {
                palindromes.add(input);
            }

            StringBuilder tmp = new StringBuilder();
            for (String palindrome : palindromes) {
                tmp.append(String.format("\"%s\" ", palindrome));
            }
            sb.append(String.format(MESSAGE_FORMAT, palindromes.size(), tmp));
        }

        System.out.println(sb);

        br.close();
        System.exit(0);
    }

    private static boolean isPalindrome(String word) {
        StringBuilder reversed = new StringBuilder();
        reversed.append(word).reverse();
        return word.contentEquals(reversed);
    }
}