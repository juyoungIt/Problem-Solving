// BOJ - 15092
// Problem Sheet - https://www.acmicpc.net/problem/15092

import java.util.*;
import java.io.*;

class Station implements Comparable<Station> {
    private final int dist; // 출발 지점으로부터의 거리
    private final int fuel; // 얻을 수 있는 연료

    public Station(int dist, int fuel) {
        this.dist = dist;
        this.fuel = fuel;
    }

    public int getDist() { return this.dist; }
    public int getFuel() { return this.fuel; }

    @Override
    public int compareTo(Station s) { return Integer.compare(this.dist, s.getDist()); }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(bf.readLine()); // 주유소의 수
        Station[] stations = new Station[n];
        for(int i=0 ; i<n ; i++) {
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            stations[i] = new Station(a, b);
        }
        Arrays.sort(stations); // 시작점과의 거리기준 오름차순 정렬
        st = new StringTokenizer(bf.readLine());
        int l = Integer.parseInt(st.nextToken()); // 시작점과 마을의 거리
        int p = Integer.parseInt(st.nextToken()); // 원래 트럭이 가진 연료의 양

        int curIdx = 0; // 현재의 인덱스
        int answer = 0; // 마을에 도착하기 위해 정차해야하는 주요소 정차횟수의 최소값
        PriorityQueue<Integer> fuels = new PriorityQueue<>(Collections.reverseOrder()); // 주유 가능한 연료량
        while(p < l) {
            while(curIdx < n && stations[curIdx].getDist() <= p)
                fuels.add(stations[curIdx++].getFuel());
            if(fuels.isEmpty()) {
                answer = -1;
                break;
            }
            p += fuels.poll();
            answer++;
        }

        System.out.println(answer);

        bf.close();
        System.exit(0);
    }
}