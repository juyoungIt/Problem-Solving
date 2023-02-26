// BOJ - 2605
// Problem Sheet - https://www.acmicpc.net/problem/2605

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int studentCount = Integer.parseInt(bf.readLine());
        StringTokenizer st = new StringTokenizer(bf.readLine());
        List<Integer> finalSequence = new LinkedList<>();
        for(int i=1 ; i<=studentCount ; i++) {
            int cardNumber = Integer.parseInt(st.nextToken());
            if(i == 1) {
                finalSequence.add(i);
            } else if(i == 2) {
                if(cardNumber == 0) {
                    finalSequence.add(i);
                } else {
                    finalSequence.add(0, i);
                }
            } else {
                finalSequence.add(i-1-cardNumber, i);
            }
        }

        for(int studentNumber : finalSequence) {
            sb.append(studentNumber).append(" ");
        }
        System.out.println(sb);

        bf.close();
        System.exit(0);
    }
}