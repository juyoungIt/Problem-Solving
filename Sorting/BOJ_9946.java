// BOJ - 9946
// Problem Sheet - https://www.acmicpc.net/problem/9946

import java.util.*;
import java.io.*;

public class Main {

    private static final String OUTPUT_FORMAT = "Case %d: %s\n";
    private static final String END_INPUT = "END";
    private static final String IS_SAME = "same";
    private static final String IS_NOT_SAME = "different";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int index = 0;
        while (true) {
            index++;
            String originWord = br.readLine();
            String recombinedWord = br.readLine();
            if (originWord.equals(END_INPUT) && recombinedWord.equals(END_INPUT)) break;
            boolean isSameArray = isSameArray(originWord.toCharArray(), recombinedWord.toCharArray());
            sb.append(String.format(OUTPUT_FORMAT, index, isSameArray ? IS_SAME : IS_NOT_SAME));
        }

        System.out.println(sb);

        br.close();
        System.exit(0);
    }

    private static boolean isSameArray(char[] arrA, char[] arrB) {
        if (arrA.length != arrB.length) {
            return false;
        } else {
            Arrays.sort(arrA);
            Arrays.sort(arrB);
            boolean isSameArray = true;
            for (int i=0 ; i<arrA.length ; i++) {
                if (arrA[i] != arrB[i]) {
                    isSameArray = false;
                    break;
                }
            }
            return isSameArray;
        }
    }
}