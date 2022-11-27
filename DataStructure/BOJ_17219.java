// BOJ - 17219
// Problem Sheet - https://www.acmicpc.net/problem/17219

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        Map<String, String> pwdMapper = new HashMap<>();

        int n = Integer.parseInt(st.nextToken()); // 저장된 사이트 주소의 수
        int m = Integer.parseInt(st.nextToken()); // 찾으려는 사이트 주소의 수

        // 각 사이트 및 비밀번호 정보를 바탕으로 map을 구성함
        for(int i=0 ; i<n ; i++) {
            st = new StringTokenizer(bf.readLine());
            String siteAddress = st.nextToken();
            String password = st.nextToken();
            pwdMapper.put(siteAddress, password);
        }

        // 각 사이트에 대한 비밀번호 정보를 로딩함
        for(int i=0 ; i<m ; i++) {
            String siteAddress = bf.readLine();
            System.out.println(pwdMapper.get(siteAddress));
        }

        bf.close();
        System.exit(0);
    }
}