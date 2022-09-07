// BOJ - 1461
// Problem Sheet - https://www.acmicpc.net/problem/1461

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int answer = 0; // 움직여야 하는 거리의 최소값

        int n = Integer.parseInt(st.nextToken()); // 책의 갯수
        int m = Integer.parseInt(st.nextToken()); // 한번에 들 수 있는 책의 갯수

        ArrayList<Integer> negative = new ArrayList<>(); // 음수 좌표들을 저장
        ArrayList<Integer> positive = new ArrayList<>(); // 양수 좌표들을 저장
        st = new StringTokenizer(bf.readLine());
        for(int i=0 ; i<n ; i++) {
            int num = Integer.parseInt(st.nextToken());
            if(num > 0) positive.add(num);
            else negative.add(num);
        }
        Collections.sort(negative); // 입력받은 음수를 크기 순으로 정렬
        Collections.sort(positive); // 입력받은 양수를 크기 순으로 정렬

        // 음수 좌표들에 대하여 다음을 반복
        for(int i=0 ; i<negative.size() ; i+=m)
            answer += negative.get(i) * -2;

        // 양수 좌표들에 대하여 다음을 반복
        for(int i=positive.size()-1 ; i>=0 ; i-=m)
            answer += positive.get(i) * 2;

        // 마지막으로 이동해야하는 책을 찾음 - 이 부분 로직을 보강해야 함
        if(positive.size() == 0)
            answer -= negative.get(0) * -1;
        else if(negative.size() == 0)
            answer -= positive.get(positive.size()-1);
        else {
            if(negative.get(0) * -1 > positive.get(positive.size()-1))
                answer -= negative.get(0) * -1;
            else
                answer -= positive.get(positive.size()-1);
        }

        System.out.println(answer);

        bf.close();
        System.exit(0);
    }
}