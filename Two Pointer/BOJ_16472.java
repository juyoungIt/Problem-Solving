// BOJ - 16472
// Problem Sheet - https://www.acmicpc.net/problem/16472

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int[] counts = new int[26];
        int N = Integer.parseInt(bf.readLine());
        String msg = bf.readLine();

        int uniqueCount = 0;
        int nextIndex = 0;
        int maxLength = 0;
        for(int i=0 ; i<msg.length() ; i++) {
            while(nextIndex < msg.length()) {
                if(counts[msg.charAt(nextIndex++) - 'a']++ == 0) {
                    uniqueCount++;
                }
                if(uniqueCount > N) {
                    if(--counts[msg.charAt(--nextIndex) - 'a'] == 0) {
                        uniqueCount--;
                    }
                    break;
                }
            }
            maxLength = Math.max(maxLength, nextIndex - i);
            if(--counts[msg.charAt(i) - 'a'] == 0) {
                uniqueCount--;
            }
        }

        System.out.println(maxLength);

        bf.close();
        System.exit(0);
    }
}