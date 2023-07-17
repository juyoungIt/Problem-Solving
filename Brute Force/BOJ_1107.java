// BOJ - 1107
// Problem Sheet - https://www.acmicpc.net/problem/1107

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());
        int M = Integer.parseInt(bf.readLine());
        boolean[] brokens = new boolean[10];
        if(M > 0) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for(int i=0 ; i<M ; i++) {
                brokens[Integer.parseInt(st.nextToken())] = true;
            }
        }

        int[] clickCounts = new int[3];
        clickCounts[0] = (N >= 100) ? N - 100 : 100 - N;
        int lowerBound = getLowerBound(brokens, N);
        int upperBound = getUpperBound(brokens, N);
        clickCounts[1] = Integer.toString(lowerBound).length() + (N - lowerBound);
        clickCounts[2] = Integer.toString(upperBound).length() + (upperBound - N);

        Arrays.sort(clickCounts);
        System.out.println(clickCounts[0]);

        bf.close();
        System.exit(0);
    }

    private static boolean isValidNumber(boolean[] brokens, int number) {
        while(number / 10 > 0) {
            if(brokens[number % 10]) {
                return false;
            }
            number /= 10;
        }
        return !brokens[number];
    }

    private static int getLowerBound(boolean[] brokens, int N) {
        boolean isValid = false;
        int currentNumber = N;
        while(currentNumber >= 0) {
            isValid = isValidNumber(brokens, currentNumber);
            if(isValid) {
                break;
            }
            currentNumber--;
        }
        return isValid ? currentNumber : -500_000;
    }

    private static int getUpperBound(boolean[] brokens, int N) {
        boolean isValid = false;
        int currentNumber = N;
        while(currentNumber < 1_000_000) {
            isValid = isValidNumber(brokens, currentNumber);
            if(isValid) {
                break;
            }
            currentNumber++;
        }
        return isValid ? currentNumber : 1_000_000;
    }
}