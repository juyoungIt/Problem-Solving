// BOJ - 1092
// Problem Sheet - https://www.acmicpc.net/problem/1092

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int answer = 0;

        // 크레인 정보 입력 후, 내림차순으로 정렬하여 구성함
        int n = Integer.parseInt(bf.readLine());
        Integer[] cranes = new Integer[n];
        st = new StringTokenizer(bf.readLine());
        for(int i=0 ; i<n ; i++)
            cranes[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(cranes, Collections.reverseOrder()); // 내림차순 정렬

        // 박스에 대한 정보 입력 후, 내림차순으로 정렬하여 구성함
        int m = Integer.parseInt(bf.readLine());
        ArrayList<Integer> boxes = new ArrayList<>();
        st = new StringTokenizer(bf.readLine());
        for(int i=0 ; i<m ; i++)
            boxes.add(Integer.parseInt(st.nextToken()));
        boxes.sort(Collections.reverseOrder()); // 내림차순 정렬

        // 크레인으로 들어올릴 수 있는 물건이 없는 경우
        if(boxes.get(0) <= cranes[0]) {
            while(!boxes.isEmpty()) {
                int curIdx = 0; // 현재 참조 중인 인덱스
                for(int i=0 ; i<n ; ) {
                    if(curIdx == boxes.size()) break;
                    if(boxes.get(curIdx) <= cranes[i]) {
                        boxes.remove(curIdx);
                        i++;
                    }
                    else
                        curIdx++;
                }
                answer++;
            }
        }

        System.out.println((answer == 0) ? -1 : answer);

        bf.close();
        System.exit(0);
    }
}