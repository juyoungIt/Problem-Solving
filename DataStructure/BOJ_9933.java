// BOJ - 9933
// Problem Sheet - https://www.acmicpc.net/problem/9933

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        Set<String> words = new HashSet<>();
        String password = "";

        int n = Integer.parseInt(bf.readLine());
        for(int i=0 ; i<n ; i++) {
            String word = bf.readLine();
            if(isPalindrome(word)) {
                password = word;
                break;
            } else if(words.contains(getReverseWord(word))) {
                password = word;
                break;
            } else {
                words.add(word);
            }
        }

        System.out.println(password.length() + " " + password.charAt(password.length() / 2));

        bf.close();
        System.exit(0);
    }

    static String getReverseWord(String word) {
        StringBuilder sb = new StringBuilder();
        Stack<Character> letters = new Stack<>();

        for(int i=0 ; i<word.length() ; i++) {
            letters.add(word.charAt(i));
        }

        while(!letters.isEmpty()) {
            sb.append(letters.pop());
        }

        return sb.toString();
    }

    static boolean isPalindrome(String password) {
        return password.equals(getReverseWord(password));
    }
}