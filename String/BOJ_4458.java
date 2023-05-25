// BOJ - 4458
// Problem Sheet - https://www.acmicpc.net/problem/4458

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int numberOfLines = Integer.parseInt(bf.readLine());
        for(int i=0 ; i<numberOfLines ; i++) {
            String[] words = bf.readLine().split(" ");
            for(int j=0 ; j< words.length ; j++) {
                if(j == 0) {
                    sb.append(Character.toUpperCase(words[j].charAt(0)))
                            .append(words[j].substring(1))
                            .append(" ");
                } else {
                    sb.append(words[j]).append(" ");
                }
            }
            sb.append("\n");
        }

        System.out.println(sb);

        bf.close();
        System.exit(0);
    }
}