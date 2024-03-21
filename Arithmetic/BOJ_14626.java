// BOJ - 14626
// Problem Sheet - https://www.acmicpc.net/problem/14626

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] isbnDigits = br.readLine().split("");
        int targetIndex = 0;
        int checkSum = 0;
        for (int i=0 ; i<isbnDigits.length ; i++) {
            if (isbnDigits[i].equals("*")) {
                targetIndex = i;
                continue;
            }
            checkSum += getMultiplyDegree(i) * Integer.parseInt(isbnDigits[i]);
        }

        for (int i=0 ; i<=9 ; i++) {
            if ((checkSum + getMultiplyDegree(targetIndex) * i) % 10 == 0) {
                System.out.println(i);
                break;
            }
        }

        br.close();
        System.exit(0);
    }

    private static int getMultiplyDegree(int index) {
        return index % 2 == 0 ? 1 : 3;
    }
}