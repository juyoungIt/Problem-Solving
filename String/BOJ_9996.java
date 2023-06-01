// BOJ - 9996
// Problem Sheet - https://www.acmicpc.net/problem/9996

import java.io.*;
import java.util.Arrays;

public class Main {

    enum Message {
        DA, NE
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int numberOfFiles = Integer.parseInt(bf.readLine());
        String[] pattern = bf.readLine().split("\\*");
        String fileName;
        for(int i=0 ; i<numberOfFiles ; i++) {
            fileName = bf.readLine();
            if(fileName.startsWith(pattern[0])
                    && fileName.endsWith(pattern[1])
                    && pattern[0].length()-1 <= fileName.length()-pattern[1].length()) {
                sb.append(Message.DA).append("\n");
            } else {
                sb.append(Message.NE).append("\n");
            }
        }

        System.out.println(sb);

        bf.close();
        System.exit(0);
    }
}