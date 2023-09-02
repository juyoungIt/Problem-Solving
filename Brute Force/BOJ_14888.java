// BOJ - 14888
// Problem Sheet - https://www.acmicpc.net/problem/14888

import java.util.*;
import java.io.*;

public class Main {

    private static int N;
    private static int max = Integer.MIN_VALUE;
    private static int min = Integer.MAX_VALUE;
    private static int[] operands;
    private static int[] operators;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());

        operands = new int[N];
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for(int i=0 ; i<N ; i++) {
            operands[i] = Integer.parseInt(st.nextToken());
        }

        operators = new int[4];
        st = new StringTokenizer(bf.readLine());
        for(int i=0 ; i<4 ; i++) {
            operators[i] = Integer.parseInt(st.nextToken());
        }

        calculate(operands[0], 0);

        System.out.println(max);
        System.out.println(min);

        bf.close();
        System.exit(0);
    }

    private static void calculate(int acc, int operatorCount) {
        if(operatorCount == N-1) {
            max = Math.max(max, acc);
            min = Math.min(min, acc);
        } else {
            for(int i=0 ; i<4 ; i++) {
                if (operators[i] == 0) {
                    continue;
                }
                operators[i]--;
                if(i == 0) {
                    acc += operands[operatorCount+1];
                } else if(i == 1) {
                    acc -= operands[operatorCount+1];
                } else if(i == 2) {
                    acc *= operands[operatorCount+1];
                } else {
                    acc /= operands[operatorCount+1];
                }
                calculate(acc, operatorCount+1);
                operators[i]++;
                if(i == 0) {
                    acc -= operands[operatorCount+1];
                } else if(i == 1) {
                    acc += operands[operatorCount+1];
                } else if(i == 2) {
                    acc /= operands[operatorCount+1];
                } else {
                    acc *= operands[operatorCount+1];
                }
            }
        }
    }
}