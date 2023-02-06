// BOJ - 14402
// Problem Sheet - https://www.acmicpc.net/problem/14402

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer> accessStatusMapper = new HashMap<>(); // 출근상태정보
        int overtimeWorkerCount = 0; // 야근한 사람의 수

        int accessLogCount = Integer.parseInt(bf.readLine()); // 출입기록의 수
        StringTokenizer st;
        for(int i=0 ; i<accessLogCount ; i++) {
            st = new StringTokenizer(bf.readLine());
            String name = st.nextToken();
            char accessType = st.nextToken().charAt(0);

            if((!accessStatusMapper.containsKey(name) || accessStatusMapper.get(name) == 0) && accessType == '-') {
                overtimeWorkerCount++;
            } else if((!accessStatusMapper.containsKey(name) || accessStatusMapper.get(name) == 0) && accessType == '+') {
                accessStatusMapper.put(name, 1);
            } else if(accessStatusMapper.containsKey(name) && accessType == '-') {
                accessStatusMapper.put(name, accessStatusMapper.get(name) - 1);
            } else {
                accessStatusMapper.put(name, accessStatusMapper.get(name) + 1);
            }
        }

        for(Map.Entry<String, Integer> entry : accessStatusMapper.entrySet()) {
            overtimeWorkerCount += entry.getValue();
        }

        System.out.println(overtimeWorkerCount);

        bf.close();
        System.exit(0);
    }
}