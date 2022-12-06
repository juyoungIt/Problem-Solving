// BOJ - 16165
// Problem Sheet - https://www.acmicpc.net/problem/16165

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        Map<String, List<String>> membersMapper = new HashMap<>(); // 각 그룹별 멤버의 정보를 유지하는 Map
        Map<String, String> groupMapper = new HashMap<>(); // 각 멤버별 그룹의 정보를 유지하는 Map

        int n = Integer.parseInt(st.nextToken()); // 입력받을 걸그룹의 수
        int m = Integer.parseInt(st.nextToken()); // 맞혀야할 문제의 수

        // 걸그룹의 정보를 입력받음
        for(int i=0 ; i<n ; i++) {
            String groupName = bf.readLine();
            int groupMemberCnt = Integer.parseInt(bf.readLine());
            membersMapper.put(groupName, new ArrayList<>());
            // 멤버 정보를 추가함
            for(int j=0 ; j<groupMemberCnt ; j++) {
                String memberName = bf.readLine();
                membersMapper.get(groupName).add(memberName);
                groupMapper.put(memberName, groupName);
            }
            Collections.sort(membersMapper.get(groupName));
        }

        // 풀고 싶은 문제정보를 입력받음
        for(int i=0 ; i<m ; i++) {
            String name = bf.readLine();
            int type = Integer.parseInt(bf.readLine()); // 퀴즈의 종류
            if(type == 0)
                for(String member : membersMapper.get(name))
                    System.out.println(member);
            else System.out.println(groupMapper.get(name));
        }

        bf.close();
        System.exit(0);
    }
}