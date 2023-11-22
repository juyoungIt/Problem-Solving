// BOJ - 21567
// Problem Sheet - https://www.acmicpc.net/problem/21567

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int[] counts = new int[10];
        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int c = Integer.parseInt(br.readLine());
        String mult = Long.toString((long)a * (long)b * (long)c);

        for(int i=0 ; i<mult.length() ; i++) {
            counts[Integer.parseInt(mult.charAt(i)+"")]++;
        }
        for(int i=0 ; i<10 ; i++) {
            sb.append(counts[i]).append("\n");
        }
        System.out.println(sb);


        br.close();
        System.exit(0);
    }
}