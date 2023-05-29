// BOJ - 18406
// Problem Sheet - https://www.acmicpc.net/problem/18406

import java.io.*;

public class Main {

    private enum Message {
        LUCKY, READY
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String number = bf.readLine();

        int left = 0;
        int right = 0;
        for(int i=0 ; i<number.length()/2 ; i++) {
            left += Character.getNumericValue(number.charAt(i));
            right += Character.getNumericValue(number.charAt(number.length()/2 + i));
        }

        System.out.println((left == right) ? Message.LUCKY : Message.READY);

        bf.close();
        System.exit(0);
    }
}