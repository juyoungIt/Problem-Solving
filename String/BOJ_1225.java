// BOJ - 1225
// Problem Sheet - https://www.acmicpc.net/problem/1225

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        long result = 0;

        char[] numberA = st.nextToken().toCharArray();
        char[] numberB = st.nextToken().toCharArray();
        for(char digitA : numberA) {
            for(char digitB : numberB) {
                result += (long)Character.getNumericValue(digitA) * Character.getNumericValue(digitB);
            }
        }

        System.out.println(result);

        bf.close();
        System.exit(0);
    }
}