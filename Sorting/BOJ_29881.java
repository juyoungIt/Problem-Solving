// BOJ - 29881
// Problem Sheet - https://www.acmicpc.net/problem/29881

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        Map<String, String> nameMapper = new HashMap<>();
        for (int i=0 ; i<N ; i++) {
            String[] row = br.readLine().split(" ");
            String firstName = row[0];
            String lastName = row[1];
            nameMapper.put(firstName, lastName);
        }
        for (int i=0 ; i<N ; i++) {
            String[] row = br.readLine().split(" ");
            String firstName = row[0];
            String accountName = row[1];
            nameMapper.put(firstName, nameMapper.get(firstName) + " " + accountName);
        }

        for (String name : nameMapper.values()) {
            sb.append(name).append("\n");
        }
        System.out.println(sb);
        br.close();
    }
}