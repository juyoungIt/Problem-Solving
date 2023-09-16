// BOJ - 1598
// Problem Sheet - https://www.acmicpc.net/problem/1598

import java.util .*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int rowDist = Math.abs(getRowIndex(a) - getRowIndex(b));
        int colDist = Math.abs(getColIndex(a) - getColIndex(b));
        System.out.println(rowDist + colDist);

        bf.close();
        System.exit(0);
    }

    private static int getRowIndex(int n) {
        int rowIndex = n / 4;
        return (n % 4 == 0) ? rowIndex : rowIndex + 1;
    }

    private static int getColIndex(int n) {
        int colIndex = n % 4 - 1;
        return (colIndex >= 0) ? colIndex : 3;
    }
}