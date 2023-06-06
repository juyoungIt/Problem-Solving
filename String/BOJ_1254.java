// BOJ - 1254
// Problem Sheet - https://www.acmicpc.net/problem/1254

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int result = 0;

        String input = bf.readLine();
        for(int i=0 ; i<input.length()-1 ; i++) {
            if(isPalindrome(input.substring(i))) {
                result += (input.length() - i) + i * 2;
                break;
            }
        }
        if(result == 0) {
            result += input.length() * 2 - 1;
        }

        System.out.println(result);

        bf.close();
        System.exit(0);
    }

    private static boolean isPalindrome(String word) {
        StringBuilder sb = new StringBuilder(word).reverse();
        return word.contentEquals(sb);
    }
}