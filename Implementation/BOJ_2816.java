// BOJ - 2816
// Problem Sheet - https://www.acmicpc.net/problem/2816

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        List<String> channels = new LinkedList<>();
        for (int i=0 ; i<n ; i++) {
            String channel = br.readLine();
            channels.add(channel);
        }

        // 1. KBS1을 찾아서 0의 위치로 올림
        for (int i=0 ; i<n ; i++) {
            if (channels.get(i).equals("KBS1")) {
                for (int j=0 ; j<i ; j++) {
                    sb.append(1);
                }
                for (int j=0 ; j<i ; j++) {
                    sb.append(4);
                }
                channels.remove("KBS1");
                channels.add(0, "KBS1");
            }
        }

        // 2. KBS2를 찾아서 1의 위치로 올림
        for (int i=0 ; i<n ; i++) {
            if (channels.get(i).equals("KBS2")) {
                for (int j=0 ; j<i ; j++) {
                    sb.append(1);
                }
                for (int j=0 ; j<i-1 ; j++) {
                    sb.append(4);
                }
                channels.remove("KBS2");
                channels.add(1, "KBS2");
            }
        }
        System.out.println(sb);
        br.close();
    }
}
