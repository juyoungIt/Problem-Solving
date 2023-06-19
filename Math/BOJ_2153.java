// BOJ - 2153
// Problem Sheet - https://www.acmicpc.net/problem/2153

import java.util.*;
import java.io.*;

public class Main {

    private static final String IS_PRIME_WORD = "It is a prime word.";
    private static final String IS_NOT_PRIME_WORD = "It is not a prime word.";

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        char[] word = bf.readLine().toCharArray();
        System.out.println(
                isPrimeNumber(getWordSum(word))
                        ? IS_PRIME_WORD
                        : IS_NOT_PRIME_WORD);

        bf.close();
        System.exit(0);
    }

    private static int getWordSum(char[] word) {
        int result = 0;
        for(char letter : word) {
            if(Character.isLowerCase(letter)) {
                result += letter - 'a' + 1;
            } else {
                result += letter - 38;
            }
        }
        return result;
    }

    private static boolean isPrimeNumber(int number) {
        for(int i=1 ; i<=number ; i++) {
            if(number%i == 0 && i != 1 && i != number) {
                return false;
            }
        }
        return true;
    }
}