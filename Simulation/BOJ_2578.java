// BOJ - 2578
// Problem Sheet - https://www.acmicpc.net/problem/2578

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int[] indexs = new int[25];
        boolean[] colored = new boolean[25];
        int number;
        for(int i=0 ; i<5 ; i++) {
            st = new StringTokenizer(bf.readLine());
            for(int j=0 ; j<5 ; j++) {
                number = Integer.parseInt(st.nextToken());
                indexs[number-1] = 5 * i + j;
            }
        }

        int turns = 0;
        boolean isFinished = false;
        for(int i=0 ; i<5 ; i++) {
            if(isFinished) {
                break;
            }
            st = new StringTokenizer(bf.readLine());
            for(int j=0 ; j<5 ; j++) {
                turns++;
                number = Integer.parseInt(st.nextToken());
                colored[indexs[number-1]] = true;
                if(checkBingo(colored) >= 3) {
                    isFinished = true;
                    break;
                }
            }
        }

        System.out.println(turns);

        bf.close();
        System.exit(0);
    }

    private static int checkBingo(boolean[] colored) {
        int numberOfBingo = 0;
        numberOfBingo += checkRowBingo(colored);
        numberOfBingo += checkColumnBingo(colored);
        numberOfBingo += checkDiagonalBingo(colored);
        return numberOfBingo;
    }

    private static int checkRowBingo(boolean[] colored) {
        int numberOfBingo = 0;
        for(int i=0 ; i<=20 ; i+=5) {
            int coloredCount = 0;
            for(int j=i ; j<i+5 ; j++) {
                if(colored[j]) {
                    coloredCount++;
                }
            }
            if(coloredCount == 5) {
                numberOfBingo++;
            }
        }
        return numberOfBingo;
    }

    private static int checkColumnBingo(boolean[] colored) {
        int numberOfBingo = 0;
        for(int i=0 ; i<5 ; i++) {
            int coloredCount = 0;
            for(int j=i ; j<=i+20 ; j+=5) {
                if(colored[j]) {
                    coloredCount++;
                }
            }
            if(coloredCount == 5) {
                numberOfBingo++;
            }
        }
        return numberOfBingo;
    }

    private static int checkDiagonalBingo(boolean[] colored) {
        int numberOfBingo = 0;
        int coloredCount = 0;
        for(int i=0 ; i<25 ; i+=6) {
            if(colored[i]) {
                coloredCount++;
            }
        }
        if(coloredCount == 5) {
            numberOfBingo++;
        }

        coloredCount = 0;
        for(int i=4 ; i<=20 ; i+=4) {
            if(colored[i]) {
                coloredCount++;
            }
        }
        if(coloredCount == 5) {
            numberOfBingo++;
        }
        return numberOfBingo;
    }
}