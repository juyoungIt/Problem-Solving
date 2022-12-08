// BOJ - 25192
// Problem Sheet - https://www.acmicpc.net/problem/25192

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine()); // 기록된 채팅방 로그의 수
        Set<String> users = new HashSet<>(); // 이모티콘을 사용한 사용자의 set
        int answer = 0;

        for(int i=0 ; i<n ; i++) {
            String log = bf.readLine(); // n번째 로그 메시지
            if(log.equals("ENTER")) {
                answer += users.size();
                users.clear();
                continue;
            }
            users.add(log);
        }
        if(users.size() > 0)
            answer += users.size();

        System.out.println(answer);

        bf.close();
        System.exit(0);
    }
}