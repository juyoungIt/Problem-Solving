// BOJ - 7785
// Problem Sheet - https://www.acmicpc.net/problem/7785

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine()); // 출입 기록의 수
        Set<String> members = new HashSet<>();

        StringTokenizer st;
        for(int i=0 ; i<n ; i++) {
            st = new StringTokenizer(bf.readLine());
            String name = st.nextToken(); // 직원의 이름
            String status = st.nextToken(); // 출퇴근 상태
            if(status.equals("enter")) members.add(name);
            else members.remove(name);
        }

        List<String> attendee = new ArrayList<>(members);
        attendee.sort(Collections.reverseOrder()); // 사전 역순으로 정렬함

        // 결과를 출력함
        for(String name : attendee)
            System.out.println(name);

        bf.close();
        System.exit(0);
    }
}