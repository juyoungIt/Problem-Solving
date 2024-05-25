// BOJ - 17269
// Problem Sheet - https://www.acmicpc.net/problem/17269

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        String a = st.nextToken();
        String b = st.nextToken();

        int[] valueArr = getValueArr(getMergedNameStr(n, m, a, b));
        while (valueArr.length > 2) {
            valueArr = getValueArr(valueArr);
        }

        int result = valueArr[0] * 10 + valueArr[1];
        System.out.printf("%d%%\n", result);

        br.close();
        System.exit(0);
    }

    private static char[] getMergedNameStr(int n, int m, String a, String b) {
        StringBuilder sb = new StringBuilder();
        char[] aTokens = a.toCharArray();
        char[] bTokens = b.toCharArray();
        for (int i=0 ; i<Math.min(n, m) ; i++) {
            sb.append(aTokens[i]).append(bTokens[i]);
        }
        if (n > m) {
            for (int i=m ; i<n ; i++) {
                sb.append(aTokens[i]);
            }
        } else if (n < m) {
            for (int i=n ; i<m ; i++) {
                sb.append(bTokens[i]);
            }
        }
        return sb.toString().toCharArray();
    }

    private static int[] getValueArr(char[] arr) {
        int[] valueArr = new int[arr.length];
        for (int i=0 ; i<arr.length ; i++) {
            valueArr[i] = getStrokesCount(arr[i]);
        }
        return valueArr;
    }

    private static int[] getValueArr(int[] arr) {
        int[] valueArr = new int[arr.length-1];
        for (int i=0 ; i<arr.length-1 ; i++) {
            valueArr[i] = (arr[i] + arr[i+1]) % 10;
        }
        return valueArr;
    }

    private static int getStrokesCount(char alpha) {
        int strokesCount = 0;
        switch (alpha) {
            case 'A':
            case 'F':
            case 'H':
            case 'K':
            case 'M':
                strokesCount = 3;
                break;
            case 'B':
            case 'D':
            case 'N':
            case 'P':
            case 'Q':
            case 'R':
            case 'T':
            case 'X':
            case 'Y':
                strokesCount = 2;
                break;
            case 'C':
            case 'G':
            case 'I':
            case 'J':
            case 'L':
            case 'O':
            case 'S':
            case 'U':
            case 'V':
            case 'W':
            case 'Z':
                strokesCount = 1;
                break;
            case 'E':
                strokesCount = 4;
                break;
        }
        return strokesCount;
    }
}