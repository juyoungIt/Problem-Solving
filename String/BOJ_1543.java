// BOJ - 1543
// Problem Sheet - https://www.acmicpc.net/problem/1543

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int matchCount = 0;

        String document = bf.readLine();
        String keyword = bf.readLine();
        for(int i=0 ; i<=document.length()-keyword.length() ; i++) {
            if(document.startsWith(keyword, i)) {
                matchCount++;
                i += keyword.length()-1;
            }
        }

        System.out.println(matchCount);

        bf.close();
        System.exit(0);
    }
}