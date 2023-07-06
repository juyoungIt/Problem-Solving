// BOJ - 17609
// Problem Sheet - https://www.acmicpc.net/problem/17609

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int numberOfTestCases = Integer.parseInt(bf.readLine());
        for(int i=0 ; i<numberOfTestCases ; i++) {
            String word = bf.readLine();
            int start = 0;
            int end = word.length()-1;
            int result = 0;
            while(start <= end) {
                if(word.charAt(start) != word.charAt(end)) {
                    if(isPalindrome(word, start+1, end) || isPalindrome(word, start, end-1)) {
                        result = 1;
                    } else {
                        result = 2;
                    }
                    break;
                }
                start++;
                end--;
            }
            sb.append(result).append("\n");
        }

        System.out.println(sb);

        bf.close();
        System.exit(0);
    }

    private static boolean isPalindrome(String word, int start, int end) {
        while(start <= end) {
            if(word.charAt(start) != word.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}