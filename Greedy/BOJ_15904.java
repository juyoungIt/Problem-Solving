// BOJ - 15904
// Problem Sheet - https://www.acmicpc.net/problem/15904

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String input = bf.readLine();
        String success = "I love UCPC";
        String failed = "I hate UCPC";
        char[] ucpc = {'U', 'C', 'P', 'C'};
        int curIdx = 0;

        for(int i=0 ; i<input.length() ; i++) {
            if(curIdx >= 4)
                break;
            if(input.charAt(i) == ucpc[curIdx])
                curIdx++;
        }

        if(curIdx >= 4)
            System.out.println(success);
        else
            System.out.println(failed);

        bf.close();
        System.exit(0);
    }
}