// BOJ - 10775
// Problem Sheet - https://www.acmicpc.net/problem/10775

import java.util.*;
import java.io.*;

public class Main {
   public static void main(String[] args) throws IOException {
       BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
       int g = Integer.parseInt(bf.readLine()); // 게이트의 수
       int p = Integer.parseInt(bf.readLine()); // 비행기의 수
       int[] gates = new int[g+1]; // 게이트 배치여부를 저장
       for(int i=1 ; i<g+1 ; i++)
           gates[i] = i;
       int answer = 0; // 최대로 도킹 가능한 비행기의 수

       // 비행기의 정보를 입력받음
       for(int i=0 ; i<p ; i++) {
           int plane = Integer.parseInt(bf.readLine());
           int isDockable = find(gates, plane);
           if(isDockable == 0)
               break;
           else {
               answer++;
               union(gates, plane, gates[plane]-1);
           }
       }

       System.out.println(answer);

       bf.close();
       System.exit(0);
   }

   // 게이트 정보를 갱신함
   public static void union(int[] gates, int a, int b) {
       a = find(gates, a);
       b = find(gates, b);
       gates[a] = b;
   }

   // 해당 비행기가 도킹 가능한 게이트가 있는 지 확인
   public static int find(int[] gates, int x) {
       if(x == gates[x]) return x;
       else return gates[x] = find(gates, gates[x]);
   }
}