// BOJ - 11809
// Problem Sheet - https://www.acmicpc.net/problem/11809

import java.util.*;
import java.io.*;

public class Main {

    static final String YODA = "YODA";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String numA = br.readLine();
        String numB = br.readLine();
        char[] arrA = new char[numA.length()];
        for (int i=0 ; i<numA.length() ; i++) {
            arrA[numA.length() - 1 - i] = numA.charAt(i);
        }
        char[] arrB = new char[numB.length()];
        for (int i=0 ; i<numB.length() ; i++) {
            arrB[numB.length() - 1 - i] = numB.charAt(i);
        }

        int index = 0;
        int removeCountA = 0;
        int removeCountB = 0;
        while (index < Math.min(arrA.length, arrB.length)) {
            if (arrA[index] < arrB[index]) {
                arrA[index] = '-';
                removeCountA++;
            } else if (arrA[index] > arrB[index]) {
                arrB[index] = '-';
                removeCountB++;
            }
            index++;
        }

        if (numA.length() == removeCountA) {
            sb.append(YODA).append("\n");
        } else {
            StringBuilder buffer = new StringBuilder();
            for (int i=arrA.length-1 ; i>=0 ; i--) {
                if (arrA[i] == '-') continue;
                buffer.append(arrA[i]);
            }
            sb.append(Integer.parseInt(buffer.toString())).append("\n");
        }

        if (numB.length() == removeCountB) {
            sb.append(YODA).append("\n");
        } else {
            StringBuilder buffer = new StringBuilder();
            for (int i=arrB.length-1 ; i>=0 ; i--) {
                if (arrB[i] == '-') continue;
                buffer.append(arrB[i]);
            }
            sb.append(Integer.parseInt(buffer.toString())).append("\n");
        }

        System.out.println(sb);
        br.close();
    }
}