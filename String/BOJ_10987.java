// BOJ - 10987
// Problem Sheet - https://www.acmicpc.net/problem/10987

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        char[] letters = bf.readLine().toCharArray();
        int numberOfVowels = 0;

        for(char letter : letters) {
            if(isVowel(letter)) {
                numberOfVowels++;
            }
        }

        System.out.println(numberOfVowels);

        bf.close();
        System.exit(0);
    }

    private static boolean isVowel(char letter) {
        return letter == 'a'
                || letter == 'e'
                || letter == 'i'
                || letter == 'o'
                || letter == 'u';
    }
}