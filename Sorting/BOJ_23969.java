// BOJ - 23969
// Problem Sheet - https://www.acmicpc.net/problem/23969

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int sizeOfArray = Integer.parseInt(st.nextToken());
        int swapCount = Integer.parseInt(st.nextToken());

        int[] numbers = new int[sizeOfArray];
        st = new StringTokenizer(bf.readLine());
        for(int i=0 ; i<sizeOfArray ; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        boolean statusIsExist = false;
        for(int i=0 ; i<sizeOfArray-1 ; i++) {
            for(int j=0 ; j<sizeOfArray-(i+1) ; j++) {
                if(numbers[j] > numbers[j+1]) {
                    int tmp = numbers[j];
                    numbers[j] = numbers[j+1];
                    numbers[j+1] = tmp;
                    if(--swapCount == 0) {
                        statusIsExist = true;
                        for(int number : numbers) {
                            sb.append(number).append(" ");
                        }
                        break;
                    }
                }
            }
        }

        System.out.println((statusIsExist) ? sb.toString() : -1);

        bf.close();
        System.exit(0);
    }
}