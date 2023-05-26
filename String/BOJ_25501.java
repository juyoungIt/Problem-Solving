// BOJ - 25501
// Problem Sheet - https://www.acmicpc.net/problem/25501

import java.io.*;

public class Main {

    private static int callCount = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int numberOfTestCases = Integer.parseInt(bf.readLine());
        for(int i=0 ; i<numberOfTestCases ; i++) {
            sb.append(isPalindrome(bf.readLine()))
                    .append(" ")
                    .append(callCount)
                    .append("\n");
            callCount = 0;
        }

        System.out.println(sb);

        bf.close();
        System.exit(0);
    }

    private static int isPalindrome(String word) {
        return recursion(word, 0, word.length()-1);
    }

    private static int recursion(String word, int leftIndex, int rightIndex) {
        callCount++;
        if(leftIndex >= rightIndex) {
            return 1;
        } else if(word.charAt(leftIndex) != word.charAt(rightIndex)) {
            return 0;
        } else {
            return recursion(word, leftIndex+1, rightIndex-1);
        }
    }
}