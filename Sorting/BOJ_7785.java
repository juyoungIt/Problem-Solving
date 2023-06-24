// BOJ - 7785
// Problem Sheet - https://www.acmicpc.net/problem/7785

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int numberOfLogs = Integer.parseInt(bf.readLine());
        Set<String> entered = new TreeSet<>();
        for(int i=0 ; i<numberOfLogs ; i++) {
            st = new StringTokenizer(bf.readLine());
            String name = st.nextToken();
            if(st.nextToken().equals("enter")) {
                entered.add(name);
            } else {
                entered.remove(name);
            }
        }

        String[] members = entered.toArray(new String[entered.size()]);
        for(int i=members.length-1 ; i>=0 ; i--) {
            sb.append(members[i]).append("\n");
        }

        System.out.println(sb);

        bf.close();
        System.exit(0);
    }
}