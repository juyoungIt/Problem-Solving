// BOJ - 11068
// Problem Sheet - https://www.acmicpc.net/problem/11068

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        char[] baseFormat = new char[64];
        for(int i=0 ; i<64 ; i++) {
            if(i < 10) {
                baseFormat[i] = Integer.toString(i).charAt(0);
            } else if(i < 36) {
                baseFormat[i] = (char)('A' + i - 10);
            } else if(i == 62) {
                baseFormat[i] = '+';
            } else if(i == 63) {
                baseFormat[i] = '/';
            } else {
                baseFormat[i] = (char)('a' + i - 36);
            }
        }

        int numberOfTestCases = Integer.parseInt(bf.readLine());
        for(int i=0 ; i<numberOfTestCases ; i++) {
            int number = Integer.parseInt(bf.readLine());
            boolean isPalindrome = false;
            for(int j=2 ; j<=64 ; j++) {
                if(isPalindrome(convertToNBase(number, j, baseFormat))) {
                    isPalindrome = true;
                    break;
                }
            }
            sb.append(isPalindrome ? 1 : 0).append("\n");
        }

        System.out.println(sb);

        bf.close();
        System.exit(0);
    }

    private static String convertToNBase(int number, int base, char[] baseFormat) {
        StringBuilder sb = new StringBuilder();
        while(number/base > 0) {
            sb.insert(0, baseFormat[number%base]);
            number /= base;
        }
        sb.insert(0, baseFormat[number]);
        return sb.toString();
    }

    private static boolean isPalindrome(String str) {
        for(int i=0 ; i<str.length()/2 ; i++) {
            if(str.charAt(i) != str.charAt(str.length()-1-i)) {
                return false;
            }
        }
        return true;
    }
}