// BOJ - 1264
// Problem Sheet - https://www.acmicpc.net/problem/1264

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String input;
        while(true) {
            int vowelCount = 0;
            input = bf.readLine();
            if(input.equals("#")) {
                break;
            }
            for(char letter : input.toCharArray()) {
                if(isVowel(Character.toLowerCase(letter))) {
                    vowelCount++;
                }
            }
            sb.append(vowelCount).append("\n");
        }

        System.out.println(sb);

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