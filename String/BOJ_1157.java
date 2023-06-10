// BOJ - 1157
// Problem Sheet - https://www.acmicpc.net/problem/1157

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int[] counts = new int[26];
        char[] word = bf.readLine().toLowerCase().toCharArray();
        for(char letter : word) {
            counts[letter - 'a']++;
        }

        int maxCountIndex = 0;
        boolean isMultiple = false;
        for(int i=1 ; i<26 ; i++) {
            if(counts[i] > counts[maxCountIndex]) {
                maxCountIndex = i;
                isMultiple = false;
            } else if(counts[i] == counts[maxCountIndex]) {
                isMultiple = true;
            }
        }

        System.out.println(isMultiple ? '?' : (char)('A' + maxCountIndex));

        bf.close();
        System.exit(0);
    }
}