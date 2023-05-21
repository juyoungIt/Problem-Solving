// BOJ - 1919
// Problem Sheet - https://www.acmicpc.net/problem/1919

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int[] usageCountA = new int[26];
        int[] usageCountB = new int[26];
        int removeCount = 0;

        for(char letter : bf.readLine().toCharArray()) {
            usageCountA[letter - 'a']++;
        }
        for(char letter : bf.readLine().toCharArray()) {
            usageCountB[letter - 'a']++;
        }

        for(int i=0 ; i<26 ; i++) {
            if(usageCountA[i] != usageCountB[i]) {
                removeCount += Math.abs(usageCountA[i] - usageCountB[i]);
            }
        }

        System.out.println(removeCount);

        bf.close();
        System.exit(0);
    }
}