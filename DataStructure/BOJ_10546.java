// BOJ - 10546
// Problem Sheet - https://www.acmicpc.net/problem/10546

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer> memberMapper = new HashMap<>();

        int n = Integer.parseInt(bf.readLine());
        for(int i=0 ; i<n ; i++) {
            String name = bf.readLine();
            if(memberMapper.containsKey(name)) {
                memberMapper.put(name, memberMapper.get(name) + 1);
            } else {
                memberMapper.put(name, 1);
            }
        }

        for(int i=0 ; i<n-1 ; i++) {
            String name = bf.readLine();
            if(memberMapper.containsKey(name)) {
                memberMapper.put(name, memberMapper.get(name)-1);
                if(memberMapper.get(name) == 0) {
                    memberMapper.remove(name);
                }
            }
        }

        for(Map.Entry<String, Integer> entry : memberMapper.entrySet()) {
            System.out.println(entry.getKey());
        }

        bf.close();
        System.exit(0);
    }
}