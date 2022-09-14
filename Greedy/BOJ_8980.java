// BOJ - 12761
// Problem Sheet - https://www.acmicpc.net/problem/12761

import java.util.*;
import java.io.*;

class Request implements Comparable<Request> {
    private final int dept; // 출발지
    private final int dest; // 도착지
    private final int capa; // 택배 상자의 수

    public Request(int dept, int dest, int capa) {
        this.dept = dept;
        this.dest = dest;
        this.capa = capa;
    }

    public int getDept() { return this.dept; }
    public int getDest() { return this.dest; }
    public int getCapa() { return this.capa; }

    @Override
    public int compareTo(Request r) {
        int first = Integer.compare(this.dest, r.getDest());
        if(first != 0) return first;
        else return Integer.compare(this.dept, r.getDept());
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        PriorityQueue<Request> queue = new PriorityQueue<>(); // 택배 요청정보를 우선순위 기준 저장
        int answer = 0; // 최대로 배송 가능한 택배의 수

        int n = Integer.parseInt(st.nextToken()); // 마을의 수
        int c = Integer.parseInt(st.nextToken()); // 트럭의 용량
        int m = Integer.parseInt(bf.readLine()); // 보내는 박스 정보의 수

        int[] towns = new int[n]; // 각 마을당 보낼 수 있는 최대 택배의 수 저장
        Arrays.fill(towns, c);

        // 사용자 입력으로부터 박스 정보를 구성함
        for(int i=0 ; i<m ; i++) {
            st = new StringTokenizer(bf.readLine());
            int dept = Integer.parseInt(st.nextToken());
            int dest = Integer.parseInt(st.nextToken());
            int capa = Integer.parseInt(st.nextToken());
            queue.add(new Request(dept, dest, capa));
        }

        // 정렬한 택배 정보에 대해서 다음을 반복함
        while(!queue.isEmpty()) {
            Request r = queue.poll();
            // 보낼 수 있는 최대 한도를 찾음
            int minCapa = r.getCapa();
            for(int i=r.getDept() ; i<r.getDest() ; i++)
                if(towns[i] < minCapa)
                    minCapa = towns[i];
            // 현재택배수와 최대 한도를 비교
            if(r.getCapa() > minCapa) {
                for(int i=r.getDept() ; i<r.getDest() ; i++)
                    if(towns[i] - minCapa >= 0)
                        towns[i] -= minCapa;
                answer += minCapa;
            }
            else {
                for(int i=r.getDept() ; i<r.getDest() ; i++)
                    if(towns[i] - r.getCapa() >= 0)
                        towns[i] -= r.getCapa();
                answer += r.getCapa();
            }
        }

        System.out.println(answer);

        bf.close();
        System.exit(0);
    }
}