// BOJ - 2529
// Problem Sheet - https://www.acmicpc.net/problem/2529

import java.io.*;

public class Main {

    private static int k;
    private static char[] A;
    private static int[] numbers;
    private static boolean[] isUsed;
    private static String min = null, max = null;

    public static void main(String[] args) throws IOException {
        input();
        solve(0);
        System.out.printf("%s\n%s", max, min);
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        k = Integer.parseInt(br.readLine());
        A = new char[k];
        String[] row = br.readLine().split(" ");
        for (int i=0 ; i<k ; i++) {
            A[i] = row[i].charAt(0);
        }
        numbers = new int[k + 1];
        isUsed = new boolean[10];
        br.close();
    }

    private static void solve(int count) {
        if (count == k + 1) {
            String number = getNumberString();
            if (min == null) min = number;
            else if (min.compareTo(number) > 0) min = number;
            if (max == null) max = number;
            else if (max.compareTo(number) < 0) max = number;
            return;
        }
        for (int i=0 ; i<10 ; i++) {
            if (count == 0) {
                isUsed[i] = true;
                numbers[count] = i;
                solve(count + 1);
                isUsed[i] = false;
            } else if (!isUsed[i] && isValid(numbers[count - 1], i, A[count - 1])) {
                isUsed[i] = true;
                numbers[count] = i;
                solve(count + 1);
                isUsed[i] = false;
            }
        }
    }

    private static String getNumberString() {
        StringBuilder sb = new StringBuilder();
        for (int number : numbers) {
            sb.append(number);
        }
        return sb.toString();
    }

    private static boolean isValid(int a, int b, char s) {
        if (s == '<') {
            return a < b;
        }
        return a > b;
    }
}