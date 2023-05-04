// BOJ - 2902
// Problem Sheet - https://www.acmicpc.net/problem/2902

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] names = bf.readLine().split("-");
        for(String name : names) {
            sb.append(name.charAt(0));
        }

        System.out.println(sb);

        bf.close();
        System.exit(0);
    }
}