// BOJ - 10448
// Problem Sheet - https://www.acmicpc.net/problem/10448

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int[] triangularNumber = new int[45];
        for(int i=1 ; i<=44 ; i++) {
            triangularNumber[i] = i*(i+1)/2;
        }

        int numberOfTestCases = Integer.parseInt(bf.readLine());
        for(int i=0 ; i<numberOfTestCases ; i++) {
            if(isTriangularNumberSum(triangularNumber, Integer.parseInt(bf.readLine()))) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }

        bf.close();
        System.exit(0);
    }

    private static boolean isTriangularNumberSum(int[] arr, int targetNumber) {
        for(int i=1 ; i<arr.length ; i++) {
            for(int j=1 ; j<arr.length ; j++) {
                for(int k=1 ; k<arr.length ; k++) {
                    if(arr[i] + arr[j] + arr[k] == targetNumber) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}