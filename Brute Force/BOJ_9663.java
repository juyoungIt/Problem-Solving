// BOJ - 9663
// Problem Sheet - https://www.acmicpc.net/problem/9663

import java.io.*;

public class Main {

    private static int N;
    private static int count = 0;
    private static int[] rows;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        rows = new int[N];

        putQueen(0);
        System.out.println(count);

        bf.close();
        System.exit(0);
    }

    private static void putQueen(int rowIndex) {
        if(rowIndex == N) {
            count++;
            return;
        }
        for(int i=0 ; i<N ; i++) {
            rows[rowIndex] = i;
            if(isAvailable(rowIndex)) {
                putQueen(rowIndex + 1);
            }
        }
    }

    private static boolean isAvailable(int rowIndex) {
        for(int i=0 ; i<rowIndex ; i++) {
            if(rows[rowIndex] == rows[i] || rowIndex - i == Math.abs(rows[rowIndex] - rows[i])) {
                return false;
            }
        }
        return true;
    }
}