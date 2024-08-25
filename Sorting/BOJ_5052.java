// BOJ - 5052
// Problem Sheet - https://www.acmicpc.net/problem/5052

import java.util.*;
import java.io.*;

public class Main {

    enum Message {
        NO, YES
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        for (int i=0 ; i<t ; i++) {
            int n = Integer.parseInt(br.readLine());
            String[] phoneNumber = new String[n];
            for (int j=0 ; j<n ; j++) {
                phoneNumber[j] = br.readLine();
            }
            Arrays.sort(phoneNumber);

            boolean isValid = true;
            for (int j=0 ; j<n-1 ; j++) {
                if (phoneNumber[j+1].startsWith(phoneNumber[j])) {
                    isValid = false;
                    break;
                }
            }
            sb.append(isValid ? Message.YES : Message.NO).append("\n");
        }

        System.out.println(sb);

        br.close();
        System.exit(0);
    }
}