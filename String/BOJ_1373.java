// BOJ - 1373
// Problem Sheet - https://www.acmicpc.net/problem/1373

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String octalNumber;

        String binaryNumber = bf.readLine();
        int tmpSum = 0;
        for(int i=binaryNumber.length()-1 ; i>=0 ; i--) {
            if(binaryNumber.charAt(i) == '1') {
                tmpSum += (int)Math.pow(2, (binaryNumber.length()-1-i)%3);
            }
            if((binaryNumber.length()-1-i)%3 == 2) {
                sb.append(tmpSum);
                tmpSum = 0;
            }
        }
        if(tmpSum > 0) {
            sb.append(tmpSum);
        }

        octalNumber = sb.reverse().toString();
        if(octalNumber.isEmpty() || octalNumber.charAt(0) == '0') {
            System.out.println(0);
        } else {
            System.out.println(octalNumber);
        }

        bf.close();
        System.exit(0);
    }
}