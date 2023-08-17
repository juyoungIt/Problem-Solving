// BOJ - 17252
// Problem Sheet - https://www.acmicpc.net/problem/17252

import java.io.*;

public class Main {

    enum Message {
        YES, NO
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());
        if(N == 0) {
            System.out.println(Message.NO);
            System.exit(0);
        }

        String base3N = Integer.toString(N, 3);
        boolean isSamNumber = true;
        for(int i=0 ; i<base3N.length() ; i++) {
            if(base3N.charAt(i) != '0' && base3N.charAt(i) != '1') {
                isSamNumber = false;
                break;
            }
        }

        System.out.println(isSamNumber ? Message.YES : Message.NO);

        bf.close();
        System.exit(0);
    }
}