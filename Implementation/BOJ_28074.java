// BOJ - 28074
// Problem Sheet - https://www.acmicpc.net/problem/28074

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean[] isUsed = new boolean[26];
        String input = br.readLine();
        br.close();
        for (int i=0 ; i<input.length() ; i++) {
            isUsed[input.charAt(i) - 'A'] = true;
        }
        System.out.println(
                isUsed['M' - 'A'] 
                    && isUsed['O' - 'A']
                    && isUsed['B' - 'A']
                    && isUsed['I' - 'A']
                    && isUsed['S' - 'A']
                ? "YES"
                : "NO"
        );
    }
}
