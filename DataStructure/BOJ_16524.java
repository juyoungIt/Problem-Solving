// BOJ - 16524
// Problem Sheet - https://www.acmicpc.net/problem/16524

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Set<String> users = new HashSet<>();
        int n = Integer.parseInt(br.readLine());
        for (int i=0 ; i<n ; i++) {
            String address = br.readLine();
            String username = address.split("@")[0]
                    .split("\\+")[0]
                    .replace(".", "");
            String domain = address.split("@")[1];
            String processedAddress = username + "@" + domain;
            users.add(processedAddress);
        }

        System.out.println(users.size());

        br.close();
        System.exit(0);
    }
}