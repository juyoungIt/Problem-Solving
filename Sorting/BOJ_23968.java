// BOJ - 23968
// Problem Sheet - https://www.acmicpc.net/problem/23968

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int sizeOfArray = Integer.parseInt(st.nextToken());
        int swapCount = Integer.parseInt(st.nextToken());

        int[] numbers = new int[sizeOfArray];
        st = new StringTokenizer(bf.readLine());
        for(int i=0 ; i<sizeOfArray ; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        int numberA = -1;
        int numberB = -1;
        for(int i=0 ; i<sizeOfArray-1 ; i++) {
            for(int j=0 ; j<sizeOfArray-(i+1) ; j++) {
                if(numbers[j] > numbers[j+1]) {
                    int tmp = numbers[j];
                    numbers[j] = numbers[j+1];
                    numbers[j+1] = tmp;
                    if(--swapCount == 0) {
                        numberA = Math.min(numbers[j], numbers[j+1]);
                        numberB = Math.max(numbers[j], numbers[j+1]);
                        break;
                    }
                }
            }
        }

        if(numberA == -1 && numberB == -1) {
            System.out.println(-1);
        } else {
            System.out.println(numberA + " " + numberB);
        }

        bf.close();
        System.exit(0);
    }
}