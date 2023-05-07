// BOJ - 11655
// Problem Sheet - https://www.acmicpc.net/problem/11655

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String message = bf.readLine();
        for (char letter : message.toCharArray()) {
            if (Character.isAlphabetic(letter)) {
                if(Character.isLowerCase(letter)) {
                    sb.append(encrypt(letter, 'a'));
                } else {
                    sb.append(encrypt(letter, 'A'));
                }
            } else {
                sb.append(letter);
            }
        }

        System.out.println(sb);

        bf.close();
        System.exit(0);
    }

    private static char encrypt(char lowercase, char base) {
        return (char) ((((lowercase - base) + 13) % 26) + base);
    }
}